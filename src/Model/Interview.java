
package Model;

import java.util.Date;
import java.util.List;

public class Interview {

    private String id;
    private String jobPostId;
    private String userAccountId;
    private String interviewType;
    private Date interviewDate;
    private Location location;
    private List<Interviewer> interviewers;
    private List<Feedback> interviewFeedback;

    // Constructors
    public Interview() {
    }

    public Interview(String jobPostId, String userAccountId, String interviewType, Date interviewDate, Location location, List<Interviewer> interviewers, List<Feedback> interviewFeedback) {
        this.jobPostId = jobPostId;
        this.userAccountId = userAccountId;
        this.interviewType = interviewType;
        this.interviewDate = interviewDate;
        this.location = location;
        this.interviewers = interviewers;
        this.interviewFeedback = interviewFeedback;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(String jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(List<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }

    public List<Feedback> getInterviewFeedback() {
        return interviewFeedback;
    }

    public void setInterviewFeedback(List<Feedback> interviewFeedback) {
        this.interviewFeedback = interviewFeedback;
    }
}
