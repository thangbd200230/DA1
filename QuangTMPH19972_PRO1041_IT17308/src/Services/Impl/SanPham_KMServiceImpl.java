/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.SanPham_KhuyenMai;
import Repositories.Impl.SanPham_KMRepositoryImpl;
import Repositories.SanPham_KMRepository;
import Services.SanPham_KMService;
import ViewModels.QLSanPham_KhuyenMai;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class SanPham_KMServiceImpl implements SanPham_KMService{

    private SanPham_KMRepository sanPham_KMRepository=new SanPham_KMRepositoryImpl();
    @Override
    public List<QLSanPham_KhuyenMai> getAll() {
        return sanPham_KMRepository.getAll();
    }

    @Override
    public String add(SanPham_KhuyenMai sp_KM) {
        boolean testAdd=sanPham_KMRepository.add(sp_KM);
        if(testAdd){
            return "Thêm khuyến mại vào sản phẩm thành công";
        }else{
            return "Thêm khuyến mại vào sản phẩm thất bại";
        }
    }

    @Override
    public List<QLSanPham_KhuyenMai> getOne(String ma) {
        return sanPham_KMRepository.getOne(ma);
    }
    
}
