/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;

/**
 *
 * @author truongmanhquang
 */
public interface TaiKhoanService {
    TaiKhoan getOne(String name);

    boolean checkLogin(String userName, String pass);
    
    boolean update(TaiKhoan tk,String tenTK);
}
