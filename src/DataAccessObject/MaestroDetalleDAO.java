/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.MaestroDetalleBE;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author Royss
 */
public class MaestroDetalleDAO extends ConexionMySQL implements IBaseDAO<MaestroDetalleBE>{

    @Override
    public boolean Create(MaestroDetalleBE input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MaestroDetalleBE Read(String id) {
        MaestroDetalleBE item = new MaestroDetalleBE();
        try{
            String SQL ="SELECT * FROM maestrodetalle WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery(); 
            
            while(res.next()){
                item.setId(Integer.parseInt(id));
                item.setIdMaestro(res.getInt("idMaestro"));
                item.setValor(res.getString("valor"));          
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<MaestroDetalleBE> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<MaestroDetalleBE> ReadAllByMaestro(int idMaestro) {
        List<MaestroDetalleBE> lst = null; 
        try{
            String SQL = "SELECT * FROM maestrodetalle WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>(); 
            while(res.next()){
                MaestroDetalleBE item = new MaestroDetalleBE();
                item.setId(res.getInt("id"));
                item.setIdMaestro(res.getInt("idMaestro"));
                item.setValor(res.getString("valor"));           
                
                lst.add(item);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(MaestroDetalleBE input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
