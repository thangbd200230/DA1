/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import ViewModels.QLMauSac;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface MauSacRepository {
    List<MauSac> getAll();
    
    List<QLMauSac> getList();
    
    boolean add(MauSac mauSac);
    
    boolean update(MauSac mauSac, String ma);
    
    boolean delete(String ma);
}
