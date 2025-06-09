/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ClienteBE;
import BusinessEntity.EstacionamientoBE;
import BusinessEntity.VehiculoBE;
import DTOs.EstacionamientoCrearDTO;
import DataAccessObject.ClienteDAO;
import DataAccessObject.EstacionamientoDAO;
import DataAccessObject.TarifaDAO;
import DataAccessObject.VehiculoDAO;
import Enums.EstadoEstacionamientoEnum;
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

    public EstacionamientoBL() {
        this.estacionamientoDAO = new EstacionamientoDAO();
        this.clienteDAO = new ClienteDAO();
        this.vehiculoDAO = new VehiculoDAO();
    }

    public boolean guardar(EstacionamientoCrearDTO estacionamientoCrear) {
        
        ClienteBE cliente = crearCliente(estacionamientoCrear.getCliente());
        
        VehiculoBE vehiculo = estacionamientoCrear.getVehiculo();
        vehiculo.setIdCliente(cliente.getId());
        vehiculo = crearVehiculo(vehiculo);
        
        EstacionamientoBE estacionamiento = new EstacionamientoBE();
        estacionamiento.setId(UUID.randomUUID());
        estacionamiento.setIdVehiculo(vehiculo.getId());
        estacionamiento.setIdTarifa(estacionamientoCrear.getTarifa().getId());
        estacionamiento.setIdZonaParking(estacionamientoCrear.getZonaParking().getId());
        estacionamiento.setCantidad(estacionamientoCrear.getCantidad());
        estacionamiento.setIdEstado(EstadoEstacionamientoEnum.EN_CURSO.getValor());
        estacionamiento.setFechaHoraEntrada(LocalDateTime.now());
        
        return estacionamientoDAO.Create(estacionamiento);
    }
    
    public List<EstacionamientoBE> obtenerTodo(){
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
