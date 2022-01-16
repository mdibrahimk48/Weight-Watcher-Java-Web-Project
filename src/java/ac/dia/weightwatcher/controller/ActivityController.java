/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.ActivityDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.pojo.Activity;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class ActivityController {
    public Activity activity=new Activity();
public ArrayList<Activity> activities=new ArrayList<Activity>();
ActivityDao activityDao =new ActivityDao();
public String msg ="";

    /**
     * Creates a new instance of UserController
     */
    public ActivityController() {
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        activityDao.save(activity);
        setMsg("Activity Save");
        clear();
    }
     public void delete(){
        activityDao.delete(activity);
        setMsg("Activity Deleted");
        clear();
    }
      public void update(){
        activityDao.update(activity);
        setMsg("Activity Updated");
    }
       public void find(){
           Activity a=activityDao.find(activity);
           if(a!=null){
               activity.setActivityName(a.getActivityName());
        
        }else{
        
        setMsg("Activity not Found");  
           }
       
    }
       public void clear(){
       activity.setActivityId(null);
       activity.setActivityName(null);
       }
    public void display(){
        activities=activityDao.getAll(activity);
    }
     public void newActivity(){
       activity=new Activity();
    }
}
