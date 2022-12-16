/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.ChiTietSP;
import DomainModels.KhuyenMai;
import DomainModels.SanPham_KhuyenMai;
import Services.ChiTietSPService;
import Services.Impl.ChiTietSPServiceImpl;
import Services.Impl.KhuyenMaiServiceImpl;
import Services.Impl.SanPham_KMServiceImpl;
import Services.KhuyenMaiService;
import Services.SanPham_KMService;
import ViewModels.QLChiTietSP;
import ViewModels.QLKhuyenMai;
import ViewModels.QLSanPham_KhuyenMai;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truongmanhquang
 */
public class KhuyenMaiJpanel extends javax.swing.JPanel {

    private DefaultTableModel dtm=new DefaultTableModel();
    private List<QLKhuyenMai> listQLKM=new ArrayList<>();
    private KhuyenMaiService khuyenMaiService=new KhuyenMaiServiceImpl();
    
    private DefaultTableModel dtm1=new DefaultTableModel();
    private DefaultComboBoxModel dcbmTenKM=new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmTenSP=new DefaultComboBoxModel();
    
    private List<QLSanPham_KhuyenMai> listQLSPKM=new ArrayList<>();
    private SanPham_KMService sanPham_KMService=new SanPham_KMServiceImpl();
    private ChiTietSPService chiTietSPService=new ChiTietSPServiceImpl();
    private List<QLChiTietSP> listQLCTSP=new ArrayList<>();
    
    private List<ChiTietSP> listCTSP=new ArrayList<>();
    private List<KhuyenMai> listKM=new ArrayList<>();
    /**
     * Creates new form KhuyenMaiJpanel
     */
    public KhuyenMaiJpanel() {
        initComponents();
        cbbTenKM.setModel(dcbmTenKM);
        cbbTenSP.setModel(dcbmTenSP);
        
        listQLSPKM=sanPham_KMService.getAll();
        showDataTableSPKM(listQLSPKM);
        
        tbKm.setModel(dtm);
        String[] headers={"Mã KM","Tên KM","Loại KM","Ngày bắt đầu","Ngày kết thúc","Giảm giá %","Giảm giá tiền","Trạng thái"};
        dtm.setColumnIdentifiers(headers);
        
//        tbSanPham.setModel(dtm1);
        String[] header={"Tên KM","Mã SP","Tên SP","Giá cũ","Giá mới"};
        dtm1.setColumnIdentifiers(header);
        
        listQLKM=khuyenMaiService.getAll();
        showData(listQLKM);
        
        listQLCTSP=chiTietSPService.getAll();
        showCbbTenSP(listQLCTSP);
        listQLKM=khuyenMaiService.getList();
        showCbbTenKM(listQLKM);
    }

    private void showDataTableSPKM(List<QLSanPham_KhuyenMai> listQLSPKM){
        dtm1= (DefaultTableModel) tbSanPham.getModel();
        dtm1.setRowCount(0);
        for (QLSanPham_KhuyenMai qLSanPham_KhuyenMai : listQLSPKM) {
            dtm1.addRow(new Object[]{
                qLSanPham_KhuyenMai.getTenKM(),qLSanPham_KhuyenMai.getMaSP(),qLSanPham_KhuyenMai.getTenSP(),
                qLSanPham_KhuyenMai.getDonGia(),qLSanPham_KhuyenMai.getDonGiaSauKhiGiam()
            });
        }
    }
    
    private void showCbbTenKM(List<QLKhuyenMai> listQLKM){
        for (QLKhuyenMai qLKhuyenMai : listQLKM) {
            dcbmTenKM.addElement(qLKhuyenMai.getTen());
        }
    }
    
    private void showCbbTenSP(List<QLChiTietSP> listQLCTSP){
        for (QLChiTietSP qLChiTietSP : listQLCTSP) {
            dcbmTenSP.addElement(qLChiTietSP.getTenSP());
        }
    }
    
    private void showData(List<QLKhuyenMai> listQLKM){
        dtm.setRowCount(0);
        for (QLKhuyenMai qLKhuyenMai : listQLKM) {
            dtm.addRow(new Object[]{
                qLKhuyenMai.getMa(),qLKhuyenMai.getTen(),qLKhuyenMai.inLoaiKM(),qLKhuyenMai.getNgayBatDau(),qLKhuyenMai.getNgayKetThuc(),
                    qLKhuyenMai.getMucGiamGiaTheoPhanTram()+"%",qLKhuyenMai.getMucGiamGiaTheoTien(),qLKhuyenMai.inTrangThai()
            });
        }
    }
    
