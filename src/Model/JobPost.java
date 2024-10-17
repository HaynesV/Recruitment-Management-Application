package Model;

import org.bson.types.ObjectId;
import java.util.Date;

public class JobPost {

    private ObjectId id;  // Thay vì String
    private ObjectId postById;  // Thay vì String
    private JobType jobType;
    private Date createdDate;
    private boolean isActive;
    private String jobDescription;
    private int salary;
    private JobLocation jobLocation;
    private Category category;
    private String fileDescription;
    private String userName; // Thêm thuộc tính userName
    private Date dateExpire;  // Thêm trường dateExpire
    private Date dateReceivingApplication;  // Thêm trường dateReceivingApplication

    // Getters và Setters cho tất cả các thuộc tính
    public ObjectId getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getJobDescription();  // Hiển thị tên công việc trong ComboBox
    }
    private int numApplicants;  // Thêm thuộc tính numApplicants

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getPostById() {
        return postById;
    }
    // Getter và Setter cho numApplicants

    public int getNumApplicants() {
        return numApplicants;
    }

    public void setNumApplicants(int numApplicants) {
        this.numApplicants = numApplicants;
    }

    public void setPostById(ObjectId postById) {
        this.postById = postById;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    // Getter và Setter cho dateExpire
    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    // Getter và Setter cho dateReceivingApplication
    public Date getDateReceivingApplication() {
        return dateReceivingApplication;
    }

    public void setDateReceivingApplication(Date dateReceivingApplication) {
        this.dateReceivingApplication = dateReceivingApplication;
    }

    // Inner classes for JobType, JobLocation, and Category
    public static class JobType {

        private String id;
        private String jobTypeName;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJobTypeName() {
            return jobTypeName;
        }

        public void setJobTypeName(String jobTypeName) {
            this.jobTypeName = jobTypeName;
        }
    }

    public static class JobLocation {

        private String city;
        private String state;
        private String country;
        private String zip;

        // Getters and Setters
        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    public static class Category {

        private String name;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
