package Controller;

import Model.Feedback;
import Model.Interview;
import Model.Interviewer;
import Model.Location;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class InterviewController {

    private MongoDatabase database;
    private MongoCollection<Document> interviewCollection;

    public InterviewController() {
        this.database = MongoDBConnection.getConnection();
        this.interviewCollection = database.getCollection("interview_schedule");
    }

    public ArrayList<Interviewer> getAllInterviewersDirectly() {
        ArrayList<Interviewer> interviewers = new ArrayList<>();

        for (Document doc : interviewCollection.find()) {
            ArrayList<Document> interviewersDocs = (ArrayList<Document>) doc.get("interviewers");
            if (interviewersDocs != null) {
                for (Document interviewerDoc : interviewersDocs) {
                    Interviewer interviewer = new Interviewer();
                    interviewer.setName(interviewerDoc.getString("name"));
                    interviewer.setPosition(interviewerDoc.getString("position"));
                    interviewers.add(interviewer);
                }
            }
        }
        return interviewers;
    }

    // Lấy tất cả các cuộc phỏng vấn
    public ArrayList<Interview> getAllInterviews() {
        ArrayList<Interview> interviews = new ArrayList<>();

        for (Document doc : interviewCollection.find()) {
            Interview interview = new Interview();

            interview.setId(doc.getObjectId("_id").toHexString());
            interview.setJobPostId(doc.getObjectId("job_post_id").toHexString());
            interview.setUserAccountId(doc.getObjectId("user_account_id").toHexString());
            interview.setInterviewType(doc.getString("interview_type"));
            interview.setInterviewDate(doc.getDate("interview_date"));

            // Location
            Document locationDoc = (Document) doc.get("location");
            if (locationDoc != null) {
                Location location = new Location();
                location.setCity(locationDoc.getString("city"));
                location.setState(locationDoc.getString("state"));
                location.setZip(locationDoc.getString("zip")); // Sửa từ country thành zip
                interview.setLocation(location);
            }

            // Interviewers
            ArrayList<Document> interviewersDocs = (ArrayList<Document>) doc.get("interviewers");
            ArrayList<Interviewer> interviewers = new ArrayList<>();
            if (interviewersDocs != null) {
                for (Document interviewerDoc : interviewersDocs) {
                    Interviewer interviewer = new Interviewer();
                    interviewer.setName(interviewerDoc.getString("name"));
                    interviewer.setPosition(interviewerDoc.getString("position"));
                    interviewers.add(interviewer);
                }
            }
            interview.setInterviewers(interviewers);

            // Feedback (Nếu có)
            ArrayList<Document> feedbackDocs = (ArrayList<Document>) doc.get("interview_feedback");
            ArrayList<Feedback> feedbackList = new ArrayList<>();
            if (feedbackDocs != null) {
                for (Document feedbackDoc : feedbackDocs) {
                    Feedback feedback = new Feedback();
                    feedback.setInterviewerName(feedbackDoc.getString("interviewer_name"));
                    feedback.setComments(feedbackDoc.getString("comments"));
                    feedback.setRating(feedbackDoc.getInteger("rating"));
                    feedbackList.add(feedback);
                }
            }
            interview.setInterviewFeedback(feedbackList);

            interviews.add(interview);
        }
        return interviews;
    }

    // Thêm cuộc phỏng vấn mới
    public void createInterview(Interview interview) {
        Document interviewDoc = new Document();

        interviewDoc.append("job_post_id", new ObjectId(interview.getJobPostId()));
        interviewDoc.append("user_account_id", new ObjectId(interview.getUserAccountId()));
        interviewDoc.append("interview_type", interview.getInterviewType());
        interviewDoc.append("interview_date", interview.getInterviewDate());

        // Location
        Document locationDoc = new Document();
        locationDoc.append("city", interview.getLocation().getCity());
        locationDoc.append("state", interview.getLocation().getState());
        locationDoc.append("zip", interview.getLocation().getZip());
        interviewDoc.append("location", locationDoc);

        // Interviewers
        List<Document> interviewersDocs = new ArrayList<>();
        for (Interviewer interviewer : interview.getInterviewers()) {
            Document interviewerDoc = new Document();
            interviewerDoc.append("name", interviewer.getName());
            interviewerDoc.append("position", interviewer.getPosition());
            interviewersDocs.add(interviewerDoc);
        }
        interviewDoc.append("interviewers", interviewersDocs);

        // Feedback (có thể null)
        if (interview.getInterviewFeedback() != null && !interview.getInterviewFeedback().isEmpty()) {
            List<Document> feedbackDocs = new ArrayList<>();
            for (Feedback feedback : interview.getInterviewFeedback()) {
                Document feedbackDoc = new Document();
                feedbackDoc.append("interviewer_name", feedback.getInterviewerName());
                feedbackDoc.append("comments", feedback.getComments());
                feedbackDoc.append("rating", feedback.getRating());
                feedbackDocs.add(feedbackDoc);
            }
            interviewDoc.append("interview_feedback", feedbackDocs);
        } else {
            interviewDoc.append("interview_feedback", null); // Hoặc có thể bỏ qua field này nếu không có feedback
        }

        // Insert interview document
        interviewCollection.insertOne(interviewDoc);
        System.out.println("Thêm cuộc phỏng vấn thành công!");
    }

    // Cập nhật cuộc phỏng vấn
    public void updateInterview(String interviewId, Interview updatedInterview) {
        Document doc = new Document();
        doc.append("job_post_id", new ObjectId(updatedInterview.getJobPostId()));
        doc.append("user_account_id", new ObjectId(updatedInterview.getUserAccountId()));
        doc.append("interview_type", updatedInterview.getInterviewType());
        doc.append("interview_date", updatedInterview.getInterviewDate());

        // Location
        Document locationDoc = new Document();
        locationDoc.append("city", updatedInterview.getLocation().getCity());
        locationDoc.append("state", updatedInterview.getLocation().getState());
        locationDoc.append("zip", updatedInterview.getLocation().getZip());
        doc.append("location", locationDoc);

        // Interviewers
        List<Document> interviewersDocs = new ArrayList<>();
        for (Interviewer interviewer : updatedInterview.getInterviewers()) {
            Document interviewerDoc = new Document();
            interviewerDoc.append("name", interviewer.getName());
            interviewerDoc.append("position", interviewer.getPosition());
            interviewersDocs.add(interviewerDoc);
        }
        doc.append("interviewers", interviewersDocs);

        // Feedback
        List<Document> feedbackDocs = new ArrayList<>();
        for (Feedback feedback : updatedInterview.getInterviewFeedback()) {
            Document feedbackDoc = new Document();
            feedbackDoc.append("interviewer_name", feedback.getInterviewerName());
            feedbackDoc.append("comments", feedback.getComments());
            feedbackDoc.append("rating", feedback.getRating());
            feedbackDocs.add(feedbackDoc);
        }
        doc.append("interview_feedback", feedbackDocs);

        // Cập nhật trong MongoDB
        interviewCollection.updateOne(new Document("_id", new ObjectId(interviewId)), new Document("$set", doc));
        System.out.println("Cập nhật cuộc phỏng vấn thành công!");
    }

    // Xóa cuộc phỏng vấn
    public void deleteInterview(String interviewId) {
        interviewCollection.deleteOne(new Document("_id", new ObjectId(interviewId)));
        System.out.println("Xóa cuộc phỏng vấn thành công!");
    }
}
