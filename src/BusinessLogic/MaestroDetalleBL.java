/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.MaestroDetalleBE;
import DataAccessObject.MaestroDetalleDAO;
import java.util.List;

/**
 *
 * @author Royss
 */
public class MaestroDetalleBL {
    private MaestroDetalleDAO maestroDetalleDao;

    public MaestroDetalleBL() {
        this.maestroDetalleDao = new MaestroDetalleDAO();
    }
    
    public List<MaestroDetalleBE> obtenerTodoPorMaestro(int idMaestro) {
        return maestroDetalleDao.ReadAllByMaestro(idMaestro);
    }
    
    public MaestroDetalleBE obtenerPorId(int id) {
        return maestroDetalleDao.Read(String.valueOf(id));
    }
}
