/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;


import DomainModels.SanPham;
import Repositories.Impl.SanPhamRepositoryImpl;
import Repositories.SanPhamRepository;
import Services.SanPhamService;
import ViewModels.QLSanPham;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class SanPhamServiceImpl implements SanPhamService{

    private SanPhamRepository sanPhamRepository=new SanPhamRepositoryImpl();
    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String add(SanPham sp) {
        boolean testAdd=sanPhamRepository.add(sp);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sp, String ma) {
        boolean testUpdate=sanPhamRepository.update(sp, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =sanPhamRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLSanPham> getList() {
        return sanPhamRepository.getList();
    }

    
    
    
}
