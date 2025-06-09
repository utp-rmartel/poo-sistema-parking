/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TarifaBE;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Royss
 */
public class TarifaDAO extends ConexionMySQL implements IBaseDAO<TarifaBE>{

    @Override
    public boolean Create(TarifaBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT Tarifa"
                    + "("
                        + "id,"
                        + "nombre,"    
                        + "idTipoVehiculo,"
                        + "precioBase"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getNombre());
            pst.setInt(3, input.getIdTipoVehiculo());
            pst.setDouble(4, input.getPrecioBase());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public TarifaBE Read(String id) {
       TarifaBE item = new TarifaBE();
        try{
            String SQL ="SELECT * FROM Tarifa WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombre(res.getString("nombre"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));  
                item.setPrecioBase(res.getDouble("precioBase"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<TarifaBE> ReadAll() {
        List<TarifaBE> lst = null; 
        try{
            String SQL = "SELECT * FROM tarifa WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                TarifaBE item = new TarifaBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombre(res.getString("nombre"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));  
                item.setPrecioBase(res.getDouble("precioBase"));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public List<TarifaBE> ReadAllByTipoVehiculo(int idTipoVehiculo) {
        List<TarifaBE> lst = null; 
        try{
            String SQL = "SELECT * FROM Tarifa WHERE activo = 1 and idTipoVehiculo=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setInt(1, idTipoVehiculo);
            ResultSet res = pst.executeQuery(); 
            lst = new ArrayList<>(); 
            while(res.next()){
                TarifaBE item = new TarifaBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombre(res.getString("nombre"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));  
                item.setPrecioBase(res.getDouble("precioBase"));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(TarifaBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE Tarifa "
                    + "SET "
                        + "nombre=?,"    
                        + "idTipoVehiculo=?,"
                        + "precioBase=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getNombre());
            pst.setInt(2, input.getIdTipoVehiculo());
            pst.setDouble(3, input.getPrecioBase());
            pst.setString(4, input.getId().toString());
   
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
            String SQL="UPDATE tarifa "
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
