/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import ConnectDatabase.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class SinhVienDAO implements ISinhVienDAO {

    @Override
    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from SinhVien");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setMaLop(rs.getString(3));
                sv.setDiaChi(rs.getString(4));
                sv.setNgaySinh(new Date(rs.getDate(5).getTime()));
                sv.setGioiTinh(rs.getString(6));
                sv.setsDT(rs.getString(7));
                list.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> findByIDLop(String maLop) {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select * from SinhVien where maLop like ? ");
            ps.setString(1, maLop);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
               SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setMaLop(rs.getString(3));
                sv.setDiaChi(rs.getString(4));
                sv.setNgaySinh(new Date(rs.getDate(5).getTime()));
                sv.setGioiTinh(rs.getString(6));
                sv.setsDT(rs.getString(7));
                list.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public SinhVien addNew(SinhVien sv) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("insert into SinhVien(maSV,tenSV,maLop,diaChi,ngaySinh,gioiTinh,sDT) values (?,?,?,?,?,?,?)");
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSV());
            ps.setString(3, sv.getMaLop());
            ps.setString(4, sv.getDiaChi());
            ps.setDate(5, new java.sql.Date(sv.getNgaySinh().getTime()));
            ps.setString(6, sv.getGioiTinh());
            ps.setString(7, sv.getsDT());
            int row = ps.executeUpdate();
            if (row < 1) {
                sv = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            sv = null;
        } finally {
            DBConnect.close(ps);
        }
        return sv;
    }

    @Override
    public SinhVien updateByID(SinhVien sv) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update SinhVien set tenSV = ?, maLop = ?, diaChi = ?, ngaySinh = ?, gioiTinh = ?, sDT = ? where maSV = ?");
            ps.setString(1, sv.getTenSV());
            ps.setString(2, sv.getMaLop());
            ps.setString(3, sv.getDiaChi());
            ps.setDate(4, new java.sql.Date(sv.getNgaySinh().getTime()));
            ps.setString(5, sv.getGioiTinh());
            ps.setString(6, sv.getsDT());
            ps.setString(7, sv.getMaSV());
            if (ps.executeUpdate() < 1) {
                sv = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close();
        }
        return sv;
    }

    public void deleteIDSinhVien(String SinhVienID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from SinhVien where maSV= ?");
        ps.setString(1, SinhVienID);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public ArrayList<SinhVien> CheckID(String masv) {
        ArrayList<SinhVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        try {
            psCheck = DBConnect.getConnect().prepareStatement("select *from SinhVien where maSV= ?");
            psCheck.setString(1, masv);
            rs = psCheck.executeQuery();
            list = new ArrayList<SinhVien>();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSV(rs.getString(1));
                list.add(sinhVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(psCheck, rs);
        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> getAllByIDSV(String maSV) {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
                ps = DBConnect.getConnect().prepareStatement("select * from SinhVien where maSV like ? ");
                ps.setString(1, maSV);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMaSV(rs.getString(1));
                    sv.setTenSV(rs.getString(2));
                    sv.setMaLop(rs.getString(3));
                    sv.setDiaChi(rs.getString(4));
                    sv.setNgaySinh(new Date(rs.getDate(5).getTime()));
                    sv.setGioiTinh(rs.getString(6));
                    sv.setsDT(rs.getString(7));
                    list.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        return list;
    }
}
