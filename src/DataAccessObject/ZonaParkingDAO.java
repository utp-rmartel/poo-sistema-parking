/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.ZonaParkingBE;
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
public class ZonaParkingDAO extends ConexionMySQL implements IBaseDAO<ZonaParkingBE>{

    @Override
    public boolean Create(ZonaParkingBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT zonaparking"
                    + "("
                        + "id,"
                        + "nombre,"
                        + "descripcion,"
                        + "idEstado,"
                        + "idTipoZona"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setInt(1, input.getId());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getDescripcion());
            pst.setInt(4, input.getIdEstado());
            pst.setInt(5, input.getIdTipoZona());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ZonaParkingBE Read(String id) {
        ZonaParkingBE item = new ZonaParkingBE();
        try{
            String SQL ="SELECT * FROM zonaparking WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(Integer.parseInt(id));
                item.setNombre(res.getString("nombre"));
                item.setDescripcion(res.getString("descripcion"));
                item.setIdEstado(res.getInt("idEstado"));
                item.setIdTipoZona(res.getInt("idTipoZona"));        
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<ZonaParkingBE> ReadAll() {
        List<ZonaParkingBE> lst = null; 
        try{
            String SQL = "SELECT * FROM zonaparking WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                ZonaParkingBE item = new ZonaParkingBE();
                item.setId(res.getInt("id"));
                item.setNombre(res.getString("nombre"));
                item.setDescripcion(res.getString("descripcion"));
                item.setIdEstado(res.getInt("idEstado"));
                item.setIdTipoZona(res.getInt("idTipoZona"));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(ZonaParkingBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE zonaparking "
                    + "SET "
                        + "nombre=?,"
                        + "descripcion=?,"
                        + "idEstado=?,"
                        + "idTipoZona=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            
            pst.setString(1, input.getNombre());
            pst.setString(2, input.getDescripcion());
            pst.setInt(3, input.getIdEstado());
            pst.setInt(4, input.getIdTipoZona());
            pst.setInt(5, input.getId());
   
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
            String SQL="UPDATE zonaparking "
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
