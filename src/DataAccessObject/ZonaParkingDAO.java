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
public class ZonaParkingDAO extends ConexionMySQL implements IBaseDAO<ZonaParkingBE> {

    @Override
    public boolean Create(ZonaParkingBE input) {
        boolean result = false;

        try {
            String SQL = "INSERT ZonaParking"
                    + "("
                    + "id,"
                    + "nombre,"
                    + "idEstado,"
                    + "idTipoVehiculo"
                    + ")"
                    + "VALUES"
                    + "(?,?,?,?)";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setInt(1, input.getId());
            pst.setString(2, input.getNombre());
            pst.setInt(3, input.getIdEstado());
            pst.setInt(4, input.getIdTipoVehiculo());

            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ZonaParkingBE Read(String id) {
        ZonaParkingBE item = new ZonaParkingBE();
        try {
            String SQL = "SELECT * FROM ZonaParking WHERE id=? and activo = 1";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, id);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                item.setId(Integer.parseInt(id));
                item.setNombre(res.getString("nombre"));
                item.setIdEstado(res.getInt("idEstado"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public List<ZonaParkingBE> ReadAll() {
        List<ZonaParkingBE> lst = null;
        try {
            String SQL = "SELECT * FROM ZonaParking WHERE activo = 1";
            Statement stm = getConexion().createStatement();
            ResultSet res = stm.executeQuery(SQL);
            lst = new ArrayList<>();
            while (res.next()) {
                ZonaParkingBE item = new ZonaParkingBE();
                item.setId(res.getInt("id"));
                item.setNombre(res.getString("nombre"));
                item.setIdEstado(res.getInt("idEstado"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));

                lst.add(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    public List<ZonaParkingBE> ReadAllByTipoVehiculo(int idTipoVehiculo) {
        List<ZonaParkingBE> lst = null;
        try {
            String SQL = "SELECT * FROM ZonaParking WHERE activo = 1 and idTipoVehiculo=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setInt(1, idTipoVehiculo);
            ResultSet res = pst.executeQuery();
            lst = new ArrayList<>();
            while (res.next()) {
                ZonaParkingBE item = new ZonaParkingBE();
                item.setId(res.getInt("id"));
                item.setNombre(res.getString("nombre"));
                item.setIdEstado(res.getInt("idEstado"));
                item.setIdTipoVehiculo(res.getInt("idTipoVehiculo"));

                lst.add(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public boolean Update(ZonaParkingBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE ZonaParking "
                    + "SET "
                    + "nombre=?, "
                    + "idEstado=?, "
                    + "idTipoVehiculo=? "
                    + "WHERE "
                    + "id=? ";

            PreparedStatement pst = getConexion().prepareStatement(SQL);

            pst.setString(1, input.getNombre());
            pst.setInt(2, input.getIdEstado());
            pst.setInt(3, input.getIdTipoVehiculo());
            pst.setInt(4, input.getId());

            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean ActualizarEstado(int id, int idEstado) {
        boolean result = false;
        try {
            String SQL = "UPDATE ZonaParking "
                    + "SET "
                    + "idEstado = ? "
                    + "WHERE "
                    + "id = ? ";

            PreparedStatement pst = getConexion().prepareStatement(SQL);

            pst.setInt(1, idEstado);
            pst.setInt(2, id);

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
            String SQL = "UPDATE ZonaParking "
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
