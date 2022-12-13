/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LopHoc;

/**
 *
 * @author acer
 */
public class LopHoc {
    private String malop;
    private String tenlop;
    private String maGV;
    private String makhoa;
    private String phongHoc;

    public LopHoc() {
    }

    public LopHoc(String malop, String tenlop, String maGV, String makhoa, String phongHoc) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.maGV = maGV;
        this.makhoa = makhoa;
        this.phongHoc = phongHoc;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    
}
