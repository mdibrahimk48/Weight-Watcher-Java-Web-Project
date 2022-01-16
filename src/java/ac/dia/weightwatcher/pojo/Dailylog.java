package ac.dia.weightwatcher.pojo;
// Generated Dec 27, 2017 2:42:36 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dailylog generated by hbm2java
 */
public class Dailylog  implements java.io.Serializable {


     private Integer logId;
     private Activity activity=new Activity();
     private Course course=new Course();
     private Date date;
     private String progress;
     private Set dailymeals = new HashSet(0);
     private Set dailyexercises = new HashSet(0);
     private Set deilymeasurements = new HashSet(0);

    public Dailylog() {
    }
    public Dailylog(Activity activities){
        this.activity=activities;
    }	
    public Dailylog(Course courses){
        this.course=courses;
    }
    public Dailylog(Activity activity, Course course, Date date, String progress) {
        this.activity = activity;
        this.course = course;
        this.date = date;
        this.progress = progress;
    }
    public Dailylog(Activity activity, Course course, Date date, String progress, Set dailymeals, Set dailyexercises, Set deilymeasurements) {
       this.activity = activity;
       this.course = course;
       this.date = date;
       this.progress = progress;
       this.dailymeals = dailymeals;
       this.dailyexercises = dailyexercises;
       this.deilymeasurements = deilymeasurements;
    }
   
    public Integer getLogId() {
        return this.logId;
    }
    
    public void setLogId(Integer logId) {
        this.logId = logId;
    }
    public Activity getActivity() {
        return this.activity;
    }
    
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getProgress() {
        return this.progress;
    }
    
    public void setProgress(String progress) {
        this.progress = progress;
    }
    public Set getDailymeals() {
        return this.dailymeals;
    }
    
    public void setDailymeals(Set dailymeals) {
        this.dailymeals = dailymeals;
    }
    public Set getDailyexercises() {
        return this.dailyexercises;
    }
    
    public void setDailyexercises(Set dailyexercises) {
        this.dailyexercises = dailyexercises;
    }
    public Set getDeilymeasurements() {
        return this.deilymeasurements;
    }
    
    public void setDeilymeasurements(Set deilymeasurements) {
        this.deilymeasurements = deilymeasurements;
    }




}


