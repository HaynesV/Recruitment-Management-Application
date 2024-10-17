package Model;

public class SeekerProfile {

    private String firstName;
    private String lastName;
    private int currentSalary;
    private String currency;
    private int isAnnuallyMonthly;
    private String emailContact;
    private String fileCV;
    private String gender; // Thêm trường gender nếu chưa có
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor mặc định
    public SeekerProfile() {
    }

    // Constructor đầy đủ
    public SeekerProfile(String firstName, String lastName, String name, int currentSalary, String currency, int isAnnuallyMonthly,
            String emailContact, String fileCV, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentSalary = currentSalary;
        this.currency = currency;
        this.isAnnuallyMonthly = isAnnuallyMonthly;
        this.emailContact = emailContact;
        this.fileCV = fileCV;
        this.gender = gender;
    }

    // Getters và Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(int currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getIsAnnuallyMonthly() {
        return isAnnuallyMonthly;
    }

    public void setIsAnnuallyMonthly(int isAnnuallyMonthly) {
        this.isAnnuallyMonthly = isAnnuallyMonthly;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getFileCV() {
        return fileCV;
    }

    public void setFileCV(String fileCV) {
        this.fileCV = fileCV;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
