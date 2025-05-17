/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.EmpleadoBE;
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
public class EmpleadoDAO extends ConexionMySQL implements IBaseDAO<EmpleadoBE>{

    @Override
    public boolean Create(EmpleadoBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT empleado"
                    + "("
                        + "id,"
                        + "nombre,"
                        + "apellidos,"
                        + "documento,"
                        + "tipoDocumento,"
                        + "telefono"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getApellidos());
            pst.setString(4, input.getDocumento());
            pst.setInt(5, input.getTipoDocumento());
            pst.setString(6, input.getTelefono());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public EmpleadoBE Read(String id) {
        EmpleadoBE item = new EmpleadoBE();
        try{
            String SQL ="SELECT * FROM empleado WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(id));
                item.setNombre(res.getString("nombre"));
                item.setApellidos(res.getString("apellidos"));
                item.setDocumento(res.getString("documento"));
                item.setTipoDocumento(res.getInt("tipoDocumento"));
                item.setTelefono(res.getString("telefono"));            
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<EmpleadoBE> ReadAll() {
       List<EmpleadoBE> lst = null; 
        try{
            String SQL = "SELECT * FROM empleado WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                EmpleadoBE item = new EmpleadoBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombre(res.getString("nombre"));
                item.setApellidos(res.getString("apellidos"));
                item.setDocumento(res.getString("documento"));
                item.setTipoDocumento(res.getInt("tipoDocumento"));
                item.setTelefono(res.getString("telefono"));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(EmpleadoBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE empleado "
                    + "SET "
                        + "nombre=?,"
                        + "apellidos=?,"
                        + "documento=?,"
                        + "tipoDocumento=?,"
                        + "telefono=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getNombre());
            pst.setString(2, input.getApellidos());
            pst.setString(3, input.getDocumento());
            pst.setInt(4, input.getTipoDocumento());
            pst.setString(5, input.getTelefono());
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
            String SQL="UPDATE empleado "
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
