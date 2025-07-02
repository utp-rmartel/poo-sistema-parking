/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.VehiculoBE;
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
public class VehiculoDAO extends ConexionMySQL implements IBaseDAO<VehiculoBE>{

    @Override
    public boolean Create(VehiculoBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT Vehiculo"
                    + "("
                        + "id,"
                        + "placa,"
                        + "marca,"
                        + "modelo,"
                        + "color,"
                        + "idTipoVehiculo,"
                        + "idCliente"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?,?,?)";
            
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getPlaca());
            pst.setString(3, input.getMarca());
            pst.setString(4, input.getModelo());
            pst.setString(5, input.getColor());
            pst.setInt(6, input.getIdTipoVehiculo());
            pst.setString(7, input.getIdCliente().toString());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public VehiculoBE Read(String id) {
        VehiculoBE item = null;
        try{
            String SQL ="SELECT * FROM Vehiculo WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item = new VehiculoBE();
                item.setId(UUID.fromString(id));
                item.setPlaca(res.getString("placa"));
                item.setMarca(res.getString("marca"));
                item.setModelo(res.getString("modelo"));
                item.setColor(res.getString("color"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));
                item.setIdCliente(UUID.fromString(res.getString("idCliente")));             
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }
    
    public VehiculoBE ReadByPlaca(String placa) {
        VehiculoBE item = null;
        try{
            String SQL ="SELECT * FROM Vehiculo WHERE placa=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, placa);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item = new VehiculoBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setPlaca(res.getString("placa"));
                item.setMarca(res.getString("marca"));
                item.setModelo(res.getString("modelo"));
                item.setColor(res.getString("color"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));
                item.setIdCliente(UUID.fromString(res.getString("idCliente")));             
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<VehiculoBE> ReadAll() {
        List<VehiculoBE> lst = null; 
        try{
            String SQL = "SELECT * FROM Vehiculo WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                VehiculoBE item = new VehiculoBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setPlaca(res.getString("placa"));
                item.setMarca(res.getString("marca"));
                item.setModelo(res.getString("modelo"));
                item.setColor(res.getString("color"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));
                item.setIdCliente(UUID.fromString(res.getString("idCliente")));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(VehiculoBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE vehiculo "
                    + "SET "
                        + "placa=?,"
                        + "marca=?,"
                        + "modelo=?,"
                        + "color=?,"
                        + "idCliente=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getPlaca());
            pst.setString(2, input.getMarca());
            pst.setString(3, input.getModelo());
            pst.setString(4, input.getColor());
            pst.setString(5, input.getIdCliente().toString());
            pst.setString(6, input.getId().toString());

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
            String SQL="UPDATE vehiculo "
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
