/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.TarifaBE;
import BusinessEntity.ZonaParkingBE;
import DataAccessObject.TarifaDAO;
import java.util.List;

/**
 *
 * @author Royss
 */
public class TarifaBL {
    private TarifaDAO tarifaDAO;

    public TarifaBL() {
        this.tarifaDAO = new TarifaDAO();
    }
    
    public List<TarifaBE> obtenerTodo() {
        return tarifaDAO.ReadAll();
    }
    
    public List<TarifaBE> obtenerTodoPorTipoVehiculo(int idTipoVehiculo) {
        return tarifaDAO.ReadAllByTipoVehiculo(idTipoVehiculo);
    }
    
    public TarifaBE obtenerPorId(String id) {
        return tarifaDAO.Read(id);
    }
}
