/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khoa;

/**
 *
 * @author acer
 */
public class Khoa {
    private String makhoa;
    private String tenkhoa;
    private String thoiGian;

    public Khoa() {
    }

    public Khoa(String makhoa, String tenkhoa, String thoiGian) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.thoiGian = thoiGian;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
    
}
