/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author truongmanhquang
 */
public class QLHoaDon {
    private String ma;
    private String tenNV;
    private String tenKH;
    private Date ngayTao;
    private int trangThai;
    

    public QLHoaDon() {
    }

    public QLHoaDon(int trangThai) {
        this.trangThai = trangThai;
    }

    public QLHoaDon(String ma, Date ngayTao, int trangThai) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public QLHoaDon(String ma, String tenNV, String tenKH, Date ngayTao, int trangThai) {
        this.ma = ma;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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
