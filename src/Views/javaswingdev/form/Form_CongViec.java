package Views.javaswingdev.form;

import Controller.JobPostController;
import Model.JobPost;
import Views.javaswingdev.card.Card;
import java.awt.GridLayout;
import java.util.ArrayList;
import Views.javaswingdev.card.ModelCard;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_CongViec extends javax.swing.JPanel {

    private JobPostController jobPostController;

    public Form_CongViec() {
        initComponents();
        jobPostController = new JobPostController();
        initJobPost();
    }

    private void showJobDetails(JobPost jobPost) {
        if (jobPost == null) {
            JOptionPane.showMessageDialog(this, "Công việc không tồn tại.");
            return;
        }

        JFrame detailFrame = new JFrame("Chi tiết công việc");
        Form_XemChiTiet panel = new Form_XemChiTiet();
        panel.loadData(jobPost); // Load the job post data into the form
        detailFrame.add(panel);
        detailFrame.setSize(700, 800);
        detailFrame.setLocationRelativeTo(null); // Center the frame
        detailFrame.setVisible(true);
    }

    private void initJobPost() {
        ArrayList<JobPost> jobPosts = jobPostController.getAllJobPosts(); // Lấy danh sách job_post từ DB
        System.out.println("Số lượng jobPosts: " + jobPosts.size());

        for (JobPost jobPost : jobPosts) {
            System.out.println("JobPost ID:" + jobPost.getId());
            System.out.println("JobPost: " + jobPost.getJobDescription());
            System.out.println("JobType:" + jobPost.getJobType().getJobTypeName());
        }

        // Tạo panel mới để chứa các card
        JPanel panel = new JPanel(new GridLayout(0, 3, 20, 20)); // GridLayout với nhiều dòng, 2 cột và khoảng cách giữa các card
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Thêm padding xung quanh panel

        // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Lặp qua danh sách jobPosts và tạo Card cho mỗi công việc
        for (JobPost jobPost : jobPosts) {
            Card card = new Card();

            // Lấy dữ liệu từ jobPost và chuyển vào ModelCard
            String jobDescription = jobPost.getJobDescription();
            String location = jobPost.getJobLocation().getCity() + ", "
                    + jobPost.getJobLocation().getState() + ", "
                    + jobPost.getJobLocation().getCountry();
            String salary = String.valueOf(jobPost.getSalary());
            String userName = jobPost.getUserName();
            String createdDate = "N/A";
            if (jobPost.getCreatedDate() != null) {
                createdDate = dateFormat.format(jobPost.getCreatedDate()); // Định dạng ngày tạo
            }

            card.setData(new ModelCard(
                    jobDescription, // Mô tả công việc
                    jobPost.getJobType() != null ? jobPost.getJobType().getJobTypeName() : "Unknown", // Loại công việc
                    location, // Địa điểm
                    salary, // Mức lương
                    createdDate, // Ngày đăng với định dạng dd-MM-yyyy
                    userName
            ));

            // Thêm sự kiện khi nhấn nút Xem Chi Tiết
            card.addDetailButtonListener(e -> {
                showJobDetails(jobPost);
            });
            card.addDeleteButtonListener(e -> {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa công việc này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    jobPostController.deleteJobPost(jobPost.getId().toHexString()); // Xóa công việc bằng ID
                    JOptionPane.showMessageDialog(null, "Công việc đã được xóa thành công!");

                    // Refresh the job list after deletion
                    initJobPost();  // This will reload the list of jobs
                }
            });
            panel.add(card);
        }

        // Tạo JScrollPane chứa panel
        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Sử dụng thanh cuộn tùy chỉnh của bạn
        scrollPane.setVerticalScrollBar(new Views.javaswingdev.swing.scroll.ScrollBar());

        // Đảm bảo panel chính đã được làm rỗng trước khi thêm
        this.removeAll();

        // Thêm JScrollPane vào giao diện chính
        roundPanel1.setLayout(new BorderLayout()); // Sử dụng BorderLayout để thêm JScrollPane chiếm hết không gian
        roundPanel1.add(scrollPane, BorderLayout.CENTER); // Thêm JScrollPane vào trung tâm

        // Cập nhật giao diện sau khi thêm
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        roundPanel1 = new Views.javaswingdev.swing.RoundPanel();
        card1 = new Views.javaswingdev.card.Card();
        scrollBar1 = new Views.javaswingdev.swing.scroll.ScrollBar();
        btn_ThemCongVien = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH CÔNG VIỆC");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 626, Short.MAX_VALUE)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_ThemCongVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_ThemCongVien.setText("THÊM CÔNG VIỆC");
        btn_ThemCongVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCongVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_ThemCongVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ThemCongVien)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemCongVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCongVienActionPerformed
        JFrame frame = new JFrame("ĐĂNG KÝ TÀI KHOẢN");

        Form_ThemCongViec form = new Form_ThemCongViec();
        frame.add(form);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btn_ThemCongVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThemCongVien;
    private Views.javaswingdev.card.Card card1;
    private javax.swing.JLabel jLabel1;
    private Views.javaswingdev.swing.RoundPanel roundPanel1;
    private Views.javaswingdev.swing.scroll.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables
}
