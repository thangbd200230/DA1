/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author truongmanhquang
 */
public class ChiTietSP {
    private String idChiTietSP;
    private String idSP;
    private String idNSX;
    private String idMauSac;
    private String idDongSP;
    private String idChatLieu;
    private String idKichCo;
    private String idKieuDang;
    private String idKM;
    private double giaBan;
    private double giaNhap;
    private int soLuong;
    private String moTa;
    private int trangThai;

    public ChiTietSP() {
    }

    public ChiTietSP(String idChiTietSP, String idSP, String idNSX, String idMauSac, String idDongSP, String idChatLieu, String idKichCo, String idKieuDang, String idKM, double giaBan, double giaNhap, int soLuong, String moTa, int trangThai) {
        this.idChiTietSP = idChiTietSP;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.idChatLieu = idChatLieu;
        this.idKichCo = idKichCo;
        this.idKieuDang = idKieuDang;
        this.idKM = idKM;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getIdKichCo() {
        return idKichCo;
    }

    public void setIdKichCo(String idKichCo) {
        this.idKichCo = idKichCo;
    }

    public String getIdKieuDang() {
        return idKieuDang;
    }

    public void setIdKieuDang(String idKieuDang) {
        this.idKieuDang = idKieuDang;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
