/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ZonaParkingBE;
import DataAccessObject.ZonaParkingDAO;
import java.util.List;

/**
 *
 * @author Royss
 */
public class ZonaParkingBL {
    private ZonaParkingDAO zonaParkingDAO;

    public ZonaParkingBL() {
        this.zonaParkingDAO = new ZonaParkingDAO();
    }
    
    public List<ZonaParkingBE> GetAll() {
        return zonaParkingDAO.ReadAll();
    }
    
    public List<ZonaParkingBE> obtenerTodoPorTipoVehiculo(int idTipoVehiculo) {
        return zonaParkingDAO.ReadAllByTipoVehiculo(idTipoVehiculo);
    }
}
