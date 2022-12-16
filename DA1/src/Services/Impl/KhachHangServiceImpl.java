/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.KhachHang;
import Repositories.Impl.KhachHangRepositoryImpl;
import Repositories.KhachHangRepository;
import Services.KhachHangService;
import ViewModels.QlKhachHang;
import java.util.List;

/**
 *
 * @author thang
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangRepository khachhangrepo = new KhachHangRepositoryImpl();
    @Override
    public List<QlKhachHang> getAll() {
     return  khachhangrepo.getAll();
    }

    @Override
    public QlKhachHang getOne(String ma) {
         return  khachhangrepo.getOne(ma);
    }

    @Override
    public String add(KhachHang khachHang) {
       boolean add = khachhangrepo.add(khachHang);
       if(add==true){
           return "Thêm thông tin khách hàng thành công";
       }else{
           return "Thêm thông tin khách hàng thất bại";
       }
    }

    @Override
    public String update(KhachHang khachHang, String Ma) {
        boolean update = khachhangrepo.update(khachHang, Ma);
       if(update==true){
           return "Sửa thành công";
       }else{
           return "Sửa thất bại";
       }
    }

    @Override
    public String delete(String Ma) {
    boolean delete = khachhangrepo.delete(Ma);
       if(delete==true){
           return "Xoá thành công";
       }else{
           return "Xoá thất bại";
       }
    }

    @Override
    public List<QlKhachHang> Search(String ma) {
       return  khachhangrepo.Search(ma);
    }

    @Override
    public List<QlKhachHang> SearchTrangThai(int trangthai) {
         return  khachhangrepo.SearchTrangThai(trangthai);
    }

   
}
