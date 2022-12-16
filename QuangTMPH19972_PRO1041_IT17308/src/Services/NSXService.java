/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NSX;
import ViewModels.QLNSX;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface NSXService {
    List<NSX> getAll();
    
    List<QLNSX> getList();
    
    String add(NSX nSX);
    
    String update(NSX nSX,String ma);
    
    String delete(String ma);
}
