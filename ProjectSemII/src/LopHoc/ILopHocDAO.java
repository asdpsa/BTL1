/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface ILopHocDAO {
    public ArrayList<LopHoc> getAll();
    public ArrayList<LopHoc> findByIDKhoa(String maKhoa);
    public LopHoc addNew(LopHoc lh);
    public LopHoc updateByID(LopHoc lh);
    public ArrayList<LopHoc> checkID(String malop);
}
