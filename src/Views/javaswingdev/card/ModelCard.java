package Views.javaswingdev.card;

public class ModelCard {

    private String jobDescription;  // Mô tả công việc
    private String jobType;         // Loại công việc (Full-time, Part-time, v.v.)
    private String location;        // Địa điểm công việc (city, state, country)
    private String salary;          // Mức lương của công việc
    private String createdDate;
    private String userName;// Ngày đăng công việc

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter và Setter cho jobDescription
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    // Getter và Setter cho jobType
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    // Getter và Setter cho location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter và Setter cho salary
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    // Getter và Setter cho createdDate
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    // Constructor đầy đủ để khởi tạo ModelCard từ dữ liệu của job post
    public ModelCard(String jobDescription, String jobType, String location, String salary, String createdDate,String userName) {
        this.jobDescription = jobDescription;
        this.jobType = jobType;
        this.location = location;
        this.salary = salary;
        this.createdDate = createdDate;
        this.userName = userName;
    }

    // Constructor mặc định
    public ModelCard() {
    }
}
