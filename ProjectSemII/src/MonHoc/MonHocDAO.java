/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonHoc;

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
public class MonHocDAO implements IMonHocDAO {

    @Override
    public ArrayList<MonHoc> getAll() {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from MonHoc");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString(1));
                mh.setTenMH(rs.getString(2));
                mh.setSoGio(rs.getInt(3));
                mh.setHinhThucThi(rs.getString(4));
                list.add(mh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<MonHoc> findIDMaMH(String maMH) {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from MonHoc where maMH =?");
            ps.setString(1, maMH);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMH(rs.getString(1));
                mh.setTenMH(rs.getString(2));
                mh.setSoGio(rs.getInt(3));
                mh.setHinhThucThi(rs.getString(4));
                list.add(mh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public MonHoc addNew(MonHoc mh) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("insert into MonHoc(maMH, tenMH,soGio,hinhThucThi) values (?,?,?,?)");
            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getSoGio());
            ps.setString(4, mh.getHinhThucThi());
            int row = ps.executeUpdate();
            if (row < 1) {
                mh = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            mh = null;
        } finally {
            DBConnect.close(ps);
        }
        return mh;
    }

    @Override
    public MonHoc updateByID(MonHoc mh) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update MonHoc set tenMH=?,soGio=?, hinhThucThi =? where maMH =?");
            ps.setString(1, mh.getTenMH());
            ps.setInt(2, mh.getSoGio());
            ps.setString(3, mh.getHinhThucThi());
            ps.setString(4, mh.getMaMH());
            int row = ps.executeUpdate();
            if (row < 1) {
                mh = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            mh = null;
        } finally {
            DBConnect.close();
        }
        return mh;
    }

    public void delMonHoc(String MonHocID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from MonHoc where maMH= ?");
        ps.setString(1, MonHocID);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public ArrayList<MonHoc> CheckID(String mamh) {
        ArrayList<MonHoc> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        try {
            psCheck = DBConnect.getConnect().prepareStatement("select *from MonHoc where maMH=?");
            psCheck.setString(1, mamh);
            rs = psCheck.executeQuery();
            list = new ArrayList<MonHoc>();
            while (rs.next()) {
                MonHoc monHoc = new MonHoc();
                monHoc.setMaMH(rs.getString(1));
                list.add(monHoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(psCheck, rs);
        }
        return list;
    }
}
