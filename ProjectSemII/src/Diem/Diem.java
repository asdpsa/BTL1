/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diem;

/**
 *
 * @author acer
 */
public class Diem {
    private String maSV;
    private String maMH;
    private int lanThi;
    private float diem;
    private boolean trangThai;

    public Diem() {
    }

    public Diem(String maSV, String maMH, int lanThi, float diem, boolean trangThai) {
        this.maSV = maSV;
        this.maMH = maMH;
        this.lanThi = lanThi;
        this.diem = diem;
        this.trangThai = trangThai;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public int getLanThi() {
        return lanThi;
    }

    public void setLanThi(int lanThi) {
        this.lanThi = lanThi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
