/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author truongmanhquang
 */
public class QLSanPham_KhuyenMai {
    private String tenKM;
    private String maSP;
    private String tenSP;
    private Double donGia;
    private Double donGiaSauKhiGiam;

    public QLSanPham_KhuyenMai() {
    }

    public QLSanPham_KhuyenMai(String tenKM, String maSP, String tenSP, Double donGia, Double donGiaSauKhiGiam) {
        this.tenKM = tenKM;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDonGiaSauKhiGiam() {
        return donGiaSauKhiGiam;
    }

    public void setDonGiaSauKhiGiam(Double donGiaSauKhiGiam) {
        this.donGiaSauKhiGiam = donGiaSauKhiGiam;
    }

    @Override
    public String toString() {
        return "QLSanPham_KhuyenMai{" + "tenKM=" + tenKM + ", maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + ", donGiaSauKhiGiam=" + donGiaSauKhiGiam + '}';
    }

    
    
}
