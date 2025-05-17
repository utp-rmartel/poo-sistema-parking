/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.UsuarioBE;
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
public class UsuarioDAO extends ConexionMySQL implements IBaseDAO<UsuarioBE>{

    @Override
    public boolean Create(UsuarioBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT usuario"
                    + "("
                        + "id,"
                        + "nombreUsuario,"
                        + "contrasenia,"
                        + "idRol,"
                        + "idEmpleado"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getNombreUsuario());
            pst.setString(3, input.getContrasenia());
            pst.setInt(4, input.getIdRol());
            pst.setString(5, input.getIdEmpleado().toString());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public UsuarioBE Read(String id) {
        UsuarioBE item = new UsuarioBE();
        try{
            String SQL ="SELECT * FROM usuario WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(id));
                item.setNombreUsuario(res.getString("nombreUsuario"));
                item.setContrasenia(res.getString("contrasenia"));
                item.setIdRol(res.getInt("idRol"));
                item.setIdEmpleado(UUID.fromString(res.getString("idEmpleado")));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<UsuarioBE> ReadAll() {
        List<UsuarioBE> lst = null; 
        try{
            String SQL = "SELECT * FROM usuario WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                UsuarioBE item = new UsuarioBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombreUsuario(res.getString("nombreUsuario"));
                item.setContrasenia(res.getString("contrasenia"));
                item.setIdRol(res.getInt("idRol"));
                item.setIdEmpleado(UUID.fromString(res.getString("idEmpleado")));
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(UsuarioBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE usuario "
                    + "SET "
                        + "nombreUsuario=?,"
                        + "contrasenia=?,"
                        + "idRol=?,"
                        + "idEmpleado=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getNombreUsuario());
            pst.setString(2, input.getContrasenia());
            pst.setInt(3, input.getIdRol());
            pst.setString(4, input.getIdEmpleado().toString());
            pst.setString(5, input.getId().toString());

   
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
            String SQL="UPDATE usuario "
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