    public KhuyenMai getData(){
        String ma=txtMaKM.getText();
        String ten=txtTenKM.getText();
        int loaiKM=0;
        if(cbbLoaiKM.getSelectedIndex()==1){
            loaiKM=1;
        }
        int mucGiamGiaTheoPhanTram=Integer.parseInt(txtGiamGiaPT.getText());
        Double mucGiamGiaTheoTien=Double.parseDouble(txtGiamGiaTien.getText());
        String ngayBatDau=txtNgayBatDau.getText();
        String ngayKetThuc=txtNgayKetThuc.getText();
        int trangThai=0;
        if(cbbTrangThai.getSelectedIndex()==1){
            trangThai=1;
        }
        KhuyenMai km=new KhuyenMai(ma, ten, loaiKM, ngayBatDau, ngayKetThuc, mucGiamGiaTheoPhanTram, mucGiamGiaTheoTien, trangThai);
        return km;
    }
    
    public SanPham_KhuyenMai getData1(){
        int indexTenKM=cbbTenKM.getSelectedIndex();
        QLKhuyenMai qlkm=listQLKM.get(indexTenKM);
        int indexTenSP=cbbTenSP.getSelectedIndex();
        QLChiTietSP qlctsp=listQLCTSP.get(indexTenSP);
        SanPham_KhuyenMai sanPham_KhuyenMai=new SanPham_KhuyenMai(qlkm.getId(), qlctsp.getId());
        return sanPham_KhuyenMai;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearchKM = new javax.swing.JTextField();
        btnTimKM = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbbSearchLoaiKM = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbSearchTrangThai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKm = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSeachTenKM = new javax.swing.JTextField();
        btnSearchSP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        cbbTenKM = new javax.swing.JComboBox<>();
        cbbTenSP = new javax.swing.JComboBox<>();
        btnThemSPKM = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtGiamGiaTien = new javax.swing.JTextField();
        txtNgayBatDau = new javax.swing.JTextField();
        txtNgayKetThuc = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        cbbLoaiKM = new javax.swing.JComboBox<>();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtGiamGiaPT = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setText("Tìm khuyến mại");

        btnTimKM.setBackground(new java.awt.Color(255, 102, 153));
        btnTimKM.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnTimKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bản sao 211818_search_icon_20px.png"))); // NOI18N
        btnTimKM.setText("Tìm");
        btnTimKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKMActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("Loại KM");

        cbbSearchLoaiKM.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbbSearchLoaiKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm theo %", "Giảm theo tiền", "Tất cả" }));
        cbbSearchLoaiKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSearchLoaiKMMouseClicked(evt);
            }
        });
        cbbSearchLoaiKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchLoaiKMActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        cbbSearchTrangThai.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbbSearchTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng áp dụng", "Đang áp dụng", "Tất cả" }));
        cbbSearchTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchTrangThaiActionPerformed(evt);
            }
        });

        tbKm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Loại KM", "Ngày bắt đầu", "Ngày kết thúc", "Giá trị KM", "Trạng thái"
            }
        ));
        tbKm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKm);

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel11.setText("Tìm sản phẩm");

        btnSearchSP.setBackground(new java.awt.Color(255, 102, 153));
        btnSearchSP.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSearchSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bản sao 211818_search_icon_20px.png"))); // NOI18N
        btnSearchSP.setText("Tìm");
        btnSearchSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSPActionPerformed(evt);
            }
        });

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên KM", "Mã SP", "Tên SP", "Giá cũ", "Giá mới"
            }
        ));
        jScrollPane2.setViewportView(tbSanPham);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        btnThemSPKM.setBackground(new java.awt.Color(255, 204, 204));
        btnThemSPKM.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnThemSPKM.setText("Thêm");
        btnThemSPKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cbbTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btnThemSPKM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbTenKM)
                    .addComponent(btnThemSPKM, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cbbTenSP))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSeachTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchSP))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTimKM)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cbbSearchLoaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cbbSearchTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 206, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKM)
                    .addComponent(cbbSearchLoaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSearchTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeachTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Mã khuyến mại:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Tên khuyến mại:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Loại khuyến mại:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Giảm giá tiền:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Ngày bắt đầu:");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Ngày kết thúc:");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Trạng thái:");

        btnThem.setBackground(new java.awt.Color(255, 204, 204));
        btnThem.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 204, 204));
        btnCapNhat.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        cbbLoaiKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm theo %", "Giảm theo tiền" }));
        cbbLoaiKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiKMActionPerformed(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngừng áp dụng", "Đang áp dụng" }));

        btnXoa.setBackground(new java.awt.Color(255, 204, 204));
        btnXoa.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel13.setText("Giảm giá %:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCapNhat)
                                .addGap(40, 40, 40)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.Alignment.LEADING, 0, 230, Short.MAX_VALUE)
                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiamGiaTien, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbLoaiKM, 0, 230, Short.MAX_VALUE)
                                    .addComponent(txtGiamGiaPT))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbLoaiKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGiamGiaPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiamGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm khuyến mại", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        JOptionPane.showMessageDialog(this, khuyenMaiService.add(getData()));
        listQLKM=khuyenMaiService.getAll();
        showData(listQLKM);
        }else{
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật khuyến mại", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        int row=tbKm.getSelectedRow();
        String ma=(String) tbKm.getValueAt(row, 0);
        JOptionPane.showMessageDialog(this, khuyenMaiService.update(getData(), ma));
        listQLKM=khuyenMaiService.getAll();
        showData(listQLKM);
        }else{
            return;
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá khuyến mại", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
        int row=tbKm.getSelectedRow();
        String ma=(String) tbKm.getValueAt(row, 0);
        JOptionPane.showMessageDialog(this, khuyenMaiService.delete(ma));
        listQLKM=khuyenMaiService.getAll();
        showData(listQLKM);
        }else{
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKMActionPerformed
        String ma=txtSearchKM.getText();
        listQLKM=khuyenMaiService.getOne(ma);
        showData(listQLKM);
    }//GEN-LAST:event_btnTimKMActionPerformed

    private void tbKmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKmMouseClicked
        int row=tbKm.getSelectedRow();
        QLKhuyenMai qLKhuyenMai=listQLKM.get(row);
        txtMaKM.setText(qLKhuyenMai.getMa());
        txtTenKM.setText(qLKhuyenMai.getTen());
        cbbLoaiKM.setSelectedItem(qLKhuyenMai.inLoaiKM());
        if(tbKm.getValueAt(row, 2).toString()=="Giảm theo %"){
            txtGiamGiaPT.setEnabled(true);
            txtGiamGiaTien.setEnabled(false);
        }else{
            txtGiamGiaPT.setEnabled(false);
            txtGiamGiaTien.setEnabled(true);
        }
        txtGiamGiaPT.setText(String.valueOf(qLKhuyenMai.getMucGiamGiaTheoPhanTram()));
        txtGiamGiaTien.setText(String.valueOf(qLKhuyenMai.getMucGiamGiaTheoTien()));
        txtNgayBatDau.setText(qLKhuyenMai.getNgayBatDau());
        txtNgayKetThuc.setText(qLKhuyenMai.getNgayKetThuc());
        cbbTrangThai.setSelectedItem(qLKhuyenMai.inTrangThai());
    }//GEN-LAST:event_tbKmMouseClicked

    private void cbbSearchLoaiKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSearchLoaiKMMouseClicked
        
    }//GEN-LAST:event_cbbSearchLoaiKMMouseClicked

    private void cbbSearchLoaiKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchLoaiKMActionPerformed
        int loaiKM=cbbSearchLoaiKM.getSelectedIndex();
        if(loaiKM==0){
            listQLKM=khuyenMaiService.getSearchLoaiKMPT(loaiKM);
            showData(listQLKM);
        }else if(loaiKM==1){
            listQLKM=khuyenMaiService.getSearchLoaiKMPT(loaiKM);
            showData(listQLKM);
        }else if(loaiKM==2){
            listQLKM=khuyenMaiService.getAll();
            showData(listQLKM);
        } 
    }//GEN-LAST:event_cbbSearchLoaiKMActionPerformed

    private void cbbSearchTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchTrangThaiActionPerformed
        int trangThai=cbbSearchTrangThai.getSelectedIndex();
        if(trangThai==0){
            listQLKM=khuyenMaiService.getSearchTTNHD(trangThai);
            showData(listQLKM);
        }else if(trangThai==1){
            listQLKM=khuyenMaiService.getSearchTTNHD(trangThai);
            showData(listQLKM);
        }else if(trangThai==2){
            listQLKM=khuyenMaiService.getAll();
            showData(listQLKM);
            }
    }//GEN-LAST:event_cbbSearchTrangThaiActionPerformed

    private void cbbLoaiKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiKMActionPerformed
        if(cbbLoaiKM.getSelectedIndex()==0){
            txtGiamGiaTien.setText("0.0");
            txtGiamGiaTien.setEnabled(false);
            txtGiamGiaPT.setEnabled(true);
        }else{
            txtGiamGiaPT.setText("0");
            txtGiamGiaPT.setEnabled(false);
            txtGiamGiaTien.setEnabled(true);
        }
        
    }//GEN-LAST:event_cbbLoaiKMActionPerformed

    private void btnThemSPKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPKMActionPerformed
        int result=JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm khuyến mại vào sản phẩm", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, sanPham_KMService.add(getData1()));
            listQLSPKM=sanPham_KMService.getAll();
            showDataTableSPKM(listQLSPKM);
        }else{
            return;
        }
    }//GEN-LAST:event_btnThemSPKMActionPerformed

    private void btnSearchSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSPActionPerformed
        String ma=txtSeachTenKM.getText();
        listQLSPKM=sanPham_KMService.getOne(ma);
        showDataTableSPKM(listQLSPKM);
    }//GEN-LAST:event_btnSearchSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnSearchSP;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSPKM;
    private javax.swing.JButton btnTimKM;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoaiKM;
    private javax.swing.JComboBox<String> cbbSearchLoaiKM;
    private javax.swing.JComboBox<String> cbbSearchTrangThai;
    private javax.swing.JComboBox<String> cbbTenKM;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbKm;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtGiamGiaPT;
    private javax.swing.JTextField txtGiamGiaTien;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtSeachTenKM;
    private javax.swing.JTextField txtSearchKM;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
