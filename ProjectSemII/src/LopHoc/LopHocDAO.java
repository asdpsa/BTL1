/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

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
public class LopHocDAO implements ILopHocDAO {

    @Override
    public ArrayList<LopHoc> getAll() {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select *from LopHoc");
            rs = ps.executeQuery();
            list = new ArrayList<LopHoc>();
            while (rs.next()) {
                LopHoc lh = new LopHoc();
                lh.setMalop(rs.getString(1));
                lh.setTenlop(rs.getString(2));
                lh.setMaGV(rs.getString(3));
                lh.setMakhoa(rs.getString(4));
                lh.setPhongHoc(rs.getString(5));
                list.add(lh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public ArrayList<LopHoc> findByIDKhoa(String maKhoa) {
        ArrayList<LopHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("select * from LopHoc where maKhoa = ?");
            ps.setString(1, maKhoa);
            rs = ps.executeQuery();
            list = new ArrayList<LopHoc>();
            while (rs.next()) {
                LopHoc lh = new LopHoc();
                lh.setMalop(rs.getString(1));
                lh.setTenlop(rs.getString(2));
                lh.setMaGV(rs.getString(3));
                lh.setMakhoa(rs.getString(4));
                lh.setPhongHoc(rs.getString(5));
                list.add(lh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(ps, rs);
        }
        return list;
    }

    @Override
    public LopHoc addNew(LopHoc lh) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("insert into LopHoc(maLop,tenLop,maGV,maKhoa,phongHoc) values(?,?,?,?,?)");
            ps.setString(1, lh.getMalop());
            ps.setString(2, lh.getTenlop());
            ps.setString(3, lh.getMaGV());
            ps.setString(4, lh.getMakhoa());
            ps.setString(5, lh.getPhongHoc());
            int row = ps.executeUpdate();
            if (row < 1) {
                lh = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            lh = null;
        } finally {
            DBConnect.close(ps);
        }
        return lh;
    }

    @Override
    public LopHoc updateByID(LopHoc lh) {
        PreparedStatement ps = null;
        try {
            ps = DBConnect.getConnect().prepareStatement("update LopHoc set tenLop = ?, maGV=?, maKhoa=?, phongHoc = ? where maLop = ?");
            ps.setString(1, lh.getTenlop());
            ps.setString(2, lh.getMaGV());
            ps.setString(3, lh.getMakhoa());
            ps.setString(4, lh.getPhongHoc());
            ps.setString(5, lh.getMalop());
            int row = ps.executeUpdate();
            if (row < 1) {
                lh = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            lh = null;
        } finally {
            DBConnect.close();
        }
        return lh;
    }

    public void deleteLopHoc(String LopID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        ps = DBConnect.getConnect().prepareStatement("delete from LopHoc where maLop= ?");
        ps.setString(1, LopID);
        ps.executeUpdate();
        DBConnect.close();
    }

    @Override
    public ArrayList<LopHoc> checkID(String malop) {
        ArrayList<LopHoc> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        try {
            psCheck = DBConnect.getConnect().prepareStatement("select *from LopHoc where maLop= ?");
            psCheck.setString(1, malop);
            rs = psCheck.executeQuery();
            list = new ArrayList<LopHoc>();
            while (rs.next()) {
                LopHoc lh = new LopHoc();
                lh.setMalop(rs.getString(1));
                list.add(lh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnect.close(psCheck, rs);
        }
        return list;
    }
}
