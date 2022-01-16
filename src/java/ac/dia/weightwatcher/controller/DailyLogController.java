/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.dao.ActivityDao;
import ac.dia.weightwatcher.dao.CourseDao;
import ac.dia.weightwatcher.dao.DailyLogDao;
import ac.dia.weightwatcher.pojo.Activity;
import ac.dia.weightwatcher.pojo.Course;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.pojo.Dailylog;
import ac.dia.weightwatcher.pojo.Users;
import java.util.Iterator;
import javax.faces.model.SelectItem;
import org.hibernate.Session;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class DailyLogController {

    public Dailylog dailyLog = new Dailylog();
    public ArrayList<Dailylog> dailyLogs = new ArrayList<Dailylog>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    public String msg = "";
    public Activity activities = new Activity();
    ArrayList<SelectItem> selectItemsActivity = new ArrayList<SelectItem>();
    public Course course = new Course();
    ArrayList<SelectItem> selectItemsCourse = new ArrayList<SelectItem>();
    ActivityDao activityDao = new ActivityDao();
    CourseDao courseDao = new CourseDao();
    Users users = new Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * Creates a new instance of UserController
     */
    public DailyLogController() {
    }

    public Activity getActivities() {
        return activities;
    }

    public void setActivities(Activity activities) {
        this.activities = activities;
    }

    public ArrayList<SelectItem> getSelectItemsActivity() {
        for (Activity a : activityDao.getAll(activities)) {
            selectItemsActivity.add(new SelectItem(a.getActivityId(), a.getActivityName()));
        }
        return selectItemsActivity;
    }

    public void setSelectItemsActivity(ArrayList<SelectItem> selectItemsActivity) {
        this.selectItemsActivity = selectItemsActivity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course courses) {
        this.course = courses;
    }

    public ArrayList<SelectItem> getSelectItemsCourse() {
       
        return selectItemsCourse;
    }

    public void setSelectItemsCourse(ArrayList<SelectItem> selectItemsCourse) {
        this.selectItemsCourse = selectItemsCourse;
    }

    public Dailylog getDailyLog() {
        return dailyLog;
    }

    public void setDailyLog(Dailylog dailyLog) {
        this.dailyLog = dailyLog;
    }

    public ArrayList<Dailylog> getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(ArrayList<Dailylog> dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void save() {
        dailyLog.setCourse(course);
        dailyLogDao.save(dailyLog);
        setMsg("Daily Log Save");
        clear();
    }

    public void delete() {
        dailyLogDao.delete(dailyLog);
        setMsg("Daily Log Deleted");
        clear();
    }

    public void update() {
        dailyLogDao.update(dailyLog);
        setMsg("Daily Log Updated");
    }

    public void find() {
        Dailylog dl = dailyLogDao.find(dailyLog);
        if (dl != null) {
            dailyLog.setCourse(dl.getCourse());
            dailyLog.setActivity(dl.getActivity());
            dailyLog.setDate(dl.getDate());
            dailyLog.setProgress(dl.getProgress());
        } else {
            setMsg("Daily Log not Found");
        }

    }

    public void display() {
        dailyLogs = dailyLogDao.getAll(dailyLog);
    }

    public void newDailyExercise() {
        dailyLog = new Dailylog();
    }
    public void clear(){
        dailyLog.setLogId(null);
        dailyLog.setDate(null);
        dailyLog.setCourse(null);
        dailyLog.setProgress(null);
    }
    public void selectCourse() {
    course=courseDao.getCourseById(users.getUserId());
    }

}
