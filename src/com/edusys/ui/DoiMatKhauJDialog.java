/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.ui;

import com.edusys.dao.NhanVienDAO;
import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;
import java.awt.Color;

/**
 *
 * @author Admin
 */
public class DoiMatKhauJDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     */
    public DoiMatKhauJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
        this.setTitle("EduSys - Đổi mật khẩu");

        txtMaNV.setText(Auth.USER.getMaNV());
        txtMaNV.setEditable(false);
    }
    NhanVienDAO nvdao = new NhanVienDAO();

    private void doiMatKhau() {
        String matKhau = new String(txtMatKhau.getPassword()).trim();
        String MatKhauMoi = new String(txtMKmoi.getPassword()).trim();
        String MatKhauMoi2 = new String(txtXacNhanMK.getPassword()).trim();
        
        String result = changePass(matKhau, MatKhauMoi, MatKhauMoi2);
        sprMKMoi.setBackground(Color.white);
        sprMKMoi.setForeground(Color.white);
        sprXacNhanMK.setBackground(Color.white);
        sprXacNhanMK.setForeground(Color.white);
        sprMatKhau.setBackground(Color.white);
        sprMatKhau.setForeground(Color.white);
        if (result.equals("Sai mật khẩu")) {
            sprMatKhau.setBackground(Color.red);
            sprMatKhau.setForeground(Color.RED);
        } else if (result.equals("Mật khẩu mới phải từ 3 kí tự trở lên\n")) {
            sprMKMoi.setBackground(Color.red);
            sprMKMoi.setForeground(Color.RED);
        }else if (result.equals("Xác nhận mật khẩu không đúng")) {          
            sprMKMoi.setBackground(Color.red);
            sprMKMoi.setForeground(Color.RED);
            sprXacNhanMK.setBackground(Color.red);
            sprXacNhanMK.setForeground(Color.RED);
        } MsgBox.alert(this, result);
    }
    
    //Phương thức đổi mật khẩu tài khoản đang đăng nhập
    public String changePass(String oldPw,String newPw,String cfPw){
        if(Auth.USER==null){
            throw new NullPointerException();
        }
        if (!oldPw.equals(Auth.USER.getMatKhau())) {
            return "Sai mật khẩu";
        } else if (!newPw.matches("[\\w]{3,}")) {
            return "Mật khẩu mới phải từ 3 kí tự trở lên\n";
        }else if (!newPw.equals(cfPw)) {          
            return "Xác nhận mật khẩu không đúng";
        } else {
            try {
                Auth.USER.setMatKhau(newPw);
                nvdao.update(Auth.USER);
                return "Đổi mật khẩu thành công";
            } catch (Exception ex) {
                return "Đỏi mật khẩu thất bại";
            }
        }
    }

    void close() {
        this.dispose();
    }

    void clearForm() {
        txtMatKhau.setText("");
        txtMKmoi.setText("");
        txtXacNhanMK.setText("");
    }

    void hienMatKhau() {
        if (chkHienMK.isSelected()) {
            txtMatKhau.setEchoChar((char) 0);
            txtMKmoi.setEchoChar((char) 0);
            txtXacNhanMK.setEchoChar((char) 0);
        } else {
            txtMatKhau.setEchoChar('•');
            txtMKmoi.setEchoChar('•');
            txtXacNhanMK.setEchoChar('•');
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

        jPanel2 = new javax.swing.JPanel();
        lblMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        sprMaNV = new javax.swing.JSeparator();
        lblMatKhau = new javax.swing.JLabel();
        sprMatKhau = new javax.swing.JSeparator();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDongY = new javax.swing.JButton();
        chkHienMK = new javax.swing.JCheckBox();
        txtMKmoi = new javax.swing.JPasswordField();
        lblMKMoi = new javax.swing.JLabel();
        sprMKMoi = new javax.swing.JSeparator();
        txtXacNhanMK = new javax.swing.JPasswordField();
        lblXacNhanMK = new javax.swing.JLabel();
        sprXacNhanMK = new javax.swing.JSeparator();
        lblIcon = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblBg = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setOpaque(false);

        lblMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(57, 113, 177));
        lblMaNV.setText("TÊN ĐĂNG NHẬP");

        txtMaNV.setBackground(new Color(0,0,0,0));
        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(255, 255, 255));
        txtMaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0,0,0,0), 7));
        txtMaNV.setCaretColor(new java.awt.Color(255, 255, 255));
        txtMaNV.setOpaque(false);

        sprMaNV.setForeground(new java.awt.Color(255, 255, 255));
        sprMaNV.setOpaque(true);

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(57, 113, 177));
        lblMatKhau.setText("MẬT KHẨU CŨ");

        sprMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        sprMatKhau.setOpaque(true);

        txtMatKhau.setBackground(new Color(0,0,0,0));
        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0,0,0,0), 7));
        txtMatKhau.setOpaque(false);
        txtMatKhau.setEchoChar('•');

        btnDongY.setBackground(new java.awt.Color(126, 87, 194));
        btnDongY.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDongY.setForeground(new java.awt.Color(255, 255, 255));
        btnDongY.setText("ĐỔI MẬT KHẨU");
        btnDongY.setFocusable(false);
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        chkHienMK.setBackground(new Color(0,0,0,0));
        chkHienMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkHienMK.setForeground(new java.awt.Color(57, 113, 177));
        chkHienMK.setText("Hiện mật khẩu");
        chkHienMK.setFocusPainted(false);
        chkHienMK.setFocusable(false);
        chkHienMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHienMKActionPerformed(evt);
            }
        });

        txtMKmoi.setBackground(new Color(0,0,0,0));
        txtMKmoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMKmoi.setForeground(new java.awt.Color(255, 255, 255));
        txtMKmoi.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0,0,0,0), 7));
        txtMKmoi.setOpaque(false);
        txtMKmoi.setEchoChar('•');

        lblMKMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMKMoi.setForeground(new java.awt.Color(57, 113, 177));
        lblMKMoi.setText("MẬT KHẨU MỚI");

        sprMKMoi.setForeground(new java.awt.Color(255, 255, 255));
        sprMKMoi.setOpaque(true);

        txtXacNhanMK.setBackground(new Color(0,0,0,0));
        txtXacNhanMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtXacNhanMK.setForeground(new java.awt.Color(255, 255, 255));
        txtXacNhanMK.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0,0,0,0), 7));
        txtXacNhanMK.setOpaque(false);
        txtXacNhanMK.setEchoChar('•');

        lblXacNhanMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblXacNhanMK.setForeground(new java.awt.Color(57, 113, 177));
        lblXacNhanMK.setText("XÁC NHẬN MẬT KHẨU");

        sprXacNhanMK.setForeground(new java.awt.Color(255, 255, 255));
        sprXacNhanMK.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprMaNV)
                    .addComponent(sprMatKhau)
                    .addComponent(txtMatKhau)
                    .addComponent(txtMaNV)
                    .addComponent(sprMKMoi)
                    .addComponent(txtMKmoi)
                    .addComponent(sprXacNhanMK)
                    .addComponent(txtXacNhanMK)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatKhau)
                            .addComponent(lblMaNV)
                            .addComponent(lblMKMoi)
                            .addComponent(lblXacNhanMK))
                        .addGap(0, 267, Short.MAX_VALUE))
                    .addComponent(btnDongY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkHienMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaNV)
                .addGap(13, 13, 13)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sprMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblMatKhau)
                .addGap(13, 13, 13)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sprMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblMKMoi)
                .addGap(13, 13, 13)
                .addComponent(txtMKmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sprMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblXacNhanMK)
                .addGap(21, 21, 21)
                .addComponent(txtXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sprXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkHienMK)
                .addGap(26, 26, 26)
                .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/21-avatar-outline (1).gif"))); // NOI18N
        getContentPane().add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 400, 140));

        lblExit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblExit.setForeground(new java.awt.Color(57, 113, 177));
        lblExit.setText("X");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        getContentPane().add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        lblBg.setBackground(new Color(0,0,0,200));
        lblBg.setOpaque(true);
        getContentPane().add(lblBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 730));

        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/banner-wap.jpg"))); // NOI18N
        getContentPane().add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        doiMatKhau();
    }//GEN-LAST:event_btnDongYActionPerformed

    private void chkHienMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHienMKActionPerformed
        hienMatKhau();
    }//GEN-LAST:event_chkHienMKActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_lblExitMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDongY;
    private javax.swing.JCheckBox chkHienMK;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBg;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMKMoi;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblXacNhanMK;
    private javax.swing.JSeparator sprMKMoi;
    private javax.swing.JSeparator sprMaNV;
    private javax.swing.JSeparator sprMatKhau;
    private javax.swing.JSeparator sprXacNhanMK;
    private javax.swing.JPasswordField txtMKmoi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtXacNhanMK;
    // End of variables declaration//GEN-END:variables
}