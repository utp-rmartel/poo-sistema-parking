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
            String SQL = "INSERT tarifa"
                    + "("
                        + "id,"
                        + "idTipoZona,"
                        + "idTipoVehiculo"
                    + ")"
                    + "VALUES"
                    + "(?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setInt(1, input.getId());
            pst.setInt(2, input.getIdTipoZona());
            pst.setInt(3, input.getIdTipoVehiculo());
            
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
            String SQL ="SELECT * FROM tarifa WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(Integer.parseInt(id));
                item.setIdTipoZona(res.getInt("idTipoZona"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));          
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
                item.setId(res.getInt("id"));
                item.setIdTipoZona(res.getInt("idTipoZona"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));   
                
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
            String SQL="UPDATE tarifa "
                    + "SET "
                        + "idTipoZona=?,"
                        + "idTipoVehiculo=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setInt(1, input.getIdTipoZona());
            pst.setInt(2, input.getIdTipoVehiculo());
            pst.setInt(3, input.getId());
   
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
