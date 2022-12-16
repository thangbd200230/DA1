/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NhanVien;
import Repositories.Impl.NhanVienRepositoryImpl;
import Repositories.NhanVienRepository;
import Services.NhanVienService;
import ViewModels.QLNhanVien;
import java.util.List;

/**
 *
 * @author thang
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanvienrepo = new NhanVienRepositoryImpl();

    @Override
    public List<QLNhanVien> getAll() {
        return nhanvienrepo.getAll();
    }

    @Override
    public QLNhanVien getOne(String ma) {
        return nhanvienrepo.getOne(ma);
    }

    @Override
    public String add(NhanVien NhanVien) {
        boolean add = nhanvienrepo.add(NhanVien);
        if (add == true) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien NhanVien, String ma) {
        boolean update = nhanvienrepo.update(NhanVien, ma);
        if (update == true) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = nhanvienrepo.delete(ma);
        if (delete == true) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLNhanVien> Search(String ma) {
        return nhanvienrepo.Search(ma);
    }

    @Override
    public List<QLNhanVien> SearchTrangThai1(int trangThai) {
        return nhanvienrepo.SearchTrangThai1(trangThai);
    }

    @Override
    public List<QLNhanVien> SearchTrangThai2(String chucVu) {
        return nhanvienrepo.SearchTrangThai2(chucVu);
    }

}
