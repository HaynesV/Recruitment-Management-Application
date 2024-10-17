package Model;


import java.util.ArrayList;
import java.util.Date;

public class RecruitmentProcess {

    private String id; // ID của quá trình tuyển dụng
    private String jobPostId; // ID của công việc (job post)
    private String userAccountId; // ID của ứng viên (user account)
    private String processStatus; // Trạng thái hiện tại của quy trình tuyển dụng (In Progress, Completed, etc.)
    private ArrayList<Stage> stages; // Danh sách các giai đoạn (stages) trong quy trình tuyển dụng

    // Constructor
    public RecruitmentProcess() {
        stages = new ArrayList<>(); // Khởi tạo danh sách stages
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(String jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public void setStages(ArrayList<Stage> stages) {
        this.stages = stages;
    }

    // Phương thức thêm một stage
    public void addStage(Stage stage) {
        this.stages.add(stage);
    }

    // Lớp nội tại đại diện cho một giai đoạn (Stage)
    public static class Stage {

        private String stageName; // Tên của giai đoạn (ví dụ: Resume Screening, Technical Interview)
        private String stageStatus; // Trạng thái của giai đoạn (Completed, In Progress, etc.)
        private Date dateStarted; // Ngày bắt đầu giai đoạn
        private Date dateCompleted; // Ngày hoàn thành giai đoạn (nếu đã hoàn thành)
        private String feedback; // Phản hồi về giai đoạn này

        // Getters và Setters
        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }

        public String getStageStatus() {
            return stageStatus;
        }

        public void setStageStatus(String stageStatus) {
            this.stageStatus = stageStatus;
        }

        public Date getDateStarted() {
            return dateStarted;
        }

        public void setDateStarted(Date dateStarted) {
            this.dateStarted = dateStarted;
        }

        public Date getDateCompleted() {
            return dateCompleted;
        }

        public void setDateCompleted(Date dateCompleted) {
            this.dateCompleted = dateCompleted;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }
    }
}
