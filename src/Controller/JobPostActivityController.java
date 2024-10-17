package Controller;

import Model.JobPostActivity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class JobPostActivityController {

    private MongoDatabase database;
    private MongoCollection<Document> jobPostActivityCollection;
    private MongoCollection<Document> jobPostCollection;
    private MongoCollection<Document> userAccountCollection;

    public JobPostActivityController() {
        database = MongoDBConnection.getConnection(); // Kết nối tới MongoDB
        jobPostActivityCollection = database.getCollection("job_post_activity"); // Tên collection trong MongoDB
        jobPostCollection = database.getCollection("job_post"); // Collection chứa thông tin bài đăng công việc
        userAccountCollection = database.getCollection("user_account"); // Collection chứa thông tin người dùng
    }

    // Lấy danh sách tất cả các hoạt động ứng tuyển
    public List<JobPostActivity> getAllActivities() {
        List<JobPostActivity> activitiesList = new ArrayList<>();
        try {
            for (Document doc : jobPostActivityCollection.find()) {
                JobPostActivity activity = new JobPostActivity();

                activity.setId(doc.getObjectId("_id"));
                activity.setUserAccountId(doc.getObjectId("user_account_id"));
                activity.setJobPostId(doc.getObjectId("job_post_id"));
                activity.setApplyDate(doc.getDate("apply_date"));
                activity.setAccepted(doc.getBoolean("is_accepted"));

                activitiesList.add(activity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activitiesList;
    }

    // Thêm hoạt động ứng tuyển mới
    public void createJobPostActivity(JobPostActivity activity) {
        try {
            Document activityDoc = new Document();
            activityDoc.append("user_account_id", activity.getUserAccountId());
            activityDoc.append("job_post_id", activity.getJobPostId());
            activityDoc.append("apply_date", activity.getApplyDate());
            activityDoc.append("is_accepted", activity.isAccepted());

            jobPostActivityCollection.insertOne(activityDoc);
            System.out.println("Thêm hoạt động ứng tuyển thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserNameById(ObjectId userAccountId) {
        try {
            Document userDoc = userAccountCollection.find(new Document("_id", userAccountId)).first();
            if (userDoc != null) {
                // Kiểm tra xem trường "name" có tồn tại không
                String name = userDoc.getString("name");
                if (name != null && !name.isEmpty()) {
                    return name;  // Nếu trường "name" có giá trị, trả về giá trị đó
                }

                // Nếu không có "name", lấy thông tin từ seeker_profile
                Document seekerProfile = (Document) userDoc.get("seeker_profile");
                if (seekerProfile != null) {
                    String firstName = seekerProfile.getString("first_name");
                    String lastName = seekerProfile.getString("last_name");
                    return firstName + " " + lastName;  // Trả về họ và tên từ seeker_profile
                } else {
                    return "Thông tin người dùng không đầy đủ";
                }
            } else {
                return "Chưa có người nhận";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi truy xuất tên người dùng";
        }
    }

    public String getJobDescriptionById(ObjectId jobPostId) {
        try {
            Document jobPostDoc = jobPostCollection.find(new Document("_id", jobPostId)).first();
            if (jobPostDoc != null) {
                return jobPostDoc.getString("job_description");  // Giả sử cột mô tả là "job_description"
            } else {
                return "Không tìm thấy công việc";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi truy xuất mô tả công việc";
        }
    }

    // Xóa hoạt động ứng tuyển theo ID
    public void deleteJobPostActivity(ObjectId activityId) {
        try {
            jobPostActivityCollection.deleteOne(new Document("_id", activityId));
            System.out.println("Xóa hoạt động ứng tuyển thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countAcceptedApplicants() {
        List<JobPostActivity> activities = getAllActivities();  // Lấy tất cả các hoạt động ứng tuyển
        long count = activities.stream().filter(JobPostActivity::isAccepted).count();  // Đếm số ứng viên đã được duyệt
        return (int) count;
    }

    // Cập nhật hoạt động ứng tuyển
    public void updateJobPostActivity(ObjectId activityId, JobPostActivity updatedActivity) {
        try {
            Document doc = new Document();
            doc.append("user_account_id", updatedActivity.getUserAccountId());
            doc.append("job_post_id", updatedActivity.getJobPostId());
            doc.append("apply_date", updatedActivity.getApplyDate());
            doc.append("is_accepted", updatedActivity.isAccepted());

            jobPostActivityCollection.updateOne(new Document("_id", activityId), new Document("$set", doc));
            System.out.println("Cập nhật hoạt động ứng tuyển thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
