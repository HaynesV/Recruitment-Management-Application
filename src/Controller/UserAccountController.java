package Controller;

import Model.UserAccount;
import Model.SeekerProfile;
import Model.Education;
import Model.Experience;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class UserAccountController {

    private MongoDatabase database;
    private MongoCollection<Document> userCollection;

    public UserAccountController() {
        database = MongoDBConnection.getConnection(); // Kết nối tới MongoDB
        userCollection = database.getCollection("user_account"); // Tên collection trong MongoDB
    }

    // Lấy danh sách tất cả tài khoản người dùng
    public ArrayList<UserAccount> getAllUsers() {
        ArrayList<UserAccount> usersList = new ArrayList<>();
        try {
            for (Document doc : userCollection.find()) {
                UserAccount userAccount = new UserAccount();

                // Sử dụng toHexString để chuyển ObjectId thành String
                userAccount.setId(doc.getObjectId("_id").toHexString());
                userAccount.setEmail(doc.getString("email"));
                userAccount.setPassword(doc.getString("password"));
                userAccount.setGender(doc.getString("gender"));
                userAccount.setActive(doc.getBoolean("is_active"));
                userAccount.setContactNumber(doc.getString("contact_number"));
                userAccount.setUserImage(doc.getString("user_image"));
                userAccount.setRegistrationDate(doc.getDate("registration_date"));
                userAccount.setUserType(doc.getString("user_type"));

                // SeekerProfile
                Document seekerProfileDoc = (Document) doc.get("seeker_profile");
                if (seekerProfileDoc != null) {
                    SeekerProfile seekerProfile = new SeekerProfile();
                    seekerProfile.setFirstName(seekerProfileDoc.getString("first_name"));
                    seekerProfile.setLastName(seekerProfileDoc.getString("last_name"));
                    seekerProfile.setName(seekerProfileDoc.getString("name"));
                    seekerProfile.setGender(seekerProfileDoc.getString("gender"));
                    seekerProfile.setCurrentSalary(seekerProfileDoc.getInteger("current_salary"));
                    seekerProfile.setCurrency(seekerProfileDoc.getString("currency"));
                    seekerProfile.setIsAnnuallyMonthly(seekerProfileDoc.getInteger("is_annually_monthly"));
                    seekerProfile.setEmailContact(seekerProfileDoc.getString("email_contact"));
                    seekerProfile.setFileCV(seekerProfileDoc.getString("file_cv"));
                    userAccount.setSeekerProfile(seekerProfile);
                }

                // EducationDetails
                List<Document> educationDocs = (List<Document>) doc.get("education_details");
                if (educationDocs != null) {
                    List<Education> educationList = new ArrayList<>();
                    for (Document eduDoc : educationDocs) {
                        Education education = new Education();
                        education.setCertificateDegreeName(eduDoc.getString("certificate_degree_name"));
                        education.setInstituteUniversityName(eduDoc.getString("institute_university_name"));
                        education.setStartingDate(eduDoc.getDate("starting_date"));
                        education.setCompletionDate(eduDoc.getDate("completion_date"));
                        education.setPercentage(eduDoc.getInteger("percentage"));
                        education.setCgpa(eduDoc.getDouble("cgpa"));
                        educationList.add(education);
                    }
                    userAccount.setEducationDetails(educationList);
                }

                // ExperienceDetails
                List<Document> experienceDocs = (List<Document>) doc.get("experience_details");
                if (experienceDocs != null) {
                    List<Experience> experienceList = new ArrayList<>();
                    for (Document expDoc : experienceDocs) {
                        Experience experience = new Experience();
                        experience.setJobTitle(expDoc.getString("job_title"));
                        experience.setCompanyName(expDoc.getString("company_name"));
                        experience.setStartDate(expDoc.getDate("start_date"));
                        experience.setEndDate(expDoc.getDate("end_date"));
                        experience.setCurrentJob(expDoc.getBoolean("is_current_job"));
                        experience.setJobLocationCity(expDoc.getString("job_location_city"));
                        experience.setJobLocationState(expDoc.getString("job_location_state"));
                        experience.setJobLocationCountry(expDoc.getString("job_location_country"));
                        experience.setDescription(expDoc.getString("description"));
                        experienceList.add(experience);
                    }
                    userAccount.setExperienceDetails(experienceList);
                }

                usersList.add(userAccount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    // Thêm tài khoản người dùng mới
    public void createUser(UserAccount userAccount) {
        try {
            // Khởi tạo tài liệu MongoDB
            Document userDoc = new Document();

            // Thêm các trường cơ bản
            userDoc.append("email", userAccount.getEmail());
            userDoc.append("password", userAccount.getPassword());
            userDoc.append("contact_number", userAccount.getContactNumber());
            userDoc.append("is_active", userAccount.isActive());
            userDoc.append("user_type", userAccount.getUserType());
            userDoc.append("registration_date", userAccount.getRegistrationDate());

            // Thêm Seeker Profile nếu có
            if (userAccount.getSeekerProfile() != null) {
                SeekerProfile seekerProfile = userAccount.getSeekerProfile();
                Document seekerProfileDoc = new Document();
                seekerProfileDoc.append("name", seekerProfile.getFirstName());
                seekerProfileDoc.append("gender", seekerProfile.getGender());
                seekerProfileDoc.append("current_salary", seekerProfile.getCurrentSalary());
                seekerProfileDoc.append("currency", seekerProfile.getCurrency());
                seekerProfileDoc.append("is_annually_monthly", seekerProfile.getIsAnnuallyMonthly());
                seekerProfileDoc.append("email_contact", seekerProfile.getEmailContact());
                seekerProfileDoc.append("file_cv", seekerProfile.getFileCV());
                userDoc.append("seeker_profile", seekerProfileDoc); // Thêm vào tài liệu người dùng
            }

            // Thêm Education Details nếu có
            List<Document> educationDocs = new ArrayList<>();
            for (Education edu : userAccount.getEducationDetails()) {
                Document eduDoc = new Document();
                eduDoc.append("certificate_degree_name", edu.getCertificateDegreeName());
                eduDoc.append("institute_university_name", edu.getInstituteUniversityName());
                eduDoc.append("starting_date", edu.getStartingDate());
                eduDoc.append("completion_date", edu.getCompletionDate());
                eduDoc.append("percentage", edu.getPercentage());
                eduDoc.append("cgpa", edu.getCgpa());
                educationDocs.add(eduDoc);
            }
            userDoc.append("education_details", educationDocs);

            // Thêm Experience Details nếu có
            List<Document> experienceDocs = new ArrayList<>();
            for (Experience exp : userAccount.getExperienceDetails()) {
                Document expDoc = new Document();
                expDoc.append("job_title", exp.getJobTitle());
                expDoc.append("company_name", exp.getCompanyName());
                expDoc.append("start_date", exp.getStartDate());
                expDoc.append("end_date", exp.getEndDate());
                expDoc.append("is_current_job", exp.isCurrentJob());
                expDoc.append("job_location_city", exp.getJobLocationCity());
                expDoc.append("job_location_state", exp.getJobLocationState());
                expDoc.append("job_location_country", exp.getJobLocationCountry());
                expDoc.append("description", exp.getDescription());
                experienceDocs.add(expDoc);
            }
            userDoc.append("experience_details", experienceDocs);

            // Thêm tài liệu vào MongoDB
            userCollection.insertOne(userDoc);
            System.out.println("Thêm người dùng thành công với email: " + userAccount.getEmail());

        } catch (Exception e) {
            System.out.println("Lỗi khi thêm người dùng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Xóa tài khoản người dùng theo ID
    public void deleteUser(String userId) {
        try {
            userCollection.deleteOne(new Document("_id", new ObjectId(userId)));
            System.out.println("Xóa tài khoản người dùng thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật tài khoản người dùng
    public void updateUser(String userId, UserAccount updatedAccount) {
        try {
            Document doc = new Document();
            doc.append("email", updatedAccount.getEmail())
                    .append("password", updatedAccount.getPassword())
                    .append("gender", updatedAccount.getGender())
                    .append("is_active", updatedAccount.isActive())
                    .append("contact_number", updatedAccount.getContactNumber())
                    .append("user_image", updatedAccount.getUserImage())
                    .append("registration_date", updatedAccount.getRegistrationDate())
                    .append("user_type", updatedAccount.getUserType());

            // SeekerProfile
            if (updatedAccount.getSeekerProfile() != null) {
                SeekerProfile seekerProfile = updatedAccount.getSeekerProfile();
                Document seekerDoc = new Document();
                seekerDoc.append("first_name", seekerProfile.getFirstName())
                        .append("last_name", seekerProfile.getLastName())
                        .append("current_salary", seekerProfile.getCurrentSalary())
                        .append("currency", seekerProfile.getCurrency())
                        .append("is_annually_monthly", seekerProfile.getIsAnnuallyMonthly())
                        .append("email_contact", seekerProfile.getEmailContact())
                        .append("file_cv", seekerProfile.getFileCV());
                doc.append("seeker_profile", seekerDoc);
            }

            // EducationDetails
            List<Document> educationDocs = new ArrayList<>();
            for (Education education : updatedAccount.getEducationDetails()) {
                Document eduDoc = new Document();
                eduDoc.append("certificate_degree_name", education.getCertificateDegreeName())
                        .append("institute_university_name", education.getInstituteUniversityName())
                        .append("starting_date", education.getStartingDate())
                        .append("completion_date", education.getCompletionDate())
                        .append("percentage", education.getPercentage())
                        .append("cgpa", education.getCgpa());
                educationDocs.add(eduDoc);
            }
            doc.append("education_details", educationDocs);

            // ExperienceDetails
            List<Document> experienceDocs = new ArrayList<>();
            for (Experience experience : updatedAccount.getExperienceDetails()) {
                Document expDoc = new Document();
                expDoc.append("job_title", experience.getJobTitle())
                        .append("company_name", experience.getCompanyName())
                        .append("start_date", experience.getStartDate())
                        .append("end_date", experience.getEndDate())
                        .append("is_current_job", experience.isCurrentJob())
                        .append("job_location_city", experience.getJobLocationCity())
                        .append("job_location_state", experience.getJobLocationState())
                        .append("job_location_country", experience.getJobLocationCountry())
                        .append("description", experience.getDescription());
                experienceDocs.add(expDoc);
            }
            doc.append("experience_details", experienceDocs);

            userCollection.updateOne(new Document("_id", new ObjectId(userId)), new Document("$set", doc));
            System.out.println("Cập nhật tài khoản người dùng thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Thống kê số lượng ứng viên theo giới tính

    public List<Document> getApplicantCountByGender() {
        List<Document> results = new ArrayList<>();

        try {
            // Thực hiện truy vấn aggregate để đếm số lượng ứng viên theo giới tính
            results = userCollection.aggregate(List.of(
                    Aggregates.group("$gender", Accumulators.sum("total_applicants", 1))
            )).into(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;  // Trả về danh sách kết quả
    }
}
