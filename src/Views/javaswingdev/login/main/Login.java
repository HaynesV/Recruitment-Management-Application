package Views.javaswingdev.login.main;

import Views.javaswingdev.main.Main;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setTitle("Đăng nhập");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new Views.javaswingdev.login.login.background();
        txt_taikhoan = new Views.javaswingdev.login.swing.TextField();
        passwordField2 = new Views.javaswingdev.login.swing.PasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button3 = new Views.javaswingdev.login.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_taikhoan.setText("textField3");
        background1.add(txt_taikhoan);
        txt_taikhoan.setBounds(340, 170, 64, 34);

        passwordField2.setText("passwordField2");
        background1.add(passwordField2);
        passwordField2.setBounds(340, 210, 73, 34);

        jLabel1.setText("Tài khoản");
        background1.add(jLabel1);
        jLabel1.setBounds(240, 180, 60, 16);

        jLabel2.setText("Mật khẩu");
        background1.add(jLabel2);
        jLabel2.setBounds(240, 220, 70, 16);

        button3.setText("button3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
//        if(txt_user.getText().equals("trieu") && String.valueOf(txt_password.getPassword()).equals("123"));
//        Main main = new Main();
//        main.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_btn_loginActionPerformed

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
    private Views.javaswingdev.login.login.background background1;
    private Views.javaswingdev.login.swing.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Views.javaswingdev.login.swing.PasswordField passwordField2;
    private Views.javaswingdev.login.swing.TextField txt_taikhoan;
    // End of variables declaration//GEN-END:variables
}
