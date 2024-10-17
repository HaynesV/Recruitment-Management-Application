package Views.javaswingdev.form;

import Controller.JobPostController;
import Controller.UserAccountController;
import Model.SeekerProfile;
import Model.UserAccount;
import Views.javaswingdev.swing.ActionCellRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author USER
 */
public class Form_QLUngVien extends javax.swing.JPanel {

    /**
     * Creates new form Form_QLUngVien
     */
    public Form_QLUngVien() {
        initComponents();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "Email", "Họ Tên", "Giới Tính", "Số Điện Thoại", "Loại Tài Khoản", "Trạng Thái"
        });
        table.setModel(model);

        table.fixTable(jScrollPane1);
        loadTableData(); // Nạp dữ liệu cho bảng
        //loadTableDatathongke();
        loadTable1Data();
    }

    private void loadTableDatathongke() {
        // Tạo một đối tượng DefaultTableModel cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mô tả công việc", "User ID", "Ngày nộp đơn"}); // Đặt tiêu đề cột
        table.setModel(model);

        // Xóa dữ liệu cũ nếu có
        model.setRowCount(0);

        // Lấy danh sách công việc đã được duyệt từ Controller
        JobPostController jobPostController = new JobPostController();
        List<Document> acceptedJobs = jobPostController.getAcceptedJobPosts();

        // Lặp qua kết quả truy vấn và thêm vào bảng
        for (Document job : acceptedJobs) {
            String jobDescription = job.getString("job_description");
            String userId = job.get("activities.user_account_id").toString();
            String applyDate = job.get("activities.apply_date").toString();

            // Thêm hàng mới vào bảng
            model.addRow(new Object[]{jobDescription, userId, applyDate});
        }
        loadTable1Data();
    }

    private void loadTable1Data() {
        // Tạo một đối tượng DefaultTableModel cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mô tả công việc", "User ID", "Ngày nộp đơn"}); // Đặt tiêu đề cột
        table1.setModel(model);

        // Xóa dữ liệu cũ nếu có
        model.setRowCount(0);

        // Lấy danh sách công việc đã được duyệt từ JobPostController
        JobPostController jobPostController = new JobPostController();
        List<Document> acceptedJobs = jobPostController.getAcceptedJobPosts();

        // Lặp qua kết quả truy vấn và thêm vào bảng
        for (Document job : acceptedJobs) {
            // Kiểm tra null trước khi truy cập vào các trường
            String jobDescription = job.getString("job_description") != null ? job.getString("job_description") : "N/A";
            String userId = job.get("activities.user_account_id") != null ? job.get("activities.user_account_id").toString() : "N/A";
            String applyDate = job.get("activities.apply_date") != null ? job.get("activities.apply_date").toString() : "N/A";

            // Thêm hàng mới vào bảng
            model.addRow(new Object[]{jobDescription, userId, applyDate});
        }
    }

    private void loadTableData() {
        // Tạo một đối tượng DefaultTableModel cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Email", "Họ Tên", "Giới Tính", "Số Điện Thoại", "Loại Tài Khoản", "Trạng Thái"});
        table.setModel(model);
        // Xóa dữ liệu cũ nếu có
        model.setRowCount(0);

        // Lấy danh sách tất cả ứng viên từ Controller
        UserAccountController userAccountController = new UserAccountController();
        ArrayList<UserAccount> usersList = userAccountController.getAllUsers();

        // Lặp qua danh sách ứng viên và thêm vào bảng
        for (UserAccount user : usersList) {
            // Kiểm tra xem seekerProfile có tồn tại hay không để lấy tên và các thông tin khác
            String name = "N/A";
            String gender = "N/A";

            if (user.getSeekerProfile() != null) {
                SeekerProfile profile = user.getSeekerProfile();

                // Kiểm tra nếu first_name và last_name đều null, thì sử dụng trường name
                if (profile.getFirstName() != null && profile.getLastName() != null) {
                    name = profile.getFirstName() + " " + profile.getLastName();
                } else if (profile.getName() != null) {
                    // Nếu không có first_name và last_name thì sử dụng trường name
                    name = profile.getName();
                }

                // Lấy giới tính
                gender = profile.getGender() != null ? profile.getGender() : "N/A";
            }

            // Thêm hàng mới vào bảng
            model.addRow(new Object[]{
                user.getEmail(),
                name,
                gender,
                user.getContactNumber(),
                user.getUserType(),
                user.isActive() ? "Kích hoạt" : "Không kích hoạt",});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Views.javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new Views.javaswingdev.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        roundPanel2 = new Views.javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new Views.javaswingdev.swing.table.Table();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ ỨNG VIÊN");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("XEM CHI TIẾT");

        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them.setText("THÊM");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("XÓA");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("LÊN LỊCH PHỎNG VẤN");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel2Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton1)
                        .addGap(98, 98, 98)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(jLabel1)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btn_Them)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed

    }//GEN-LAST:event_btn_ThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Views.javaswingdev.swing.RoundPanel roundPanel1;
    private Views.javaswingdev.swing.RoundPanel roundPanel2;
    private Views.javaswingdev.swing.table.Table table;
    private Views.javaswingdev.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
