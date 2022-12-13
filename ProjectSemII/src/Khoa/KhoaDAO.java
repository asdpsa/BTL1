/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khoa;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class KhoaDAO implements IKhoaDAO {

    @Override
    public ArrayList<Khoa> getAll() {
        ArrayList<Khoa> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from Khoa");
            rs = ps.executeQuery();
            list = new ArrayList<Khoa>();
            while (rs.next()) {
                Khoa k = new Khoa();
                k.setMakhoa(rs.getString(1));
                k.setTenkhoa(rs.getString(2));
                k.setThoiGian(rs.getString(3));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public Khoa addNew(Khoa khoa) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("INSERT INTO Khoa values (?,?,?)");
            ps.setString(1, khoa.getMakhoa());
            ps.setString(2, khoa.getTenkhoa());
            ps.setString(3, khoa.getThoiGian());
            int row = ps.executeUpdate();
            if (row < 1) {
                khoa = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            khoa = null;
        } finally {
            DBConnect.close(ps);
        }
        return khoa;
    }

    public void deleteKhoa(String KhoaID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from Khoa where maKhoa = ?");
        ps.setString(1, KhoaID);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public Khoa updateByID(Khoa khoa) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update Khoa set tenKhoa =?, thoiGian= ? where maKhoa = ?");
            ps.setString(1, khoa.getTenkhoa());
            ps.setString(2, khoa.getThoiGian());
            ps.setString(3, khoa.getMakhoa());
            int row = ps.executeUpdate();
            if (row < 1) {
                khoa = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            khoa = null;
        } finally {
            DBConnect.close();
        }
        return khoa;
    }

    @Override
    public ArrayList<Khoa> checkID(String makhoa) {
        ArrayList<Khoa> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        try {
            psCheck = DBConnect.getConnect().prepareStatement("select *from Khoa where maKhoa = ?");
            psCheck.setString(1, makhoa);
            rs = psCheck.executeQuery();
            list = new ArrayList<Khoa>();
            while (rs.next()) {
                Khoa k = new Khoa();
                k.setMakhoa(rs.getString(1));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(psCheck, rs);
        }
        return list;
    }
}
