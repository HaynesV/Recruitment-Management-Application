package Model;

import java.util.Date;

public class Experience {

    private String jobTitle;           // Chức danh công việc
    private String companyName;        // Tên công ty
    private Date startDate;            // Ngày bắt đầu công việc
    private Date endDate;              // Ngày kết thúc công việc (có thể để trống nếu là công việc hiện tại)
    private boolean isCurrentJob;      // Có phải công việc hiện tại không
    private String jobLocationCity;    // Thành phố nơi làm việc
    private String jobLocationState;   // Bang nơi làm việc (không yêu cầu)
    private String jobLocationCountry; // Quốc gia nơi làm việc (không yêu cầu)
    private String description;        // Mô tả công việc

    public Experience() {
    }

    // Constructor đầy đủ
    public Experience(String jobTitle, String companyName, Date startDate, Date endDate, boolean isCurrentJob, String jobLocationCity, String jobLocationState, String jobLocationCountry, String description) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = isCurrentJob ? null : endDate; // Nếu là công việc hiện tại, endDate được để trống
        this.isCurrentJob = isCurrentJob;
        this.jobLocationCity = jobLocationCity;
        this.jobLocationState = jobLocationState;
        this.jobLocationCountry = jobLocationCountry;
        this.description = description;
    }
    
    // Constructor ngắn hơn
    public Experience(String tenCongViec, String congTy, Date ngayBatDau, Date ngayKetThuc, boolean congViecHienTai, String noiLamViec, String moTaCongViec) {
        this.jobTitle = tenCongViec;
        this.companyName = congTy;
        this.startDate = ngayBatDau;
        this.endDate = congViecHienTai ? null : ngayKetThuc; // Nếu là công việc hiện tại, endDate được để trống
        this.isCurrentJob = congViecHienTai;
        this.jobLocationCity = noiLamViec;
        this.description = moTaCongViec;
        this.jobLocationState = null;  // Không yêu cầu
        this.jobLocationCountry = null;  // Không yêu cầu
    }

    // Getters và Setters
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (!isCurrentJob) {
            this.endDate = endDate;
        } else {
            this.endDate = null; // Nếu là công việc hiện tại, endDate phải là null
        }
    }

    public boolean isCurrentJob() {
        return isCurrentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        isCurrentJob = currentJob;
        if (currentJob) {
            this.endDate = null; // Nếu là công việc hiện tại, endDate phải là null
        }
    }

    public String getJobLocationCity() {
        return jobLocationCity;
    }

    public void setJobLocationCity(String jobLocationCity) {
        this.jobLocationCity = jobLocationCity;
    }

    public String getJobLocationState() {
        return jobLocationState;
    }

    public void setJobLocationState(String jobLocationState) {
        this.jobLocationState = jobLocationState;
    }

    public String getJobLocationCountry() {
        return jobLocationCountry;
    }

    public void setJobLocationCountry(String jobLocationCountry) {
        this.jobLocationCountry = jobLocationCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Hiển thị thông tin kinh nghiệm dưới dạng chuỗi
    @Override
    public String toString() {
        return jobTitle;
    }
}
