/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.ComprobanteBE;
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
public class ComprobanteDAO extends ConexionMySQL implements IBaseDAO<ComprobanteBE>{

    @Override
    public boolean Create(ComprobanteBE input) {
        boolean result=false;
        
        try{
              String SQL = "INSERT Comprobante"
                    + "("
                        + "id,"
                        + "idEstacionamiento,"
                        + "numeroComprobante,"
                        + "tipoTarifa,"
                        + "zonaParking,"
                        + "precioBase,"
                        + "precioAdicional,"
                        + "montoTotal,"
                        + "idMetodoPago,"
                        + "fechaPago"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst= getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setString(2, input.getIdEstacionamiento().toString());
            pst.setString(3, input.getNumeroComprobante());
            pst.setString(4, input.getTipoTarifa());
            pst.setString(5, input.getZonaParking());
            pst.setDouble(6, input.getPrecioBase());
            pst.setDouble(7, input.getPrecioAdicional());
            pst.setDouble(8, input.getMontoTotal());
            pst.setInt(9, input.getIdMetodoPago());
            pst.setDate(10, (Date) input.getFechaPago());
            
            result = pst.execute();            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ComprobanteBE Read(String id) {
        ComprobanteBE item = new ComprobanteBE();
        try{
            String SQL ="SELECT * FROM Comprobante WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(UUID.fromString(id));          
                item.setIdEstacionamiento(UUID.fromString("idEstacionamiento"));
                item.setNumeroComprobante(res.getString("numeroComprobante"));
                item.setTipoTarifa(res.getString("tipoTarifa"));
                item.setZonaParking(res.getString("zonaParking"));
                item.setPrecioBase(res.getDouble("precioBase"));
                item.setPrecioAdicional(res.getDouble("precioAdicional"));
                item.setMontoTotal(res.getDouble("montoTotal"));
                item.setIdMetodoPago(res.getInt("idMetodoPago"));
                item.setFechaPago(res.getDate("fechaPago"));           
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<ComprobanteBE> ReadAll() {
        List<ComprobanteBE> lst = null; 
        try{
            String SQL = "SELECT * FROM comprobante WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                ComprobanteBE item = new ComprobanteBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setIdEstacionamiento(UUID.fromString("idEstacionamiento"));
                item.setNumeroComprobante(res.getString("numeroComprobante"));
                item.setTipoTarifa(res.getString("tipoTarifa"));
                item.setZonaParking(res.getString("zonaParking"));
                item.setPrecioBase(res.getDouble("precioBase"));
                item.setPrecioAdicional(res.getDouble("precioAdicional"));
                item.setMontoTotal(res.getDouble("montoTotal"));
                item.setIdMetodoPago(res.getInt("idMetodoPago"));
                item.setFechaPago(res.getDate("fechaPago"));  
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;

    }

    @Override
    public boolean Update(ComprobanteBE input) {
         boolean result = false;
        try{
            String SQL="UPDATE comprobante "
                    + "SET "
                        + "idEstacionamiento=?,"
                        + "numeroComprobante=?,"
                        + "tipoTarifa=?,"
                        + "zonaParking=?,"
                        + "precioBase=?,"
                        + "precioAdicional=?,"
                        + "montoTotal=?,"
                        + "idMetodoPago=?,"
                        + "fechaPago=?"
                    + "WHERE "
                        + "id=?";
            
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            
            pst.setString(1, input.getIdEstacionamiento().toString());
            pst.setString(2, input.getNumeroComprobante());
            pst.setString(3, input.getTipoTarifa());
            pst.setString(4, input.getZonaParking());
            pst.setDouble(5, input.getPrecioBase());
            pst.setDouble(6, input.getPrecioAdicional());
            pst.setDouble(7, input.getMontoTotal());
            pst.setInt(8,input.getIdMetodoPago());
            pst.setDate(9, (Date) input.getFechaPago());
            pst.setString(10, input.getId().toString());
   
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
            String SQL="UPDATE Comprobante "
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
