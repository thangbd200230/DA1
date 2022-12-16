/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author truongmanhquang
 */
public class QLKhuyenMai {
    private String id;
    private String ma;
    private String ten;
    private int loaiKM;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int mucGiamGiaTheoPhanTram;
    private Double mucGiamGiaTheoTien;
    private int trangThai;

    public QLKhuyenMai() {
    }

    public QLKhuyenMai(String ma, String ten, int loaiKM, String ngayBatDau, String ngayKetThuc, int mucGiamGiaTheoPhanTram, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.loaiKM = loaiKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGiaTheoPhanTram = mucGiamGiaTheoPhanTram;
        this.trangThai = trangThai;
    }

    public QLKhuyenMai(String ma, String ten, int loaiKM, String ngayBatDau, String ngayKetThuc, Double mucGiamGiaTheoTien, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.loaiKM = loaiKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGiaTheoTien = mucGiamGiaTheoTien;
        this.trangThai = trangThai;
    }

    public QLKhuyenMai(String ma, String ten, int loaiKM, String ngayBatDau, String ngayKetThuc, int mucGiamGiaTheoPhanTram, Double mucGiamGiaTheoTien, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.loaiKM = loaiKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGiaTheoPhanTram = mucGiamGiaTheoPhanTram;
        this.mucGiamGiaTheoTien = mucGiamGiaTheoTien;
        this.trangThai = trangThai;
    }

    public QLKhuyenMai(String id, String ma, String ten, int loaiKM, String ngayBatDau, String ngayKetThuc, int mucGiamGiaTheoPhanTram, Double mucGiamGiaTheoTien, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiKM = loaiKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.mucGiamGiaTheoPhanTram = mucGiamGiaTheoPhanTram;
        this.mucGiamGiaTheoTien = mucGiamGiaTheoTien;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLoaiKM() {
        return loaiKM;
    }

    public void setLoaiKM(int loaiKM) {
        this.loaiKM = loaiKM;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMucGiamGiaTheoPhanTram() {
        return mucGiamGiaTheoPhanTram;
    }

    public void setMucGiamGiaTheoPhanTram(int mucGiamGiaTheoPhanTram) {
        this.mucGiamGiaTheoPhanTram = mucGiamGiaTheoPhanTram;
    }

    public Double getMucGiamGiaTheoTien() {
        return mucGiamGiaTheoTien;
    }

    public void setMucGiamGiaTheoTien(Double mucGiamGiaTheoTien) {
        this.mucGiamGiaTheoTien = mucGiamGiaTheoTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String inLoaiKM(){
        if(loaiKM==0){
            return "Giảm theo %";
        }else if(loaiKM==1){
            return "Giảm theo tiền";
        }else{
            return "Không có";
        }
    }
    
    public String inTrangThai(){
        if(trangThai==0){
            return "Ngừng áp dụng";
        }else if(trangThai==1){
            return "Đang áp dụng";
        }else{
            return "Không có";
        }
    }
}
