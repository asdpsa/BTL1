/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class Login {
    public static PreparedStatement ps = null;//biến thực thi câu lệnh sql;
    public static ResultSet rs = null;//kết quả trả về là 1 dòng hoặc 1 bảng
    public static Connection cnn = DBConnect.getConnect();//phương thức kết nối với CSDL;

    public static ResultSet loginUser(String user, String pass) {
        String sql = "SELECT * FROM DangNhap WHERE tenDangNhap =? AND matKhau = ?";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            return rs = ps.executeQuery();
        } catch (Exception e) {
            return rs = null;
        }
    }
}
