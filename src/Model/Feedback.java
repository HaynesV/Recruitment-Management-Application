/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Feedback {

    private String interviewerName;
    private String comments;
    private int rating;

    // Constructors
    public Feedback() {
    }

    public Feedback(String interviewerName, String comments, int rating) {
        this.interviewerName = interviewerName;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters and Setters
    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
