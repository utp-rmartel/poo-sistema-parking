/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ClienteBE;
import BusinessEntity.EstacionamientoBE;
import BusinessEntity.VehiculoBE;
import BusinessEntity.ZonaParkingBE;
import DTOs.EstacionamientoDTO;
import DataAccessObject.ClienteDAO;
import DataAccessObject.EstacionamientoDAO;
import DataAccessObject.TarifaDAO;
import DataAccessObject.VehiculoDAO;
import DataAccessObject.ZonaParkingDAO;
import Enums.EstadoEstacionamientoEnum;
import Enums.EstadoZonaParkingEnum;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class EstacionamientoBL {

    private EstacionamientoDAO estacionamientoDAO;
    private ClienteDAO clienteDAO;
    private VehiculoDAO vehiculoDAO;
    private ZonaParkingDAO zonaParkingDAO;

    public EstacionamientoBL() {
        this.estacionamientoDAO = new EstacionamientoDAO();
        this.clienteDAO = new ClienteDAO();
        this.vehiculoDAO = new VehiculoDAO();
        this.zonaParkingDAO = new ZonaParkingDAO();
    }

    public boolean guardar(EstacionamientoDTO estacionamientoCrear) throws Exception {

        ZonaParkingBE zonaParking = zonaParkingDAO.Read(String.valueOf(estacionamientoCrear.getZonaParking().getId()));

        if (zonaParking.getIdEstado() == EstadoZonaParkingEnum.OCUPADO.getValor()) {
            throw new Exception("El estacionamiento ya esta ocupado");
        }

        ClienteBE cliente = clienteDAO.ReadByDocumento(estacionamientoCrear.getCliente().getTipoDocumento(), estacionamientoCrear.getCliente().getDocumento());

        if (cliente == null) {
            cliente = crearCliente(estacionamientoCrear.getCliente());
        }

        VehiculoBE vehiculo = vehiculoDAO.ReadByPlaca(estacionamientoCrear.getVehiculo().getPlaca());

        if (vehiculo == null) {
            vehiculo = estacionamientoCrear.getVehiculo();
            vehiculo.setIdCliente(cliente.getId());
            vehiculo = crearVehiculo(vehiculo);
        }

        EstacionamientoBE estacionamiento = new EstacionamientoBE();
        estacionamiento.setId(UUID.randomUUID());
        estacionamiento.setIdVehiculo(vehiculo.getId());
        estacionamiento.setIdTarifa(estacionamientoCrear.getTarifa().getId());
        estacionamiento.setIdZonaParking(estacionamientoCrear.getZonaParking().getId());
        estacionamiento.setCantidad(estacionamientoCrear.getCantidad());
        estacionamiento.setIdEstado(EstadoEstacionamientoEnum.EN_CURSO.getValor());
        estacionamiento.setFechaHoraEntrada(LocalDateTime.now());

        boolean flag = estacionamientoDAO.Create(estacionamiento);

        zonaParkingDAO.ActualizarEstado(estacionamientoCrear.getZonaParking().getId(), EstadoZonaParkingEnum.OCUPADO.getValor());

        return flag;
    }

    public boolean actualizar(EstacionamientoDTO estacionamientoActualizar) {

        EstacionamientoBE estacionamientoBD = estacionamientoDAO.Read(estacionamientoActualizar.getId().toString());

        estacionamientoBD.setCantidad(estacionamientoActualizar.getCantidad());
        estacionamientoBD.setIdTarifa(estacionamientoActualizar.getTarifa().getId());

        if (estacionamientoBD.getIdZonaParking() != estacionamientoActualizar.getZonaParking().getId()) {
            zonaParkingDAO.ActualizarEstado(estacionamientoBD.getIdZonaParking(), EstadoZonaParkingEnum.LIBRE.getValor());
        }

        estacionamientoBD.setIdZonaParking(estacionamientoActualizar.getZonaParking().getId());

        boolean flag = estacionamientoDAO.Update(estacionamientoBD);

        zonaParkingDAO.ActualizarEstado(estacionamientoBD.getIdZonaParking(), EstadoZonaParkingEnum.OCUPADO.getValor());

        return flag;
    }
    
    public boolean actualizarEstado(String id, int idEstado) {
        return estacionamientoDAO.ActualizarEstado(id, idEstado);
    }

    public boolean eliminar(String estacionamientoId) {
        return estacionamientoDAO.Delete(estacionamientoId);
    }
    
    public List<EstacionamientoBE> obtenerTodo() {
        return estacionamientoDAO.ReadAll();
    }

    private ClienteBE crearCliente(ClienteBE cliente) {
        if (cliente.getId() != null) {
            return cliente;
        }

        cliente.setId(UUID.randomUUID());
        clienteDAO.Create(cliente);
        return cliente;
    }

    private VehiculoBE crearVehiculo(VehiculoBE vehiculo) {
        if (vehiculo.getId() != null) {
            return vehiculo;
        }

        vehiculo.setId(UUID.randomUUID());
        vehiculoDAO.Create(vehiculo);
        return vehiculo;
    }

}
