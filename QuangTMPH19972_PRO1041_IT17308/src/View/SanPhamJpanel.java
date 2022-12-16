/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.ChatLieu;
import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.KichCo;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Services.ChatLieuService;
import Services.ChiTietSPService;
import Services.DongSPService;
import Services.Impl.ChatLieuServiceImpl;
import Services.Impl.ChiTietSPServiceImpl;
import Services.Impl.DongSPServiceImpl;
import Services.Impl.KichCoServiceImpl;
import Services.Impl.KieuDangServiceImpl;
import Services.Impl.MauSacServiceImpl;
import Services.Impl.NSXServiceImpl;
import Services.Impl.SanPhamServiceImpl;
import Services.KichCoService;
import Services.KieuDangService;
import Services.MauSacService;
import Services.NSXService;
import Services.SanPhamService;
import ViewModels.QLChatLieu;
import ViewModels.QLChiTietSP;
import ViewModels.QLDongSP;
import ViewModels.QLKichCo;
import ViewModels.QLKieuDang;
import ViewModels.QLMauSac;
import ViewModels.QLNSX;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truongmanhquang
 */
public class SanPhamJpanel extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private List<QLChiTietSP> listQLCTSP = new ArrayList<>();
    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImpl();

    private DefaultComboBoxModel dcbmTenSP = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmMauSac = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmKieuDang = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmDongSP = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmChatLieu = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmKichCo = new DefaultComboBoxModel();

    private List<ChatLieu> listChatLieu = new ArrayList<>();
    private List<DongSP> listDongSP = new ArrayList<>();
    private List<KichCo> listKichCo = new ArrayList<>();
    private List<KieuDang> listKieuDang = new ArrayList<>();
    private List<MauSac> listMauSac = new ArrayList<>();
    private List<NSX> listNSX = new ArrayList<>();
    private List<SanPham> listSP = new ArrayList<>();

    private List<QLChatLieu> listQLChatLieu = new ArrayList<>();
    private List<QLDongSP> listQLDongSP = new ArrayList<>();
    private List<QLKichCo> listQLKichCo = new ArrayList<>();
    private List<QLKieuDang> listQLKieuDang = new ArrayList<>();
    private List<QLMauSac> listQLMauSac = new ArrayList<>();
    private List<QLNSX> listQLNSX = new ArrayList<>();
    private List<QLSanPham> listQLSP = new ArrayList<>();

    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();
    private DongSPService dongSPService = new DongSPServiceImpl();
    private KichCoService kichCoService = new KichCoServiceImpl();
    private KieuDangService kieuDangService = new KieuDangServiceImpl();
    private MauSacService mauSacService = new MauSacServiceImpl();
    private NSXService nSXService = new NSXServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    /**
     * Creates new form SanPhamJpanel
     */
    public SanPhamJpanel() {
        initComponents();

        tbSanPham.setModel(dtm);
        tbThuocTinh.setModel(dtm1);
        String[] headers = {"ID", "Mã SP", "Tên SP", "Màu sắc", "Chất liệu", "Kiểu dáng", "Kích cỡ", "Dòng sản phẩm", "NSX", "Giá bán", "Giá nhập", "Số lượng", "Mô tả", "Trạng thái"};
        dtm.setColumnIdentifiers(headers);
        String[] header = {"STT", "Mã thuộc tính", "Tên thuộc tính", "Trạng thái"};
        dtm1.setColumnIdentifiers(header);

        cbbChatLieu.setModel(dcbmChatLieu);
        cbbDongSP.setModel(dcbmDongSP);
        cbbKichCo.setModel(dcbmKichCo);
        cbbKieuDang.setModel(dcbmKieuDang);
        cbbMauSac.setModel(dcbmMauSac);
        cbbNSX.setModel(dcbmNSX);
        cbbTenSP.setModel(dcbmTenSP);

        listQLCTSP = chiTietSPService.getAll();
        showData(listQLCTSP);
        listChatLieu = chatLieuService.getAll();
        listDongSP = dongSPService.getAll();
        listKichCo = kichCoService.getAll();
        listKieuDang = kieuDangService.getAll();
        listMauSac = mauSacService.getAll();
        listNSX = nSXService.getAll();
        listSP = sanPhamService.getAll();

        listQLChatLieu = chatLieuService.getList();
        listQLDongSP = dongSPService.getList();
        listQLKichCo = kichCoService.getList();
        listQLKieuDang = kieuDangService.getList();
        listQLMauSac = mauSacService.getList();
        listQLNSX = nSXService.getList();
        listQLSP = sanPhamService.getList();

        showDataTableChatLieu(listQLChatLieu);
        showDataTableDongSP(listQLDongSP);
        showDataTableKichCo(listQLKichCo);
        showDataTableKieuDang(listQLKieuDang);
        showDataTableMauSac(listQLMauSac);
        showDataTableNSX(listQLNSX);
        showDataTableSP(listQLSP);

        showDataComboboxChatLieu(listChatLieu);
        showDataComboboxDongSP(listDongSP);
        showDataComboboxKichCo(listKichCo);
        showDataComboboxKieuDang(listKieuDang);
        showDataComboboxMauSac(listMauSac);
        showDataComboboxNSX(listNSX);
        showDataComboboxSP(listSP);
    }

    private void showData(List<QLChiTietSP> listQLCTSP) {
        dtm.setRowCount(0);
        for (QLChiTietSP qLChiTietSP : listQLCTSP) {
            dtm.addRow(new Object[]{
                qLChiTietSP.getId(), qLChiTietSP.getMaSP(), qLChiTietSP.getTenSP(), qLChiTietSP.getMauSac(), qLChiTietSP.getChatLieu(), qLChiTietSP.getKieuDang(),
                qLChiTietSP.getKichCo(), qLChiTietSP.getDongSP(), qLChiTietSP.getNSX(), qLChiTietSP.getGiaBan(), qLChiTietSP.getGiaNhap(),
                qLChiTietSP.getSoLuong(), qLChiTietSP.getMoTa(), qLChiTietSP.inTrangThai()
            });
        }
    }

    private void showDataTableChatLieu(List<QLChatLieu> listQLChatLieu) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLChatLieu qLChatLieu : listQLChatLieu) {
            dtm1.addRow(new Object[]{
                i++, qLChatLieu.getMa(), qLChatLieu.getTen(), qLChatLieu.inTrangThai()
            });
        }
    }

    private void showDataTableDongSP(List<QLDongSP> listQLDongSP) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLDongSP qLDongSP : listQLDongSP) {
            dtm1.addRow(new Object[]{
                i++, qLDongSP.getMa(), qLDongSP.getTen(), qLDongSP.inTrangThai()
            });
        }
    }

    private void showDataTableKichCo(List<QLKichCo> listQLKichCo) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLKichCo qLKichCo : listQLKichCo) {
            dtm1.addRow(new Object[]{
                i++, qLKichCo.getMa(), qLKichCo.getTen(), qLKichCo.inTrangThai()
            });
        }
    }

    private void showDataTableKieuDang(List<QLKieuDang> listQLKieuDang) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLKieuDang qLKieuDang : listQLKieuDang) {
            dtm1.addRow(new Object[]{
                i++, qLKieuDang.getMa(), qLKieuDang.getTen(), qLKieuDang.inTrangThai()
            });
        }
    }

    private void showDataTableMauSac(List<QLMauSac> listQLMauSac) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLMauSac qLMauSac : listQLMauSac) {
            dtm1.addRow(new Object[]{
                i++, qLMauSac.getMa(), qLMauSac.getTen(), qLMauSac.inTrangThai()
            });
        }
    }

    private void showDataTableNSX(List<QLNSX> listQlNSX) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLNSX qlnsx : listQlNSX) {
            dtm1.addRow(new Object[]{
                i++, qlnsx.getMa(), qlnsx.getTen(), qlnsx.inTrangThai()
            });
        }
    }

    private void showDataTableSP(List<QLSanPham> listQLSanPham) {
        dtm1.setRowCount(0);
        int i = 1;
        for (QLSanPham qLSanPham : listQLSanPham) {
            dtm1.addRow(new Object[]{
                i++, qLSanPham.getMa(), qLSanPham.getTen(), qLSanPham.inTrangThai()
            });
        }
    }

    public ChatLieu getDataChatLieu() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        ChatLieu chatLieu = new ChatLieu(null, maTT, tenTT, trangThai);
        return chatLieu;
    }

    public DongSP getDataDongSP() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        DongSP dongSP = new DongSP(null, maTT, tenTT, trangThai);
        return dongSP;
    }

    public KichCo getDataKichCo() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        KichCo kichCo = new KichCo(null, maTT, tenTT, trangThai);
        return kichCo;
    }

    public KieuDang getDataKieuDang() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        KieuDang kieuDang = new KieuDang(null, maTT, tenTT, trangThai);
        return kieuDang;
    }

    public MauSac getDataMauSac() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        MauSac mauSac = new MauSac(null, maTT, tenTT, trangThai);
        return mauSac;
    }

    public NSX getDataNSX() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        NSX nSX = new NSX(null, maTT, tenTT, trangThai);
        return nSX;
    }

    public SanPham getDataSanPham() {
        String maTT = txtMaTT.getText();
        String tenTT = txtTenTT.getText();
        int trangThai = 0;
        if (cbbTrangThaiTT.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        SanPham sp = new SanPham(null, maTT, tenTT, trangThai);
        return sp;
    }

    private void showDataComboboxChatLieu(List<ChatLieu> listChatLieu) {
        for (ChatLieu chatLieu : listChatLieu) {
            dcbmChatLieu.addElement(chatLieu.getTen());
        }
    }

    private void showDataComboboxDongSP(List<DongSP> listDongSP) {
        for (DongSP dongSP : listDongSP) {
            dcbmDongSP.addElement(dongSP.getTen());
        }
    }

    private void showDataComboboxKichCo(List<KichCo> listKichCo) {
        for (KichCo kichCo : listKichCo) {
            dcbmKichCo.addElement(kichCo.getTen());
        }
    }

    private void showDataComboboxKieuDang(List<KieuDang> listKieuDang) {
        for (KieuDang kieuDang : listKieuDang) {
            dcbmKieuDang.addElement(kieuDang.getTen());
        }
    }

    private void showDataComboboxMauSac(List<MauSac> listMauSac) {
        for (MauSac mauSac : listMauSac) {
            dcbmMauSac.addElement(mauSac.getTen());
        }
    }

    private void showDataComboboxNSX(List<NSX> listNSX) {
        for (NSX nsx : listNSX) {
            dcbmNSX.addElement(nsx.getTen());
        }
    }

    private void showDataComboboxSP(List<SanPham> listSP) {
        for (SanPham sanPham : listSP) {
            dcbmTenSP.addElement(sanPham.getTen());
        }
    }

    private ChiTietSP getData() {
        int indexChatLieu = cbbChatLieu.getSelectedIndex();
        ChatLieu chatLieu = listChatLieu.get(indexChatLieu);
        int indexDongSP = cbbDongSP.getSelectedIndex();
        DongSP dongSP = listDongSP.get(indexDongSP);
        int indexKichCo = cbbKichCo.getSelectedIndex();
        KichCo kichCo = listKichCo.get(indexKichCo);
        int indexKieuDang = cbbKieuDang.getSelectedIndex();
        KieuDang kieuDang = listKieuDang.get(indexKieuDang);
        int indexMauSac = cbbMauSac.getSelectedIndex();
        MauSac mauSac = listMauSac.get(indexMauSac);
        int indexNSX = cbbNSX.getSelectedIndex();
        NSX nSX = listNSX.get(indexNSX);
        int indexSP = cbbTenSP.getSelectedIndex();
        SanPham sanPham = listSP.get(indexSP);
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        String moTa = txtMoTa.getText();
        int trangThai = 0;
        if (cbbTrangThai.getSelectedIndex() == 1) {
            trangThai = 1;
        }
        ChiTietSP chiTietSP = new ChiTietSP(null, sanPham.getId(), nSX.getId(), mauSac.getId(), dongSP.getId(), chatLieu.getId(), kichCo.getId(), kieuDang.getId(), null, giaBan, giaNhap, soLuong, moTa, trangThai);
        return chiTietSP;
    }

    private void reset() {
        cbbTenSP.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        cbbDongSP.setSelectedIndex(0);
        cbbKichCo.setSelectedIndex(0);
        cbbKieuDang.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        cbbNSX.setSelectedIndex(0);
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtSoLuong.setText("");
        txtMoTa.setText("");
        cbbTrangThai.setSelectedIndex(0);
    }

    private void clear() {
        txtMaTT.setText("");
        txtTenTT.setText("");
        cbbTrangThaiTT.setSelectedIndex(0);
    }

    public void checkCTSP(){
        if(txtGiaBan.getText().trim().isEmpty()||txtGiaBan.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống giá bán");
            return;
        }
        if(txtGiaNhap.getText().trim().isEmpty()||txtGiaNhap.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống giá nhập");
            return;
        }
        if(txtSoLuong.getText().trim().isEmpty()||txtSoLuong.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống số lượng");
            return;
        }
        if(txtMoTa.getText().trim().isEmpty()||txtMoTa.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống mô tả");
            return;
        }
    }
    
    public void checkTT(){
        if(txtMaTT.getText().trim().isEmpty()||txtMaTT.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống mã thuộc tính");
            return;
        }
        if(txtTenTT.getText().trim().isEmpty()||txtTenTT.getText()==null){
            JOptionPane.showMessageDialog(this, "Không để trống tên thuộc tính");
            return;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbbSearchTT = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        cbbKichCo = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbKieuDang = new javax.swing.JComboBox<>();
        cbbDongSP = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbTenSP = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtTenTT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoKieuDang = new javax.swing.JRadioButton();
        rdoDongSP = new javax.swing.JRadioButton();
        rdoKichCo = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        rdoNSX = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbbTrangThaiTT = new javax.swing.JComboBox<>();
        rdoTenSP = new javax.swing.JRadioButton();
        btnThemTT = new javax.swing.JButton();
        btnSuaTT = new javax.swing.JButton();
        btnXoaTT = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThuocTinh = new javax.swing.JTable();

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(985, 723));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(975, 690));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm sản phẩm");

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSearch.setBackground(new java.awt.Color(255, 255, 204));
        btnSearch.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bản sao 211818_search_icon_20px.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbbSearchTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));
        cbbSearchTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(211, 211, 211)
                .addComponent(cbbSearchTT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch)
                    .addComponent(btnSearch)
                    .addComponent(cbbSearchTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách sản phẩm");

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Màu sắc ", "Chất liệu", "Kiểu dáng", "Kích cỡ", "Dòng sản phẩm", "NSX", "Giá bán ", "Giá nhập", "Số lượng", "Mô tả", "Trạng thái"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1146, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel5.setText("Màu sắc");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel6.setText("Kiểu dáng");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel7.setText("Dòng sản phẩm");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel8.setText("Giá nhập");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel9.setText("Tên SP");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel10.setText("Chất liệu");

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel11.setText("Kích cỡ");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setText("Giá bán");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel13.setText("Số lượng");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel14.setText("Mô tả");

        cbbKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L" }));
        cbbKichCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKichCoMouseClicked(evt);
            }
        });

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trắng", "Đen" }));
        cbbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbMauSacMouseClicked(evt);
            }
        });

        cbbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basic", "Street" }));
        cbbKieuDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKieuDangMouseClicked(evt);
            }
        });

        cbbDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo", "Quần" }));
        cbbDongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbDongSPMouseClicked(evt);
            }
        });

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vải", "Da" }));
        cbbChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChatLieuMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setText("Nhà sản xuất");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setText("Trạng thái");

        cbbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo thun", "Áo vest", "Quần short", "Quần âu" }));
        cbbTenSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTenSPMouseClicked(evt);
            }
        });
        cbbTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenSPActionPerformed(evt);
            }
        });

        cbbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adidas", "LV", "Teelab" }));
        cbbNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNSXMouseClicked(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaNhap)
                            .addComponent(cbbDongSP, 0, 234, Short.MAX_VALUE)
                            .addComponent(cbbNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton5)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbKieuDang, 0, 237, Short.MAX_VALUE)
                            .addComponent(cbbTenSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(cbbKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cbbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnThem.setBackground(new java.awt.Color(255, 204, 204));
        btnThem.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 204, 204));
        btnSua.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/172618_update_icon 20px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 204, 204));
        btnXoa.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3643729_bin_delete_garbage_rubbish_trash_icon 20px.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(255, 204, 204));
        btnMoi.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/9855519_reset_reload_sync_update_icon 20px.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 1017, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnThem)
                .addGap(68, 68, 68)
                .addComponent(btnSua)
                .addGap(90, 90, 90)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 157, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
        );

        jTabbedPane2.addTab("Quản Lý Sản Phẩm", jPanel3);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTenTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("Tên thuộc tính");

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoMauSac.setText("Màu Sắc");
        rdoMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMauSacMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoKieuDang);
        rdoKieuDang.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoKieuDang.setText("Kiểu Dáng");
        rdoKieuDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoKieuDangMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDongSP);
        rdoDongSP.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoDongSP.setText("Dòng sản phẩm");
        rdoDongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDongSPMouseClicked(evt);
            }
        });
        rdoDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDongSPActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKichCo);
        rdoKichCo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoKichCo.setText("Kích Cỡ");
        rdoKichCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoKichCoMouseClicked(evt);
            }
        });
        rdoKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKichCoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChatLieuMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoNSX);
        rdoNSX.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoNSX.setText("NSX");
        rdoNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNSXMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setText("Mã thuộc tính");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setText("Trạng thái");

        cbbTrangThaiTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hoạt động", "Ngừng hoạt động" }));

        buttonGroup1.add(rdoTenSP);
        rdoTenSP.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rdoTenSP.setText("Tên sản phẩm");
        rdoTenSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTenSPMouseClicked(evt);
            }
        });
        rdoTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTenSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(29, 29, 29)
                                .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(52, 52, 52)
                                .addComponent(cbbTrangThaiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoKichCo)
                            .addComponent(rdoTenSP))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDongSP)
                            .addComponent(rdoMauSac))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNSX)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(rdoKieuDang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(rdoChatLieu))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMauSac)
                            .addComponent(rdoKieuDang)
                            .addComponent(rdoChatLieu)
                            .addComponent(rdoTenSP))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoKichCo)
                            .addComponent(rdoDongSP)
                            .addComponent(rdoNSX)
                            .addComponent(jLabel17))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangThaiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnThemTT.setBackground(new java.awt.Color(255, 204, 204));
        btnThemTT.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnThemTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1814113_add_more_plus_icon 20px.png"))); // NOI18N
        btnThemTT.setText("Thêm");
        btnThemTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTTActionPerformed(evt);
            }
        });

        btnSuaTT.setBackground(new java.awt.Color(255, 204, 204));
        btnSuaTT.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnSuaTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/172618_update_icon 20px.png"))); // NOI18N
        btnSuaTT.setText("Sửa");
        btnSuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTTActionPerformed(evt);
            }
        });

        btnXoaTT.setBackground(new java.awt.Color(255, 204, 204));
        btnXoaTT.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnXoaTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3643729_bin_delete_garbage_rubbish_trash_icon 20px.png"))); // NOI18N
        btnXoaTT.setText("Xoá");
        btnXoaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTTActionPerformed(evt);
            }
        });

        tbThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã thuộc tính", "Tên thuộc tính"
            }
        ));
        tbThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbThuocTinh);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(btnThemTT)
                .addGap(112, 112, 112)
                .addComponent(btnSuaTT)
                .addGap(136, 136, 136)
                .addComponent(btnXoaTT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lý Thuộc Tính", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTTActionPerformed

    private void rdoDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDongSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDongSPActionPerformed

    private void rdoKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKichCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoKichCoActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            checkCTSP();
            JOptionPane.showMessageDialog(this, chiTietSPService.add(getData()));
            listQLCTSP = chiTietSPService.getAll();
            showData(listQLCTSP);
        }else{
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa sản phẩm", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            int row = tbSanPham.getSelectedRow();
            String id = tbSanPham.getValueAt(row, 0).toString();
            checkCTSP();
            JOptionPane.showMessageDialog(this, chiTietSPService.update(getData(), id));
            listQLCTSP = chiTietSPService.getAll();
            showData(listQLCTSP);
        }else{
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            int row = tbSanPham.getSelectedRow();
            String id = tbSanPham.getValueAt(row, 0).toString();
            JOptionPane.showMessageDialog(this, chiTietSPService.delete(id));
            listQLCTSP = chiTietSPService.getAll();
            showData(listQLCTSP);
        }else{
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        reset();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int row = tbSanPham.getSelectedRow();
        QLChiTietSP qLChiTietSP = listQLCTSP.get(row);
        txtGiaBan.setText(String.valueOf(qLChiTietSP.getGiaBan()));
        txtGiaNhap.setText(String.valueOf(qLChiTietSP.getGiaNhap()));
        txtMoTa.setText(qLChiTietSP.getMoTa());
        txtSoLuong.setText(String.valueOf(qLChiTietSP.getSoLuong()));
        cbbTrangThai.setSelectedItem(qLChiTietSP.inTrangThai());
        cbbChatLieu.setSelectedItem(qLChiTietSP.getChatLieu());
        cbbDongSP.setSelectedItem(qLChiTietSP.getDongSP());
        cbbKichCo.setSelectedItem(qLChiTietSP.getKichCo());
        cbbKieuDang.setSelectedItem(qLChiTietSP.getKieuDang());
        cbbMauSac.setSelectedItem(qLChiTietSP.getMauSac());
        cbbNSX.setSelectedItem(qLChiTietSP.getNSX());
        cbbTenSP.setSelectedItem(qLChiTietSP.getTenSP());
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String ma = txtSearch.getText();
        listQLCTSP = chiTietSPService.getOne(ma);
        showData(listQLCTSP);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThemTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTTActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm thuộc tính", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        if (rdoChatLieu.isSelected() == true) {
            JOptionPane.showMessageDialog(this, chatLieuService.add(getDataChatLieu()));
            listQLChatLieu = chatLieuService.getList();
            showDataTableChatLieu(listQLChatLieu);
        }
        if (rdoDongSP.isSelected() == true) {
            JOptionPane.showMessageDialog(this, dongSPService.add(getDataDongSP()));
            listQLDongSP = dongSPService.getList();
            showDataTableDongSP(listQLDongSP);
        }
        if (rdoKichCo.isSelected() == true) {
            JOptionPane.showMessageDialog(this, kichCoService.add(getDataKichCo()));
            listQLKichCo = kichCoService.getList();
            showDataTableKichCo(listQLKichCo);
        }
        if (rdoKieuDang.isSelected() == true) {
            JOptionPane.showMessageDialog(this, kieuDangService.add(getDataKieuDang()));
            listQLKieuDang = kieuDangService.getList();
            showDataTableKieuDang(listQLKieuDang);
        }
        if (rdoMauSac.isSelected() == true) {
            JOptionPane.showMessageDialog(this, mauSacService.add(getDataMauSac()));
            listQLMauSac = mauSacService.getList();
            showDataTableMauSac(listQLMauSac);
        }
        if (rdoNSX.isSelected() == true) {
            JOptionPane.showMessageDialog(this, nSXService.add(getDataNSX()));
            listQLNSX = nSXService.getList();
            showDataTableNSX(listQLNSX);
        }
        if (rdoTenSP.isSelected() == true) {
            JOptionPane.showMessageDialog(this, sanPhamService.add(getDataSanPham()));
            listQLSP = sanPhamService.getList();
            showDataTableSP(listQLSP);
        }
        }else{
            return;
        }
    }//GEN-LAST:event_btnThemTTActionPerformed

    private void tbThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThuocTinhMouseClicked
        int row = tbThuocTinh.getSelectedRow();
        if (rdoChatLieu.isSelected() == true) {
            QLChatLieu qLChatLieu = listQLChatLieu.get(row);
            txtMaTT.setText(qLChatLieu.getMa());
            txtTenTT.setText(qLChatLieu.getTen());
            cbbTrangThaiTT.setSelectedItem(qLChatLieu.inTrangThai());
        }
        if (rdoDongSP.isSelected() == true) {
            QLDongSP qLDongSP = listQLDongSP.get(row);
            txtMaTT.setText(qLDongSP.getMa());
            txtTenTT.setText(qLDongSP.getTen());
            cbbTrangThaiTT.setSelectedItem(qLDongSP.inTrangThai());
        }
        if (rdoKichCo.isSelected() == true) {
            QLKichCo qLKichCo = listQLKichCo.get(row);
            txtMaTT.setText(qLKichCo.getMa());
            txtTenTT.setText(qLKichCo.getTen());
            cbbTrangThaiTT.setSelectedItem(qLKichCo.inTrangThai());
        }
        if (rdoKieuDang.isSelected() == true) {
            QLKieuDang qLKieuDang = listQLKieuDang.get(row);
            txtMaTT.setText(qLKieuDang.getMa());
            txtTenTT.setText(qLKieuDang.getTen());
            cbbTrangThaiTT.setSelectedItem(qLKieuDang.inTrangThai());
        }
        if (rdoMauSac.isSelected() == true) {
            QLMauSac qLMauSac = listQLMauSac.get(row);
            txtMaTT.setText(qLMauSac.getMa());
            txtTenTT.setText(qLMauSac.getTen());
            cbbTrangThaiTT.setSelectedItem(qLMauSac.inTrangThai());
        }
        if (rdoNSX.isSelected() == true) {
            QLNSX qLNSX = listQLNSX.get(row);
            txtMaTT.setText(qLNSX.getMa());
            txtTenTT.setText(qLNSX.getTen());
            cbbTrangThaiTT.setSelectedItem(qLNSX.inTrangThai());
        }
        if (rdoTenSP.isSelected() == true) {
            QLSanPham qLSanPham = listQLSP.get(row);
            txtMaTT.setText(qLSanPham.getMa());
            txtTenTT.setText(qLSanPham.getTen());
            cbbTrangThaiTT.setSelectedItem(qLSanPham.inTrangThai());
        }
    }//GEN-LAST:event_tbThuocTinhMouseClicked

    private void btnSuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTTActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa thuộc tính", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        if (rdoChatLieu.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, chatLieuService.update(getDataChatLieu(), ma));
            listQLChatLieu = chatLieuService.getList();
            showDataTableChatLieu(listQLChatLieu);
        }
        if (rdoDongSP.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, dongSPService.update(getDataDongSP(), ma));
            listQLDongSP = dongSPService.getList();
            showDataTableDongSP(listQLDongSP);
        }
        if (rdoKichCo.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, kichCoService.update(getDataKichCo(), ma));
            listQLKichCo = kichCoService.getList();
            showDataTableKichCo(listQLKichCo);
        }
        if (rdoKieuDang.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, kieuDangService.update(getDataKieuDang(), ma));
            listQLKieuDang = kieuDangService.getList();
            showDataTableKieuDang(listQLKieuDang);
        }
        if (rdoMauSac.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, mauSacService.update(getDataMauSac(), ma));
            listQLMauSac = mauSacService.getList();
            showDataTableMauSac(listQLMauSac);
        }
        if (rdoNSX.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, nSXService.update(getDataNSX(), ma));
            listQLNSX = nSXService.getList();
            showDataTableNSX(listQLNSX);
        }
        if (rdoTenSP.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, sanPhamService.update(getDataSanPham(), ma));
            listQLSP = sanPhamService.getList();
            showDataTableSP(listQLSP);
        }
        }else{
            return;
        }
    }//GEN-LAST:event_btnSuaTTActionPerformed

    private void btnXoaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTTActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá thuộc tính", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        if (rdoChatLieu.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, chatLieuService.delete(ma));
            listQLChatLieu = chatLieuService.getList();
            showDataTableChatLieu(listQLChatLieu);
        }
        if (rdoDongSP.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, dongSPService.delete(ma));
            listQLDongSP = dongSPService.getList();
            showDataTableDongSP(listQLDongSP);
        }
        if (rdoKichCo.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, kichCoService.delete(ma));
            listQLKichCo = kichCoService.getList();
            showDataTableKichCo(listQLKichCo);
        }
        if (rdoKieuDang.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, kieuDangService.delete(ma));
            listQLKieuDang = kieuDangService.getList();
            showDataTableKieuDang(listQLKieuDang);
        }
        if (rdoMauSac.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, mauSacService.delete(ma));
            listQLMauSac = mauSacService.getList();
            showDataTableMauSac(listQLMauSac);
        }
        if (rdoNSX.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, nSXService.delete(ma));
            listQLNSX = nSXService.getList();
            showDataTableNSX(listQLNSX);
        }
        if (rdoTenSP.isSelected() == true) {
            String ma = txtMaTT.getText();
            JOptionPane.showMessageDialog(this, sanPhamService.delete(ma));
            listQLSP = sanPhamService.getList();
            showDataTableSP(listQLSP);
        }
        }else{
            return;
        }
    }//GEN-LAST:event_btnXoaTTActionPerformed

    private void rdoTenSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTenSPMouseClicked
        clear();
        if (rdoTenSP.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableSP(listQLSP);
        }
    }//GEN-LAST:event_rdoTenSPMouseClicked

    private void rdoMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMauSacMouseClicked
        clear();
        if (rdoMauSac.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableMauSac(listQLMauSac);
        }
    }//GEN-LAST:event_rdoMauSacMouseClicked

    private void rdoKieuDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoKieuDangMouseClicked
        clear();
        if (rdoKieuDang.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableKieuDang(listQLKieuDang);
        }
    }//GEN-LAST:event_rdoKieuDangMouseClicked

    private void rdoChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChatLieuMouseClicked
        clear();
        if (rdoChatLieu.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableChatLieu(listQLChatLieu);
        }
    }//GEN-LAST:event_rdoChatLieuMouseClicked

    private void rdoKichCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoKichCoMouseClicked
        clear();
        if (rdoKichCo.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableKichCo(listQLKichCo);
        }
    }//GEN-LAST:event_rdoKichCoMouseClicked

    private void rdoDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDongSPMouseClicked
        clear();
        if (rdoDongSP.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableDongSP(listQLDongSP);
        }
    }//GEN-LAST:event_rdoDongSPMouseClicked

    private void rdoNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNSXMouseClicked
        clear();
        if (rdoNSX.isSelected() == true) {
            tbThuocTinh.clearSelection();
            showDataTableNSX(listQLNSX);
        }
    }//GEN-LAST:event_rdoNSXMouseClicked

    private void cbbSearchTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchTTActionPerformed
        int ma=cbbSearchTT.getSelectedIndex();
        if(ma==0){
        listQLCTSP = chiTietSPService.SearchTrangThai(ma);
            showData(listQLCTSP);
        } else{
      listQLCTSP = chiTietSPService.SearchTrangThai(ma);
            showData(listQLCTSP);
      }
    }//GEN-LAST:event_cbbSearchTTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewThemNhanhTenSP views=new ViewThemNhanhTenSP();
        views.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ViewThemNhanhMauSac views=new ViewThemNhanhMauSac();
        views.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ViewThemNhanhDongSP views=new ViewThemNhanhDongSP();
        views.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ViewThemNhanhKieuDang views=new ViewThemNhanhKieuDang();
        views.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ViewThemNhanhNSX views=new ViewThemNhanhNSX();
        views.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ViewThemNhanhChatLieu views=new ViewThemNhanhChatLieu();
        views.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ViewThemNhanhKichCo views=new ViewThemNhanhKichCo();
        views.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbbTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTenSPActionPerformed

    private void cbbTenSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTenSPMouseClicked
        int itemCount=cbbTenSP.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbTenSP.removeItemAt(0);
        }
        listSP=sanPhamService.getAll();
        showDataComboboxSP(listSP);
    }//GEN-LAST:event_cbbTenSPMouseClicked

    private void cbbKichCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKichCoMouseClicked
        int itemCount=cbbKichCo.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbKichCo.removeItemAt(0);
        }
        listKichCo=kichCoService.getAll();
        showDataComboboxKichCo(listKichCo);
    }//GEN-LAST:event_cbbKichCoMouseClicked

    private void cbbChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChatLieuMouseClicked
        int itemCount=cbbChatLieu.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbChatLieu.removeItemAt(0);
        }
        listChatLieu=chatLieuService.getAll();
        showDataComboboxChatLieu(listChatLieu);
    }//GEN-LAST:event_cbbChatLieuMouseClicked

    private void cbbMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMauSacMouseClicked
        int itemCount=cbbMauSac.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbMauSac.removeItemAt(0);
        }
        listMauSac=mauSacService.getAll();
        showDataComboboxMauSac(listMauSac);
    }//GEN-LAST:event_cbbMauSacMouseClicked

    private void cbbKieuDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKieuDangMouseClicked
        int itemCount=cbbKieuDang.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbKieuDang.removeItemAt(0);
        }
        listKieuDang=kieuDangService.getAll();
        showDataComboboxKieuDang(listKieuDang);
    }//GEN-LAST:event_cbbKieuDangMouseClicked

    private void cbbDongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDongSPMouseClicked
        int itemCount=cbbDongSP.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbDongSP.removeItemAt(0);
        }
        listDongSP=dongSPService.getAll();
        showDataComboboxDongSP(listDongSP);
    }//GEN-LAST:event_cbbDongSPMouseClicked

    private void cbbNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNSXMouseClicked
        int itemCount=cbbNSX.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            cbbNSX.removeItemAt(0);
        }
        listNSX=nSXService.getAll();
        showDataComboboxNSX(listNSX);
    }//GEN-LAST:event_cbbNSXMouseClicked

    private void rdoTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTenSPActionPerformed
        listSP=sanPhamService.getAll();
        showDataTableSP(listQLSP);
    }//GEN-LAST:event_rdoTenSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaTT;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTT;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbDongSP;
    private javax.swing.JComboBox<String> cbbKichCo;
    private javax.swing.JComboBox<String> cbbKieuDang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbSearchTT;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoDongSP;
    private javax.swing.JRadioButton rdoKichCo;
    private javax.swing.JRadioButton rdoKieuDang;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoNSX;
    private javax.swing.JRadioButton rdoTenSP;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbThuocTinh;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenTT;
    // End of variables declaration//GEN-END:variables
}
