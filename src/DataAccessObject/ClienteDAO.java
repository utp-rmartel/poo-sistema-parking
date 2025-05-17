/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.ClienteBE;
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
public class ClienteDAO extends ConexionMySQL implements IBaseDAO<ClienteBE>{

    @Override
    public boolean Create(ClienteBE input) {
        boolean result=false;
        
        try{
            String SQL = "INSERT cliente"
                    + "("
                        + "id,"
                        + "nombre,"
                        + "apellidos,"
                        + "documento,"
                        + "tipoDocumento,"
                        + "telefono,"
                        + "email"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getApellidos());
            pst.setString(4, input.getDocumento());
            pst.setInt(5, input.getTipoDocumento());
            pst.setString(6, input.getTelefono());
            pst.setString(7, input.getEmail());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ClienteBE Read(String id) {
        ClienteBE item = new ClienteBE();
        try{
            String SQL ="SELECT * FROM cliente WHERE id=? and activo = 1";
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
                item.setEmail(res.getString("email"));             
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<ClienteBE> ReadAll() {
        List<ClienteBE> lst = null; 
        try{
            String SQL = "SELECT * FROM cliente WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                ClienteBE item = new ClienteBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setNombre(res.getString("nombre"));
                item.setApellidos(res.getString("apellidos"));
                item.setDocumento(res.getString("documento"));
                item.setTipoDocumento(res.getInt("tipoDocumento"));
                item.setTelefono(res.getString("telefono"));
                item.setEmail(res.getString("email")); 
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(ClienteBE input) {
        boolean result = false;
        try{
            String SQL="UPDATE cliente "
                    + "SET "
                        + "nombre=?,"
                        + "apellidos=?,"
                        + "documento=?,"
                        + "tipoDocumento=?,"
                        + "telefono=?,"
                        + "email=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getNombre());
            pst.setString(2, input.getApellidos());
            pst.setString(3, input.getDocumento());
            pst.setInt(4, input.getTipoDocumento());
            pst.setString(5, input.getTelefono());
            pst.setString(6, input.getEmail());
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
            String SQL="UPDATE cliente "
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
