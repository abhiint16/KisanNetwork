package abhishekint.com.kisannetwork.sqlite_database;

/**
 * Created by abhishek on 10-06-2018.
 */

public class SqlLiteInit {
    public static final String TABLE_NAME = "kisan";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_OTP = "otp";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private String name;
    private String otp;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_OTP + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public SqlLiteInit() {
    }

    public SqlLiteInit(String name, String otp, String timestamp) {
        this.name = name;
        this.otp = otp;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
