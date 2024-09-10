package utils;

import helpers.DateTimeHelper;

public class Constants {
    public static final String HEROKU_URL = "http://192.168.1.183/TADashboard/login.jsp";
    public static String PROJECT_PATH = System.getProperty("user.dir");
    public static String OUTPUT_PATH = PROJECT_PATH + "/resources/output/";
    public static String JSON_FILE_PATH = PROJECT_PATH + "/src/test/resources/data/";
    public static String TIME_STAMP_STRING = DateTimeHelper.generateTimeStampString("yyyy-MM-dd-HH-mm-ss");
    public static String REPORT_LOCATION = OUTPUT_PATH + "report-" + TIME_STAMP_STRING + "/";
    public static String reportFilePath = REPORT_LOCATION + "report-" + TIME_STAMP_STRING + ".html";
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;

}
