package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAccount {

    private String id; // _id
    private String email;
    private String password;
    private String gender;
    private boolean isActive;
    private String contactNumber;
    private String userImage;
    private Date registrationDate;
    private SeekerProfile seekerProfile;
    private List<Education> educationDetails = new ArrayList<>();
    private List<Experience> experienceDetails = new ArrayList<>();
    private Integer isAnnuallyMonthly;
    private String userType; // "Ứng Viên" or other types

    public void setAnnuallyMonthly(Integer isAnnuallyMonthly) {
        this.isAnnuallyMonthly = isAnnuallyMonthly;
    }

    // Getter
    public Integer getAnnuallyMonthly() {
        return isAnnuallyMonthly;
    }

    // Constructor mặc định
    public UserAccount() {
    }

    // Constructor đầy đủ
    public UserAccount(String id, String email, String password, String gender, boolean isActive, String contactNumber,
            String userImage, Date registrationDate, SeekerProfile seekerProfile, List<Education> educationDetails,
            List<Experience> experienceDetails, String userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.isActive = isActive;
        this.contactNumber = contactNumber;
        this.userImage = userImage;
        this.registrationDate = registrationDate;
        this.seekerProfile = seekerProfile;
        this.educationDetails = educationDetails;
        this.experienceDetails = experienceDetails;
        this.userType = userType;
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        // Kiểm tra nếu SeekerProfile là null thì trả về một giá trị mặc định
        if (this.getSeekerProfile() != null) {
            String firstName = this.getSeekerProfile().getFirstName() != null ? this.getSeekerProfile().getFirstName() : "";
            String lastName = this.getSeekerProfile().getLastName() != null ? this.getSeekerProfile().getLastName() : "";
            String name = this.getSeekerProfile().getName() != null ? this.getSeekerProfile().getName() : "";

            // Ghép nối first_name, last_name và name
            String fullName = (firstName + " " + lastName + " " + name).trim();

            // Kiểm tra nếu fullName không rỗng thì trả về, nếu không trả về giá trị mặc định
            return !fullName.isEmpty() ? fullName : "Tên không xác định";
        } else {
            return "Tên không xác định";  // Trả về giá trị mặc định nếu SeekerProfile là null
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public SeekerProfile getSeekerProfile() {
        return seekerProfile;
    }

    public void setSeekerProfile(SeekerProfile seekerProfile) {
        this.seekerProfile = seekerProfile;
    }

    public List<Education> getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(List<Education> educationDetails) {
        this.educationDetails = educationDetails;
    }

    public List<Experience> getExperienceDetails() {
        return experienceDetails;
    }

    public void setExperienceDetails(List<Experience> experienceDetails) {
        this.experienceDetails = experienceDetails;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
