/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author truongmanhquang
 */
public class HoaDonChiTiet {
    private String id;
    private String idHoaDon;
    private String idChiTietSP;
    private String maSP;
    private String tenSP;
    private int soLuong;
    private Double donGia;
    private Double donGiaKhiGiam;
    private Double thanhTien;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSP, int soLuong, Double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTiet(String idChiTietSP, String maSP, String tenSP, int soLuong, Double donGia, int trangThai) {
        this.idChiTietSP = idChiTietSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }


    public HoaDonChiTiet(String id, String idHoaDon, String idChiTietSP, String maSP, String tenSP, int soLuong, Double donGia, int trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(String id, String idHoaDon, String idChiTietSP, String maSP, String tenSP, int soLuong, Double donGia, Double donGiaKhiGiam, Double thanhTien, int trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
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

    public Double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
