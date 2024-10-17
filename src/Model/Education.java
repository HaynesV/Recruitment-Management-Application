package Model;

import java.util.Date;

public class Education {

    private String certificateDegreeName;  // Tên bằng cấp hoặc chứng chỉ
    private String instituteUniversityName; // Tên trường hoặc tổ chức giáo dục
    private Date startingDate;              // Ngày bắt đầu học tập
    private Date completionDate;            // Ngày hoàn thành học tập
    private int percentage;                 // Phần trăm điểm đạt được
    private double cgpa;                    // Điểm trung bình tích lũy (CGPA)

    public Education() {
    }

    // Constructor đầy đủ
    public Education(String certificateDegreeName, String instituteUniversityName, Date startingDate, Date completionDate, int percentage, double cgpa) {
        this.certificateDegreeName = certificateDegreeName;
        this.instituteUniversityName = instituteUniversityName;
        this.startingDate = startingDate;
        this.completionDate = completionDate;
        this.percentage = percentage;
        this.cgpa = cgpa;
    }

    // Getters và Setters
    public String getCertificateDegreeName() {
        return certificateDegreeName;
    }

    public void setCertificateDegreeName(String certificateDegreeName) {
        this.certificateDegreeName = certificateDegreeName;
    }

    public String getInstituteUniversityName() {
        return instituteUniversityName;
    }

    public void setInstituteUniversityName(String instituteUniversityName) {
        this.instituteUniversityName = instituteUniversityName;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    
    // Hiển thị thông tin học vấn dưới dạng chuỗi
    @Override
    public String toString() {
        return instituteUniversityName;
        
    }
}
