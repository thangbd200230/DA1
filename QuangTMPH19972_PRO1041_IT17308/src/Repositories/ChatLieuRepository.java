/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ChatLieu;
import ViewModels.QLChatLieu;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface ChatLieuRepository {
    List<ChatLieu> getAll();
    
    List<QLChatLieu> getList();
    
    boolean add(ChatLieu chatLieu);
    
    boolean update(ChatLieu chatLieu, String ma);
    
    boolean delete(String ma);
}
