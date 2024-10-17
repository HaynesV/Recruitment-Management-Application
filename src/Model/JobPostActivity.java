package Model;

import org.bson.types.ObjectId;
import java.util.Date;

public class JobPostActivity {
    private ObjectId id;               // MongoDB ObjectId
    private ObjectId userAccountId;     // MongoDB ObjectId
    private ObjectId jobPostId;         // MongoDB ObjectId
    private Date applyDate;
    private boolean isAccepted;

    // Constructor
    public JobPostActivity() {
    }

    public JobPostActivity(ObjectId userAccountId, ObjectId jobPostId, Date applyDate, boolean isAccepted) {
        this.userAccountId = userAccountId;
        this.jobPostId = jobPostId;
        this.applyDate = applyDate;
        this.isAccepted = isAccepted;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(ObjectId userAccountId) {
        this.userAccountId = userAccountId;
    }

    public ObjectId getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(ObjectId jobPostId) {
        this.jobPostId = jobPostId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
}
