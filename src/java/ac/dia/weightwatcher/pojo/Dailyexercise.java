package ac.dia.weightwatcher.pojo;
// Generated Dec 27, 2017 2:42:36 PM by Hibernate Tools 4.3.1



/**
 * Dailyexercise generated by hbm2java
 */
public class Dailyexercise  implements java.io.Serializable {


     private Integer dailyExerciseId;
     private Dailylog dailylog=new Dailylog();
     private Excercise excercise=new Excercise();
     private String time;

    public Dailyexercise() {
    }
    public Dailyexercise(Dailylog dailyLog){
        this.dailylog=dailyLog;
    }
    public Dailyexercise(Excercise excercise){
        this.excercise=excercise;
    }
    public Dailyexercise(Dailylog dailylog, Excercise excercise, String time) {
       this.dailylog = dailylog;
       this.excercise = excercise;
       this.time = time;
    }
   
    public Integer getDailyExerciseId() {
        return this.dailyExerciseId;
    }
    
    public void setDailyExerciseId(Integer dailyExerciseId) {
        this.dailyExerciseId = dailyExerciseId;
    }
    public Dailylog getDailylog() {
        return this.dailylog;
    }
    
    public void setDailylog(Dailylog dailylog) {
        this.dailylog = dailylog;
    }
    public Excercise getExcercise() {
        return this.excercise;
    }
    
    public void setExcercise(Excercise excercise) {
        this.excercise = excercise;
    }
    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }




}

