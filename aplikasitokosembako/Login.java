/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasitokosembako;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author akbaroke
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        setIcon();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        btnLinkRegister = new javax.swing.JButton();
        txtUsername_login = new javax.swing.JTextField();
        txtPassword_login = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI TOKO SEMBAKO");
        getContentPane().setLayout(null);

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-login.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(180, 500, 250, 40);

        btnLinkRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnLinkRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn-linkRegister.png"))); // NOI18N
        btnLinkRegister.setBorder(null);
        btnLinkRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLinkRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnLinkRegister);
        btnLinkRegister.setBounds(450, 20, 120, 30);

        txtUsername_login.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtUsername_login.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername_login.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername_login.setBorder(null);
        getContentPane().add(txtUsername_login);
        txtUsername_login.setBounds(140, 280, 320, 40);

        txtPassword_login.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPassword_login.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword_login.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword_login.setBorder(null);
        getContentPane().add(txtPassword_login);
        txtPassword_login.setBounds(140, 390, 320, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 661);

        setSize(new java.awt.Dimension(616, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username = txtUsername_login.getText();
        String password = txtPassword_login.getText();
        
        if(!username.isEmpty() && !username.isBlank() && !password.isEmpty() && !password.isBlank()){
            try {
                Connection conn = Koneksi.ConnectDB();
                String query = "SELECT * FROM tb_users WHERE username='"+username+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                String userId = null;
                String passwordBase = null;
                while(rs.next()){
                    userId = rs.getString("id");
                    passwordBase = rs.getString("password");
                }
                
                if(userId == null){
                    JOptionPane.showMessageDialog(rootPane, "Oopss...\nUsername tidak diketahui!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    txtUsername_login.setText("");
                    txtPassword_login.setText("");
                    
                }else{
                    if(password.equals(passwordBase)){
                        //set session
                        Session.session.setSession(userId);
                        AplikasiTokoSembako home = new AplikasiTokoSembako();
                        this.setVisible(false);
                        home.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Oopss...\nPassword salah!", "Gagal", JOptionPane.ERROR_MESSAGE);
                        txtPassword_login.setText("");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Oopss...\nData ditolak!", "Gagal", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Oopss...\nData harus diisi dengan benar!", "Gagal", JOptionPane.ERROR_MESSAGE);
            txtUsername_login.setText("");
            txtPassword_login.setText("");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLinkRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkRegisterActionPerformed
        // TODO add your handling code here:
        Register register = new Register();
        this.setVisible(false);
        register.setVisible(true);
    }//GEN-LAST:event_btnLinkRegisterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLinkRegister;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtPassword_login;
    private javax.swing.JTextField txtUsername_login;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../assets/icon-apk.png")));
    }
}
