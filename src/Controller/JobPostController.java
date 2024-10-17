package Controller;

import Model.JobPost;
import Model.JobPost.Category;
import Model.JobPost.JobLocation;
import Model.JobPost.JobType;
import Model.JobPostActivity;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import static com.mongodb.client.model.Accumulators.sum;
import com.mongodb.client.model.Aggregates;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JobPostController {

    private MongoDatabase database;
    private MongoCollection<Document> jobPostCollection;

    private MongoCollection<Document> jobPostActivityCollection;

    public JobPostController() {
        database = MongoDBConnection.getConnection(); // Kết nối tới MongoDB
        jobPostCollection = database.getCollection("job_post"); // Tên collection trong MongoDB
        jobPostActivityCollection = database.getCollection("job_post_activity");
    }

    // Lấy danh sách tất cả JobPost
    public ArrayList<JobPost> getAllJobPosts() {
        ArrayList<JobPost> jobPosts = new ArrayList<>();
        Date currentDate = new Date();  // Ngày hiện tại
        for (Document doc : jobPostCollection.find()) {
            JobPost jobPost = new JobPost();

            // Handle _id as ObjectId
            jobPost.setId(doc.getObjectId("_id"));

            // Handle job_description, salary, createdDate, dateExpire, and dateReceivingApplication
            jobPost.setJobDescription(doc.getString("job_description"));
            jobPost.setSalary(doc.getInteger("salary"));
            jobPost.setCreatedDate(doc.getDate("created_date"));
            jobPost.setDateExpire(doc.getDate("date_expire"));  // Lấy dateExpire
            jobPost.setDateReceivingApplication(doc.getDate("date_receiving_application"));  // Lấy dateReceivingApplication
            Date dateExpire = doc.getDate("date_expire");
            if (dateExpire != null && dateExpire.before(currentDate)) {
                jobPost.setActive(false);  // Cập nhật trạng thái là không hoạt động
            } else {
                jobPost.setActive(doc.getBoolean("is_active"));
            }

            // Handle job location
            Document locationDoc = (Document) doc.get("job_location");
            if (locationDoc != null) {
                JobPost.JobLocation jobLocation = new JobPost.JobLocation();
                jobLocation.setCity(locationDoc.getString("city"));
                jobLocation.setState(locationDoc.getString("state"));
                jobLocation.setCountry(locationDoc.getString("country"));
                jobLocation.setZip(locationDoc.getString("zip"));
                jobPost.setJobLocation(jobLocation);
            }

            // Handle category
            Document categoryDoc = (Document) doc.get("category");
            if (categoryDoc != null) {
                JobPost.Category category = new JobPost.Category();
                category.setName(categoryDoc.getString("name"));
                jobPost.setCategory(category);
            }

            // Handle JobType
            Document jobTypeDoc = (Document) doc.get("job_type");
            if (jobTypeDoc != null) {
                JobPost.JobType jobType = new JobPost.JobType();
                jobType.setJobTypeName(jobTypeDoc.getString("job_type_name"));
                jobPost.setJobType(jobType);
            } else {
                JobPost.JobType unknownJobType = new JobPost.JobType();
                unknownJobType.setJobTypeName("Unknown");
                jobPost.setJobType(unknownJobType);
            }

            // Kiểm tra xem có bản ghi nào trong job_post_activity với job_post_id này không
            ObjectId jobPostId = doc.getObjectId("_id");
            Document activityDoc = jobPostActivityCollection.find(new Document("job_post_id", jobPostId)).first();

            if (activityDoc != null) {
                // Nếu tìm thấy bản ghi trong job_post_activity => Đã có người ứng tuyển
                jobPost.setUserName("Đã có người ứng tuyển");
            } else {
                // Nếu không có bản ghi nào => Chưa có người nhận
                jobPost.setUserName("Chưa có người nhận");
            }

            jobPosts.add(jobPost);
        }
        return jobPosts;
    }

    // Thêm JobPost mới
    public void createJobPost(JobPost jobPost) {
        try {
            // Create a new Document
            Document jobPostDoc = new Document();

            // Add basic fields
            jobPostDoc.append("post_by_id", jobPost.getPostById()); // Now it accepts ObjectId directly
            jobPostDoc.append("created_date", new Date());  // Use current Date
            jobPostDoc.append("is_active", jobPost.isActive());
            jobPostDoc.append("job_description", jobPost.getJobDescription());
            jobPostDoc.append("salary", jobPost.getSalary());
            jobPostDoc.append("date_expire", jobPost.getDateExpire());  // Thêm dateExpire
            jobPostDoc.append("date_receiving_application", jobPost.getDateReceivingApplication());  // Thêm dateReceivingApplication
            Date currentDate = new Date();  // Current date
            if (jobPost.getDateExpire() != null && jobPost.getDateExpire().before(currentDate)) {
                jobPostDoc.append("is_active", false);  // Set isActive to false if the expiration date is before the current date
            } else {
                jobPostDoc.append("is_active", jobPost.isActive());  // Otherwise, use the value from the object
            }
            // Handle JobType
            if (jobPost.getJobType() != null) {
                JobType jobType = jobPost.getJobType();
                Document jobTypeDoc = new Document();
                jobTypeDoc.append("job_type_name", jobType.getJobTypeName());
                if (jobType.getId() != null) {
                    jobTypeDoc.append("id", jobType.getId()); // Only append if id exists
                }
                jobPostDoc.append("job_type", jobTypeDoc);
            }

            // Handle JobLocation
            if (jobPost.getJobLocation() != null) {
                JobLocation jobLocation = jobPost.getJobLocation();
                Document jobLocationDoc = new Document();
                jobLocationDoc.append("city", jobLocation.getCity());
                jobLocationDoc.append("state", jobLocation.getState());
                jobLocationDoc.append("country", jobLocation.getCountry());
                jobLocationDoc.append("zip", jobLocation.getZip());
                jobPostDoc.append("job_location", jobLocationDoc);
            }

            // Handle Category
            if (jobPost.getCategory() != null) {
                Category category = jobPost.getCategory();
                Document categoryDoc = new Document();
                categoryDoc.append("name", category.getName());
                jobPostDoc.append("category", categoryDoc);
            }

            // Insert the document into MongoDB
            jobPostCollection.insertOne(jobPostDoc);
            System.out.println("Thêm JobPost thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật JobPost
    public void updateJobPost(String jobPostId, JobPost updatedJobPost) {
        try {
            Document doc = new Document();
            doc.append("post_by_id", updatedJobPost.getPostById());  // Sử dụng ObjectId hoặc String
            doc.append("created_date", updatedJobPost.getCreatedDate());  // Assuming it's a Date
            doc.append("is_active", updatedJobPost.isActive());
            doc.append("job_description", updatedJobPost.getJobDescription());
            doc.append("salary", updatedJobPost.getSalary());
            doc.append("date_expire", updatedJobPost.getDateExpire());  // Cập nhật dateExpire
            doc.append("date_receiving_application", updatedJobPost.getDateReceivingApplication());  // Cập nhật dateReceivingApplication
            Date currentDate = new Date();  // Current date
            if (updatedJobPost.getDateExpire() != null && updatedJobPost.getDateExpire().before(currentDate)) {
                doc.append("is_active", false);  // Set isActive to false if the expiration date is before the current date
            } else {
                doc.append("is_active", updatedJobPost.isActive());  // Otherwise, keep the provided value
            }
            // Cập nhật JobType
            if (updatedJobPost.getJobType() != null) {
                Document jobTypeDoc = new Document();
                jobTypeDoc.append("job_type_name", updatedJobPost.getJobType().getJobTypeName());
                doc.append("job_type", jobTypeDoc);
            }

            // Cập nhật JobLocation
            if (updatedJobPost.getJobLocation() != null) {
                Document jobLocationDoc = new Document();
                jobLocationDoc.append("city", updatedJobPost.getJobLocation().getCity())
                        .append("state", updatedJobPost.getJobLocation().getState())
                        .append("country", updatedJobPost.getJobLocation().getCountry())
                        .append("zip", updatedJobPost.getJobLocation().getZip());
                doc.append("job_location", jobLocationDoc);
            }

            // Cập nhật Category
            if (updatedJobPost.getCategory() != null) {
                Document categoryDoc = new Document();
                categoryDoc.append("name", updatedJobPost.getCategory().getName());
                doc.append("category", categoryDoc);
            }

            // Thực hiện cập nhật trong MongoDB
            jobPostCollection.updateOne(new Document("_id", new ObjectId(jobPostId)), new Document("$set", doc));
            System.out.println("Cập nhật JobPost thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa JobPost
    public void deleteJobPost(String jobPostId) {
        try {
            jobPostCollection.deleteOne(new Document("_id", new ObjectId(jobPostId)));
            System.out.println("Xóa JobPost thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Document> getTotalApplicantsByCategory() {
        List<Document> result;

        try {
            // Aggregation pipeline
            List<Document> pipeline = Arrays.asList(
                    new Document("$lookup", new Document() // Bước 1: Liên kết với job_post_activity
                            .append("from", "job_post_activity")
                            .append("localField", "_id")
                            .append("foreignField", "job_post_id")
                            .append("as", "activities") // Kết quả của join lưu trong "activities"
                    ),
                    new Document("$unwind", "$activities"), // Bước 2: Giải nén mảng "activities"
                    new Document("$group", new Document() // Bước 3: Nhóm theo ngành nghề (category.name)
                            .append("_id", "$category.name") // Nhóm theo tên ngành nghề
                            .append("totalApplicants", new Document("$sum", 1)) // Tính tổng số lượng ứng viên
                    ),
                    new Document("$sort", new Document("totalApplicants", -1)) // Bước 4: Sắp xếp theo tổng số ứng viên giảm dần
            );

            // Thực hiện aggregation
            AggregateIterable<Document> documents = jobPostCollection.aggregate(pipeline);

            // Chuyển kết quả thành danh sách
            result = documents.into(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    public List<Document> getJobCountByCategory() {
        List<Document> result = new ArrayList<>();

        try {
            // Pipeline MongoDB aggregation
            List<Document> pipeline = Arrays.asList(
                    new Document("$group", new Document() // Nhóm theo ngành nghề
                            .append("_id", "$category.name") // Nhóm theo trường "category.name"
                            .append("totalJobs", new Document("$sum", 1)) // Tính tổng số công việc trong mỗi ngành
                    ),
                    new Document("$sort", new Document("totalJobs", -1)) // Sắp xếp theo tổng số công việc giảm dần
            );

            // Thực hiện aggregation
            AggregateIterable<Document> documents = jobPostCollection.aggregate(pipeline);

            // Chuyển kết quả thành danh sách
            result = documents.into(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;  // Trả về kết quả dưới dạng danh sách các Document
    }

    public List<Document> getAcceptedJobPosts() {
        // Thực hiện truy vấn MongoDB
        AggregateIterable<Document> result = jobPostCollection.aggregate(Arrays.asList(
                new Document("$lookup", new Document("from", "job_post_activity")
                        .append("localField", "_id")
                        .append("foreignField", "job_post_id")
                        .append("as", "activities")),
                new Document("$unwind", "$activities"),
                new Document("$match", new Document("activities.is_accepted", true)),
                new Document("$project", new Document("job_description", 1)
                        .append("activities.user_account_id", 1)
                        .append("activities.apply_date", 1))
        ));

        // Chuyển kết quả sang dạng danh sách Document và trả về
        return result.into(new java.util.ArrayList<>());
    }

    public List<Document> countJobsWithAndWithoutApplicants() {
        List<Document> result;

        try {
            // Aggregation pipeline
            List<Document> pipeline = Arrays.asList(
                    new Document("$lookup", new Document() // Bước 1: Liên kết với job_post_activity
                            .append("from", "job_post_activity")
                            .append("localField", "_id")
                            .append("foreignField", "job_post_id")
                            .append("as", "activities") // Kết quả của join lưu trong "activities"
                    ),
                    new Document("$project", new Document() // Bước 2: Tạo trường hasApplicants
                            .append("job_description", 1)
                            .append("hasApplicants", new Document("$gt", Arrays.asList(new Document("$size", "$activities"), 0))) // true nếu có ứng viên
                    ),
                    new Document("$group", new Document() // Bước 3: Nhóm theo hasApplicants
                            .append("_id", "$hasApplicants") // Nhóm theo trạng thái có hoặc không có ứng viên
                            .append("count", new Document("$sum", 1)) // Đếm số lượng công việc trong mỗi nhóm
                    )
            );

            // Thực hiện aggregation
            AggregateIterable<Document> documents = jobPostCollection.aggregate(pipeline);

            // Chuyển kết quả thành danh sách
            result = documents.into(new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

  public List<Document> getJobCountByJobType() {
    return jobPostCollection.aggregate(Arrays.asList(
        Aggregates.group("$job_type", Accumulators.sum("count", 1)),  // Nhóm theo JobType và đếm số lượng công việc
        Aggregates.project(Projections.fields(
            Projections.include("count"),
            Projections.computed("jobType", "$_id")  // Đổi tên _id thành jobType
        )),
        Aggregates.sort(Sorts.ascending("jobType"))  // Sắp xếp theo JobType
    )).into(new ArrayList<>());
}


    public List<JobPost> getTopJobsByApplicants(int limit) {
        List<JobPost> jobPosts = new ArrayList<>();

        try {
            // Lệnh MongoDB aggregation để lấy các công việc có nhiều ứng viên nhất
            List<Document> aggregationPipeline = Arrays.asList(
                    new Document("$lookup", new Document()
                            .append("from", "job_post_activity")
                            .append("localField", "_id")
                            .append("foreignField", "job_post_id")
                            .append("as", "activities")
                    ),
                    new Document("$project", new Document()
                            .append("job_description", 1) // Hiển thị mô tả công việc
                            .append("numApplicants", new Document("$size", "$activities")) // Đếm số lượng ứng viên
                    ),
                    new Document("$sort", new Document("numApplicants", -1)), // Sắp xếp theo số lượng ứng viên giảm dần
                    new Document("$limit", limit) // Giới hạn số lượng công việc trả về
            );

            // Thực hiện aggregation và duyệt qua các kết quả
            for (Document doc : jobPostCollection.aggregate(aggregationPipeline)) {
                JobPost jobPost = new JobPost();

                jobPost.setJobDescription(doc.getString("job_description"));
                jobPost.setNumApplicants(doc.getInteger("numApplicants", 0));

                jobPosts.add(jobPost);  // Thêm công việc vào danh sách kết quả
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobPosts;  // Trả về danh sách các công việc có nhiều ứng viên nhất
    }

    public int getTotalSalaryByJobType(String jobTypeName) {
        int totalSalary = 0;

        try {
            // Thực hiện truy vấn MongoDB với aggregation
            Document result = jobPostCollection.aggregate(Arrays.asList(
                    // Lọc theo loại công việc
                    new Document("$match", new Document("job_type.job_type_name", jobTypeName)),
                    // Tính tổng lương theo nhóm (tức là loại công việc)
                    new Document("$group", new Document()
                            .append("_id", "$job_type.job_type_name")
                            .append("totalSalary", new Document("$sum", "$salary"))
                    )
            )).first();  // Lấy kết quả đầu tiên

            // Kiểm tra kết quả và lấy tổng lương
            if (result != null && result.containsKey("totalSalary")) {
                totalSalary = result.getInteger("totalSalary");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalSalary;  // Trả về tổng lương
    }
}
