/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.javaswingdev.form;

import Controller.JobPostController;
import Model.JobPost;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author USER
 */
public class Form_ThongKeCongViec extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private JobPostController jobPostController;

    public Form_ThongKeCongViec() {
        initComponents();
        jobPostController = new JobPostController();  // Khởi tạo controller
        initTable();  // Khởi tạo bảng
        loadTableData();  // Tải dữ liệu vào bảng
        loadJobStatistics();
        loadApplicantStatisticsByCategory();
        loadJobCountByCategory();
        loadJobStatisticsByJobType();
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mô tả công việc", "Số lượng ứng viên"});  // Đặt tiêu đề cho cột
        table1.setModel(tableModel);

        // Tạo renderer để căn giữa cột thứ 2 (cột "Số lượng ứng viên")
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);  // Đặt căn giữa

        // Áp dụng renderer này cho cột thứ 2
        table1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }

    private void loadJobStatisticsByJobType() {
        DefaultTableModel jobTypeTableModel = new DefaultTableModel();
        jobTypeTableModel.setColumnIdentifiers(new String[]{"Loại Công Việc", "Số Lượng"});  // Đặt tiêu đề cho cột
        table3.setModel(jobTypeTableModel);

        // Gọi phương thức từ JobPostController để lấy số liệu công việc theo loại công việc
        List<Document> jobTypeStats = jobPostController.getJobCountByJobType();

        // Xóa dữ liệu cũ trong bảng
        jobTypeTableModel.setRowCount(0);

        // Lặp qua danh sách loại công việc và số lượng, sau đó thêm vào bảng
        for (Document doc : jobTypeStats) {
            // Kiểm tra nếu `job_type` tồn tại và có `job_type_name`
            Document jobTypeDoc = (Document) doc.get("_id");
            String jobTypeName;
            if (jobTypeDoc != null && jobTypeDoc.containsKey("job_type_name")) {
                jobTypeName = jobTypeDoc.getString("job_type_name");
            } else {
                jobTypeName = "Không xác định";  // Nếu không có thì đặt giá trị mặc định
            }

            int count = doc.getInteger("count");  // Số lượng công việc

            jobTypeTableModel.addRow(new Object[]{jobTypeName, count});
        }
    }

    // Phương thức tải dữ liệu vào bảng
    private void loadTableData() {
        // Gọi phương thức từ JobPostController để lấy các công việc có nhiều ứng viên nhất
        List<JobPost> topJobs = jobPostController.getTopJobsByApplicants(10);  // Lấy top 10 công việc

        // Xóa dữ liệu cũ trong bảng
        tableModel.setRowCount(0);

        // Lặp qua danh sách công việc và thêm vào bảng
        for (JobPost job : topJobs) {
            tableModel.addRow(new Object[]{job.getJobDescription(), job.getNumApplicants()});
        }
    }

    private void loadJobStatistics() {
        // Gọi phương thức countJobsWithAndWithoutApplicants để lấy dữ liệu
        List<Document> jobStats = jobPostController.countJobsWithAndWithoutApplicants();

        int soLuongCoUV = 0;  // Số lượng công việc đã có ứng viên
        int soLuongChuaCoUV = 0;  // Số lượng công việc chưa có ứng viên

        // Lặp qua kết quả và gán giá trị cho các biến tương ứng
        for (Document doc : jobStats) {
            boolean hasApplicants = doc.getBoolean("_id");  // true nếu có ứng viên, false nếu không
            int count = doc.getInteger("count");

            if (hasApplicants) {
                soLuongCoUV = count;  // Gán số lượng công việc đã có ứng viên
            } else {
                soLuongChuaCoUV = count;  // Gán số lượng công việc chưa có ứng viên
            }
        }

        // Gán giá trị vào JTextField
        txt_soLuongCoUV.setText(String.valueOf(soLuongCoUV));
        txt_soLuongChuaCoUV.setText(String.valueOf(soLuongChuaCoUV));
    }

    private void loadApplicantStatisticsByCategory() {
        DefaultTableModel categoryTableModel = new DefaultTableModel();
        categoryTableModel.setColumnIdentifiers(new String[]{"Ngành nghề", "Tổng số lượng ứng viên"});  // Đặt tiêu đề cột
        table2.setModel(categoryTableModel);
        // Tạo renderer để căn giữa cho cả hai cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);  // Đặt căn giữa

        // Áp dụng renderer này cho cả hai cột trong table2
        table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);  // Cột "Tổng số lượng ứng viên"

        // Gọi phương thức từ JobPostController để lấy số liệu ứng viên theo ngành nghề
        List<Document> categoryStats = jobPostController.getTotalApplicantsByCategory();

        // Xóa dữ liệu cũ trong bảng
        categoryTableModel.setRowCount(0);

        // Lặp qua danh sách ngành nghề và tổng số ứng viên, sau đó thêm vào bảng
        for (Document doc : categoryStats) {
            String categoryName = doc.getString("_id");  // Tên ngành nghề (category)
            int totalApplicants = doc.getInteger("totalApplicants");  // Tổng số lượng ứng viên

            categoryTableModel.addRow(new Object[]{categoryName, totalApplicants});
        }
    }

    private void loadJobCountByCategory() {
        // Tạo model cho bảng table3
        DefaultTableModel jobCountTableModel = new DefaultTableModel();
        jobCountTableModel.setColumnIdentifiers(new String[]{"Ngành nghề", "Số lượng công việc"});  // Đặt tiêu đề cho cột
        table4.setModel(jobCountTableModel);

        // Tạo renderer để căn giữa cho cả hai cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);  // Đặt căn giữa

        // Áp dụng renderer này cho cả hai cột trong table3
        table3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);  // Cột "Số lượng công việc"

        // Gọi phương thức từ JobPostController để lấy số lượng công việc theo ngành nghề
        List<Document> jobCountByCategory = jobPostController.getJobCountByCategory();

        // Xóa dữ liệu cũ trong bảng
        jobCountTableModel.setRowCount(0);

        // Lặp qua danh sách ngành nghề và số lượng công việc, sau đó thêm vào bảng
        for (Document doc : jobCountByCategory) {
            String categoryName = doc.getString("_id");  // Tên ngành nghề (category)
            int totalJobs = doc.getInteger("totalJobs");  // Số lượng công việc

            jobCountTableModel.addRow(new Object[]{categoryName, totalJobs});
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

        jLabel1 = new javax.swing.JLabel();
        roundPanel1 = new Views.javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new Views.javaswingdev.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_soLuongCoUV = new javax.swing.JTextField();
        txt_soLuongChuaCoUV = new javax.swing.JTextField();
        roundPanel2 = new Views.javaswingdev.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new Views.javaswingdev.swing.table.Table();
        roundPanel3 = new Views.javaswingdev.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new Views.javaswingdev.swing.table.Table();
        jScrollPane4 = new javax.swing.JScrollPane();
        table4 = new Views.javaswingdev.swing.table.Table();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ CÔNG VIỆC");

        roundPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CÔNG VIỆC CÓ NHIỀU ỨNG VIÊN NHẤT"));

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
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("SỐ LƯƠNG CÔNG VIỆC ĐÃ CÓ ỨNG VIÊN:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("SỐ LƯƠNG CÔNG VIỆC CHƯA CÓ ỨNG VIÊN:");

        roundPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SỐ LƯƠNG ƯV THEO NGÀNH"));

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        roundPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("SỐ LƯƠNG CV THEO NGÀNH"));

        table3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table3);

        table4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(table4);

        jLabel4.setText("THỐNG KÊ CV THEO LOẠI");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_soLuongCoUV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txt_soLuongChuaCoUV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_soLuongCoUV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_soLuongChuaCoUV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
        );

        roundPanel3.getAccessibleContext().setAccessibleName("SỐ LƯƠNG CV  THEO NGÀNH");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private Views.javaswingdev.swing.RoundPanel roundPanel1;
    private Views.javaswingdev.swing.RoundPanel roundPanel2;
    private Views.javaswingdev.swing.RoundPanel roundPanel3;
    private Views.javaswingdev.swing.table.Table table1;
    private Views.javaswingdev.swing.table.Table table2;
    private Views.javaswingdev.swing.table.Table table3;
    private Views.javaswingdev.swing.table.Table table4;
    private javax.swing.JTextField txt_soLuongChuaCoUV;
    private javax.swing.JTextField txt_soLuongCoUV;
    // End of variables declaration//GEN-END:variables
}
