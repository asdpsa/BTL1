/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiangVien;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface IGiangVienDAO {

    public ArrayList<GiangVien> getAll();
    public GiangVien addNew(GiangVien gv);
    public GiangVien updateByID(GiangVien gv);
    public ArrayList<GiangVien> CheckID(String magv);
}
