/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author truongmanhquang
 */
public class HoaDon {
    private String id;
    private String idKH;
    private String idNV;
    private String idHTTT;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private String ngayHen;
    private Date ngayNhan;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
    private int giamGia;
    private int trangThai;
    private Double tienShip;

    public HoaDon() {
    }

    public HoaDon(int trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDon(String idHTTT, String tenNguoiNhan, String sdt) {
        this.idHTTT = idHTTT;
        this.tenNguoiNhan = tenNguoiNhan;
        this.sdt = sdt;
    }

    public HoaDon(int trangThai, Date ngayNhan) {
        this.trangThai = trangThai;
        this.ngayNhan = ngayNhan;
    }

    public HoaDon(Date ngayThanhToan, int trangThai) {
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public HoaDon(int trangThai, Date ngayShip, Date ngayThanhToan) {
        this.trangThai = trangThai;
        this.ngayShip = ngayShip;
        this.ngayThanhToan=ngayThanhToan;
    }

    public HoaDon(String tenNguoiNhan, String sdt) {
        this.tenNguoiNhan = tenNguoiNhan;
        this.sdt = sdt;
    }

    public HoaDon(String ma, Date ngayTao, String tenNguoiNhan, String sdt, int trangThai) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public HoaDon(String ma, Date ngayTao, String ngayHen, String tenNguoiNhan, String diaChi, String sdt, int trangThai, Double tienShip) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayHen = ngayHen;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.tienShip = tienShip;
    }

    public HoaDon(String idHTTT, String tenNguoiNhan, String diaChi, String sdt, Double tienShip, String ngayHen) {
        this.idHTTT = idHTTT;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tienShip = tienShip;
        this.ngayHen = ngayHen;
    }
    
    public HoaDon(String id, String ma, Date ngayTao, String tenNguoiNhan, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String ma, Date ngayTao, String tenNguoiNhan, int trangThai,String idHTTT) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.trangThai = trangThai;
        this.idHTTT=idHTTT;
    }

    public HoaDon(String tenNguoiNhan, String diaChi, String sdt, Double tienShip) {
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tienShip = tienShip;
    }

    public HoaDon(String id, String idKH, String idNV, String idHTTT, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, String ngayHen, Date ngayNhan, String tenNguoiNhan, String diaChi, String sdt, int giamGia, int trangThai) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idHTTT = idHTTT;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayHen = ngayHen;
        this.ngayNhan = ngayNhan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String idKH, String idNV, String idHTTT, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, String ngayHen, Date ngayNhan, String tenNguoiNhan, String diaChi, String sdt, int giamGia, int trangThai, Double tienShip) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idHTTT = idHTTT;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayHen = ngayHen;
        this.ngayNhan = ngayNhan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
        this.tienShip = tienShip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(String idHTTT) {
        this.idHTTT = idHTTT;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public String getNgayHen() {
        return ngayHen;
    }

    public void setNgayHen(String ngayHen) {
        this.ngayHen = ngayHen;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Double getTienShip() {
        return tienShip;
    }

    public void setTienShip(Double tienShip) {
        this.tienShip = tienShip;
    }
    
    public String inTrangThai(){
        if(trangThai==0){
            return "Chờ thanh toán";
        }else if(trangThai==2){
            return "Đã huỷ";
        }else if(trangThai==3){
            return "Đang giao";
        }else if(trangThai==4){
            return "Đã giao";
        }else{
            return "Đã thanh toán";
        }
    }
    
    
}
