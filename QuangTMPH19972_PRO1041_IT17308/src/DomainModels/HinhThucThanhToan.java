/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author truongmanhquang
 */
public class HinhThucThanhToan {
    private String id;
    private String tenHTTT;
    private Double soTien;
    private int trangThai;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String id, String tenHTTT) {
        this.id = id;
        this.tenHTTT = tenHTTT;
    }

    public HinhThucThanhToan(String id, String tenHTTT, Double soTien, int trangThai) {
        this.id = id;
        this.tenHTTT = tenHTTT;
        this.soTien = soTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenHTTT() {
        return tenHTTT;
    }

    public void setTenHTTT(String tenHTTT) {
        this.tenHTTT = tenHTTT;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenHTTT;
    }
}
