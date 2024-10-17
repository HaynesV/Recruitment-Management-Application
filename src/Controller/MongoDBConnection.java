package Controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class MongoDBConnection {
    
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getConnection() {
        if (mongoClient == null) {
            String uri = "mongodb://localhost:27017"; // URI của MongoDB
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase("qlns"); // Tên database của bạn
            System.out.println("Ket noi MongoDB thanh cong");
        }
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            System.out.println("Đóng kết nối MongoDB thành công");
        }
    }
}
