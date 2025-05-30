/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TarifaBE;
import BusinessEntity.TarifaPrecioBE;
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
public class TarifaPrecioDAO extends ConexionMySQL implements IBaseDAO<TarifaPrecioBE> {

    @Override
    public boolean Create(TarifaPrecioBE input) {
        boolean result = false;

        try {
            String SQL = "INSERT TarifaPrecio"
                    + "("
                    + "id,"
                    + "idTarifa,"
                    + "idTipoTarifa,"
                    + "precioBase,"
                    + "precioAdicional"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getId().toString());
            pst.setInt(2, input.getIdTarifa());
            pst.setInt(3, input.getIdTipoTarifa());
            pst.setDouble(4, input.getPrecioBase());
            pst.setDouble(5, input.getPrecioAdicional());

            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public TarifaPrecioBE Read(String id) {
        TarifaPrecioBE item = new TarifaPrecioBE();
        try {
            String SQL = "SELECT * FROM TarifaPrecio WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                item.setId(UUID.fromString(id));
                item.setIdTarifa(res.getInt("idTarifa"));
                item.setIdTipoTarifa(res.getInt("idTipoTarifa"));
                item.setPrecioBase(res.getDouble("precioBase"));
                item.setPrecioAdicional(res.getDouble("precioAdicional"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<TarifaPrecioBE> ReadAll() {
        List<TarifaPrecioBE> lst = null;
        try {
            String SQL = "SELECT * FROM TarifaPrecio WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>();
            while (res.next()) {
                TarifaPrecioBE item = new TarifaPrecioBE();
                item.setId(UUID.fromString(res.getString("id")));
                item.setIdTarifa(res.getInt("idTarifa"));
                item.setIdTipoTarifa(res.getInt("idTipoTarifa"));
                item.setPrecioBase(res.getDouble("precioBase"));
                item.setPrecioAdicional(res.getDouble("precioAdicional"));

                lst.add(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(TarifaPrecioBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE TarifaPrecio "
                    + "SET "
                    + "idTarifa=?,"
                    + "idTipoTarifa=?,"
                    + "precioBase=?,"
                    + "precioAdicional=?"
                    + "WHERE "
                    + "id=?";

            PreparedStatement pst = getConexion().prepareStatement(SQL);

            pst.setInt(1, input.getIdTarifa());
            pst.setInt(2, input.getIdTipoTarifa());
            pst.setDouble(3, input.getPrecioBase());
            pst.setDouble(4, input.getPrecioAdicional());
            pst.setString(5, input.getId().toString());

            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Delete(String id) {
        boolean result = false;
        try {
            String SQL = "UPDATE TarifaPrecio "
                    + "SET "
                    + "activo=0"
                    + "WHERE "
                    + "id=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
