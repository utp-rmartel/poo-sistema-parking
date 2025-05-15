/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;


import BusinessEntity.EstacionamientoBE;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class EstacionamientoDAO extends ConexionMySQL implements IBaseDAO<EstacionamientoBE>{

    @Override
    public boolean Create(EstacionamientoBE input) {
         boolean result=false;
        
        try{
            String SQL = "INSERT estacionamientos"
                    + "("
                        + "id,"
                        + "idVehiculo,"
                        + "idZonaParking,"
                        + "idTarifaPrecio,"
                        + "fechaHoraEntrada,"
                        + "idEstado,"
                        + "cantidad"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?,?,?)";
            
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getIdVehiculo().toString());
            pst.setInt(3, input.getIdZonaParking());
            pst.setString(4, input.getIdTarifaPrecio().toString());
            pst.setDate(5, (Date) input.getFechaHoraEntrada());
            pst.setInt(6, input.getIdEstado());
            pst.setInt(7, input.getCantidad());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public EstacionamientoBE Read(String id) {
        EstacionamientoBE item = new EstacionamientoBE();
        try{
            String SQL ="SELECT * FROM estacionamientos WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(id));
                item.setIdVehiculo(UUID.fromString(res.getString("idVehiculo")));
                item.setIdZonaParking(res.getInt("idZonaParking"));
                item.setIdTarifaPrecio(UUID.fromString(res.getString("idTarifaPrecio")));
                item.setFechaHoraEntrada(res.getDate("fechaHoraEntrada"));
                item.setFechaHoraSalida(res.getDate("fechaHoraSalida"));
                item.setIdEstado(res.getInt("idEstado"));   
                item.setCantidad(res.getInt("cantidad"));   
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<EstacionamientoBE> ReadAll() {
        List<EstacionamientoBE> lst = null; 
        try{
            String SQL = "SELECT * FROM estacionamientos WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                EstacionamientoBE item = new EstacionamientoBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setIdVehiculo(UUID.fromString(res.getString("idVehiculo")));
                item.setIdZonaParking(res.getInt("idZonaParking"));
                item.setIdTarifaPrecio(UUID.fromString(res.getString("idTarifaPrecio")));
                item.setFechaHoraEntrada(res.getDate("fechaHoraEntrada"));
                item.setFechaHoraSalida(res.getDate("fechaHoraSalida"));
                item.setIdEstado(res.getInt("idEstado"));   
                item.setCantidad(res.getInt("cantidad"));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(EstacionamientoBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE estacionamientos "
                    + "SET "
                        + "idVehiculo=?,"
                        + "idZonaParking=?,"
                        + "idTarifaPrecio=?,"
                        + "fechaHoraEntrada=?,"
                        + "idEstado=?,"
                        + "cantidad=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
                       
            pst.setString(1, input.getIdVehiculo().toString());
            pst.setInt(2, input.getIdZonaParking());
            pst.setString(3, input.getIdTarifaPrecio().toString());
            pst.setDate(4, (Date) input.getFechaHoraEntrada());
            pst.setInt(5, input.getIdEstado());
            pst.setInt(6, input.getCantidad());
            pst.setString(7, input.getId().toString());
   
            result = pst.execute();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Delete(String id) {
        boolean result = false;
        try {
            String SQL="UPDATE estacionamientos "
                    + "SET "
                        + "activo=0"
                    + "WHERE "
                        + "id=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            result = pst.execute(); 
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }        
        return result;
    }

    
    
}
