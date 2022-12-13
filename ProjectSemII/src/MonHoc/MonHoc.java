/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonHoc;

/**
 *
 * @author acer
 */
public class MonHoc {
    private String maMH;
    private String tenMH;
    private int soGio;
    private String hinhThucThi;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, int soGio, String hinhThucThi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soGio = soGio;
        this.hinhThucThi = hinhThucThi;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        this.hinhThucThi = hinhThucThi;
    }
    
}
