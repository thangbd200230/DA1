/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import ViewModels.QLNSX;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface NSXRepository {
    List<NSX> getAll();
    
    List<QLNSX> getList();
    
    boolean add(NSX nSX);
    
    boolean update(NSX nSX, String ma);
    
    boolean delete(String ma);
}
