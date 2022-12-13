/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diem;

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
public class DiemDAO implements IDiemDAO {

    @Override
    public ArrayList<Diem> getAll() {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from Diem");
            rs = ps.executeQuery();
            list = new ArrayList<Diem>();
            while (rs.next()) {
                Diem bd = new Diem();
                bd.setMaSV(rs.getString(1));
                bd.setMaMH(rs.getString(2));
                bd.setLanThi(rs.getInt(3));
                bd.setDiem(rs.getFloat(4));
                bd.setTrangThai(rs.getBoolean(5));
                list.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<Diem> findByIDSinhVien(String masv) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select * from Diem where maSV like ? ");
            ps.setString(1, masv);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Diem bd = new Diem();
                bd.setMaMH(rs.getString(2));
                bd.setLanThi(rs.getInt(3));
                bd.setDiem(rs.getFloat(4));
                bd.setTrangThai(rs.getBoolean(5));
                list.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<Diem> findByIDMonHoc(String mamh) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
                ps = DBConnect.getConnect().prepareStatement("select * from Diem where maMH = ?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setMaSV(rs.getString(1));
                    bd.setMaMH(rs.getString(2));
                    bd.setLanThi(rs.getInt(3));
                    bd.setDiem(rs.getFloat(4));
                    bd.setTrangThai(rs.getBoolean(5));
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        return list;
    }

    @Override
    public Diem addNew(Diem bd) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("insert into Diem (maSV,maMH,lanThi,diem,trangThai) values (?,?,?,?,?)");
            ps.setString(1, bd.getMaSV());
            ps.setString(2, bd.getMaMH());
            ps.setInt(3, bd.getLanThi());
            ps.setFloat(4, bd.getDiem());
            ps.setBoolean(5, bd.isTrangThai());
            int row = ps.executeUpdate();
            if (row < 1) {
                bd = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps);
        }
        return bd;
    }

    @Override
    public Diem upDate(Diem bd) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update Diem set  diem = ?,trangThai=?, lanThi=? where maSV =? and maMH =?");
            ps.setFloat(1, bd.getDiem());
            ps.setBoolean(2, bd.isTrangThai());
            ps.setInt(3, bd.getLanThi());
            ps.setString(4, bd.getMaSV());
            ps.setString(5, bd.getMaMH());
            
            int row = ps.executeUpdate();
            if (row < 1) {
                bd = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close();
        }
        return bd;
    }

    public void delBangDiem(String MaSV, String MaMH, int LanThi) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from Diem where maSV =? and maMH =?");
        ps.setString(1, MaSV);
        ps.setString(2, MaMH);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public boolean CheckID(String masv, String mamh, int lanthi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Diem> findMaMH(String masv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Diem> findMasv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Diem> loaddiem(String masv, String maMon) {
        ArrayList<Diem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
                ps = DBConnect.getConnect().prepareStatement("select diem from Diem where maMH =? and maSV=?");
                ps.setString(1, maMon);
                ps.setString(2, masv);
                rs = ps.executeQuery();
                list = new ArrayList<Diem>();
                while (rs.next()) {
                    Diem bd = new Diem();
                    bd.setDiem(rs.getFloat("Diem"));
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
        }
        return list;
    }

}
