package Controller;
import Controller.MongoDBConnection;
import Model.RecruitmentProcess;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;

public class RecruitmentProcessController {

    private MongoDatabase database;
    private MongoCollection<Document> recruitmentProcessCollection;

    public RecruitmentProcessController() {
        database = MongoDBConnection.getConnection(); // Kết nối tới MongoDB
        recruitmentProcessCollection = database.getCollection("recruitment_process"); // Tên collection trong MongoDB
    }

    // Lấy danh sách tất cả RecruitmentProcess
    public ArrayList<RecruitmentProcess> getAllRecruitmentProcesses() {
        ArrayList<RecruitmentProcess> processes = new ArrayList<>();
        for (Document doc : recruitmentProcessCollection.find()) {
            RecruitmentProcess process = new RecruitmentProcess();

            process.setId(doc.getObjectId("_id").toString());
            process.setJobPostId(doc.getObjectId("job_post_id").toString());
            process.setUserAccountId(doc.getObjectId("user_account_id").toString());
            process.setProcessStatus(doc.getString("process_status"));

            // Xử lý stages
            ArrayList<RecruitmentProcess.Stage> stages = new ArrayList<>();
            ArrayList<Document> stagesDoc = (ArrayList<Document>) doc.get("stages");
            if (stagesDoc != null) {
                for (Document stageDoc : stagesDoc) {
                    RecruitmentProcess.Stage stage = new RecruitmentProcess.Stage();
                    stage.setStageName(stageDoc.getString("stage_name"));
                    stage.setStageStatus(stageDoc.getString("stage_status"));
                    stage.setDateStarted(stageDoc.getDate("date_started"));
                    stage.setDateCompleted(stageDoc.getDate("date_completed"));
                    stage.setFeedback(stageDoc.getString("feedback"));
                    stages.add(stage);
                }
            }
            process.setStages(stages);
            processes.add(process);
        }
        return processes;
    }

    // Thêm RecruitmentProcess mới
    public void createRecruitmentProcess(RecruitmentProcess process) {
        try {
            Document processDoc = new Document();

            // Thêm các trường cơ bản
            processDoc.append("job_post_id", new ObjectId(process.getJobPostId()));
            processDoc.append("user_account_id", new ObjectId(process.getUserAccountId()));
            processDoc.append("process_status", process.getProcessStatus());

            // Xử lý stages
            ArrayList<Document> stagesDoc = new ArrayList<>();
            for (RecruitmentProcess.Stage stage : process.getStages()) {
                Document stageDoc = new Document();
                stageDoc.append("stage_name", stage.getStageName());
                stageDoc.append("stage_status", stage.getStageStatus());
                stageDoc.append("date_started", stage.getDateStarted());
                stageDoc.append("date_completed", stage.getDateCompleted());
                stageDoc.append("feedback", stage.getFeedback());
                stagesDoc.add(stageDoc);
            }
            processDoc.append("stages", stagesDoc);

            recruitmentProcessCollection.insertOne(processDoc);
            System.out.println("Thêm RecruitmentProcess thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật RecruitmentProcess
    public void updateRecruitmentProcess(String processId, RecruitmentProcess updatedProcess) {
        try {
            Document updatedDoc = new Document();
            updatedDoc.append("job_post_id", new ObjectId(updatedProcess.getJobPostId()));
            updatedDoc.append("user_account_id", new ObjectId(updatedProcess.getUserAccountId()));
            updatedDoc.append("process_status", updatedProcess.getProcessStatus());

            // Cập nhật stages
            ArrayList<Document> stagesDoc = new ArrayList<>();
            for (RecruitmentProcess.Stage stage : updatedProcess.getStages()) {
                Document stageDoc = new Document();
                stageDoc.append("stage_name", stage.getStageName());
                stageDoc.append("stage_status", stage.getStageStatus());
                stageDoc.append("date_started", stage.getDateStarted());
                stageDoc.append("date_completed", stage.getDateCompleted());
                stageDoc.append("feedback", stage.getFeedback());
                stagesDoc.add(stageDoc);
            }
            updatedDoc.append("stages", stagesDoc);

            recruitmentProcessCollection.updateOne(new Document("_id", new ObjectId(processId)), new Document("$set", updatedDoc));
            System.out.println("Cập nhật RecruitmentProcess thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa RecruitmentProcess
    public void deleteRecruitmentProcess(String processId) {
        try {
            recruitmentProcessCollection.deleteOne(new Document("_id", new ObjectId(processId)));
            System.out.println("Xóa RecruitmentProcess thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
