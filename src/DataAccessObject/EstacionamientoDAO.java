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
import java.sql.Timestamp;
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
            String SQL = "INSERT Estacionamiento"
                    + "("
                        + "id,"
                        + "idVehiculo,"
                        + "idZonaParking,"
                        + "idTarifa,"
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
            pst.setString(4, input.getIdTarifa().toString());
            pst.setTimestamp(5, Timestamp.valueOf(input.getFechaHoraEntrada()));
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
            String SQL ="SELECT * FROM estacionamiento WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(id));
                item.setIdVehiculo(UUID.fromString(res.getString("idVehiculo")));
                item.setIdZonaParking(res.getInt("idZonaParking"));
                item.setIdTarifa(UUID.fromString(res.getString("idTarifa")));
                item.setFechaHoraEntrada(res.getTimestamp("fechaHoraEntrada").toLocalDateTime());
                item.setFechaHoraSalida(res.getTimestamp("fechaHoraSalida").toLocalDateTime());
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
            String SQL = "SELECT * FROM Estacionamiento WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                EstacionamientoBE item = new EstacionamientoBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setIdVehiculo(UUID.fromString(res.getString("idVehiculo")));
                item.setIdZonaParking(res.getInt("idZonaParking"));
                item.setIdTarifa(UUID.fromString(res.getString("idTarifa")));
                item.setFechaHoraEntrada(res.getTimestamp("fechaHoraEntrada").toLocalDateTime());
                item.setFechaHoraSalida(res.getTimestamp("fechaHoraSalida").toLocalDateTime());
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
            String SQL="UPDATE estacionamiento "
                    + "SET "
                        + "idVehiculo=?,"
                        + "idZonaParking=?,"
                        + "idTarifa=?,"
                        + "fechaHoraEntrada=?,"
                        + "idEstado=?,"
                        + "cantidad=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
                       
            pst.setString(1, input.getIdVehiculo().toString());
            pst.setInt(2, input.getIdZonaParking());
            pst.setString(3, input.getIdTarifa().toString());
            pst.setTimestamp(4, Timestamp.valueOf(input.getFechaHoraEntrada()));
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
            String SQL="UPDATE estacionamiento "
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
