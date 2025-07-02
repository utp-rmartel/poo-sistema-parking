/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ComprobanteBE;
import BusinessEntity.TarifaBE;
import BusinessEntity.ZonaParkingBE;
import DTOs.EstacionamientoDTO;
import DataAccessObject.ComprobanteDAO;
import DataAccessObject.EstacionamientoDAO;
import DataAccessObject.TarifaDAO;
import DataAccessObject.ZonaParkingDAO;
import Enums.EstadoComprobanteEnum;
import Enums.EstadoZonaParkingEnum;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class ComprobanteBL {
    private ComprobanteDAO comprobanteDAO;
    private ZonaParkingDAO zonaParkingDAO;

    public ComprobanteBL() {
        this.comprobanteDAO = new ComprobanteDAO();
        this.zonaParkingDAO = new ZonaParkingDAO();
    }
    
    public List<ComprobanteBE> obtenerTodo() {
        return comprobanteDAO.ReadAll();
    }
    
    public boolean guardar(EstacionamientoDTO estacionamiento) {
        ComprobanteBE comprobante = new ComprobanteBE();
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String codigo = LocalDateTime.now().format(formato);
        
        comprobante.setId(UUID.randomUUID());
        comprobante.setIdEstacionamiento(UUID.fromString(estacionamiento.getId()));
        comprobante.setNumeroComprobante(codigo);
        comprobante.setTipoTarifa(estacionamiento.getTarifa().getNombre());
        comprobante.setZonaParking(estacionamiento.getZonaParking().getNombre());
        comprobante.setPrecioBase(estacionamiento.getTarifa().getPrecioBase());
        comprobante.setCantidad(estacionamiento.getCantidad());
        comprobante.setMontoTotal(estacionamiento.getTarifa().getPrecioBase() * estacionamiento.getCantidad());
        comprobante.setIdEstado(EstadoComprobanteEnum.PENDIENTE.getValor());
        
        zonaParkingDAO.ActualizarEstado(estacionamiento.getZonaParking().getId(), EstadoZonaParkingEnum.LIBRE.getValor());
        
        return comprobanteDAO.Create(comprobante);
    }
    
}
