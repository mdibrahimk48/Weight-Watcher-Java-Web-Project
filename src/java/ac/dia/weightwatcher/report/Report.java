package ac.dia.weightwatcher.report;

import ac.dia.weightwatcher.pojo.Course;
import ac.dia.weightwatcher.pojo.Dailyexercise;
import ac.dia.weightwatcher.pojo.Dailylog;
import ac.dia.weightwatcher.pojo.Dailymeal;
import ac.dia.weightwatcher.pojo.Dailymeasurement;
import ac.dia.weightwatcher.pojo.Users;

/**
 *
 * @author Babu
 */
public class Report  implements java.io.Serializable {

String userId, userName, course_id, logId, date, time="";
double mealIntake,mealCalorie,burnCalorie=0;      
    public Report() {
    }

    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMealIntake() {
        return mealIntake;
    }

    public void setMealIntake(double mealIntake) {
        this.mealIntake = mealIntake;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public double getMealCalorie() {
        return mealCalorie;
    }

    public void setMealCalorie(double mealCalorie) {
        this.mealCalorie = mealCalorie;
    }

    public double getBurnCalorie() {
        return burnCalorie;
    }

    public void setBurnCalorie(double burnCalorie) {
        this.burnCalorie = burnCalorie;
    }


}
