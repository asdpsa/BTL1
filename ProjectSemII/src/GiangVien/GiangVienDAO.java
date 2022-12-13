/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiangVien;

import ConnectDatabase.DBConnect;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class GiangVienDAO implements IGiangVienDAO {

    @Override
    public ArrayList<GiangVien> getAll() {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select * from GiangVien");
            rs = ps.executeQuery();
            list = new ArrayList<GiangVien>();
            while (rs.next()) {
                GiangVien gv = new GiangVien();
                gv.setMaGV(rs.getString(1));
                gv.setTenGV(rs.getString(2));
                gv.setNgaySinh(new Date(rs.getDate(3).getTime()));
                gv.setGioiTinh(rs.getString(4));
                gv.setEmail(rs.getString(5));
                gv.setDiaChi(rs.getString(6));
                gv.setsDT(rs.getString(7));
                list.add(gv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public GiangVien addNew(GiangVien gv) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("INSERT INTO GiangVien values (?,?,?,?,?,?,?)");
            ps.setString(1, gv.getMaGV());
            ps.setString(2, gv.getTenGV());
            ps.setDate(3, new java.sql.Date(gv.getNgaySinh().getTime()));
            ps.setString(4, gv.getGioiTinh());
            ps.setString(5, gv.getEmail());
            ps.setString(6, gv.getDiaChi());
            ps.setString(7, gv.getsDT());
            int row = ps.executeUpdate();
            if (row < 1) {
                gv = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            gv = null;
        } finally {
            DBConnect.close(ps);
        }
        return gv;
    }

    @Override
    public GiangVien updateByID(GiangVien gv) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update GiangVien set tenGV = ?, ngaySinh = ?, gioiTinh = ?, email = ?, diaChi = ?, sDT = ? where maGV = ?");
            ps.setString(1, gv.getTenGV());
            ps.setDate(2, new java.sql.Date(gv.getNgaySinh().getTime()));
            ps.setString(3, gv.getGioiTinh());
            ps.setString(4, gv.getEmail());
            ps.setString(5, gv.getDiaChi());
            ps.setString(6, gv.getsDT());
            ps.setString(7, gv.getMaGV());
            int row = ps.executeUpdate();
            if (row < 1) {
                gv = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            gv = null;
        } finally {
            DBConnect.close();
        }
        return gv;
    }

    public void deleteIDGV(String GiaoVienID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from GiangVien where maGV= ?");
        ps.setString(1, GiaoVienID);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public ArrayList<GiangVien> CheckID(String magv) {
        ArrayList<GiangVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        try {
            psCheck = DBConnect.getConnect().prepareStatement("select *from GiangVien where maGV = ?");
            psCheck.setString(1, magv);
            rs = psCheck.executeQuery();
            list = new ArrayList<GiangVien>();
            while (rs.next()) {
                GiangVien giangVien = new GiangVien();
                giangVien.setMaGV(rs.getString(1));
                list.add(giangVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(psCheck, rs);
        }
        return list;
    }

}
