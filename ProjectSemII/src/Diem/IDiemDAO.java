/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diem;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface IDiemDAO {
    public ArrayList<Diem> getAll();
    public ArrayList<Diem> findByIDSinhVien(String masv);
    public ArrayList<Diem> findByIDMonHoc(String mamh);
    public Diem addNew(Diem bd);
    public Diem upDate(Diem bd);
    public boolean CheckID(String masv, String mamh, int lanthi);
    public ArrayList<Diem> findMaMH(String masv);
    public ArrayList<Diem> findMasv();
    public ArrayList<Diem> loaddiem(String masv, String maMon);
}
