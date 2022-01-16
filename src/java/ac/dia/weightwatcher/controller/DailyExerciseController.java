/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.DailyExerciseDao;
import ac.dia.weightwatcher.dao.DailyLogDao;
import ac.dia.weightwatcher.dao.ExcerciseDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.pojo.Dailyexercise;
import ac.dia.weightwatcher.pojo.Dailylog;
import ac.dia.weightwatcher.pojo.Excercise;
import ac.dia.weightwatcher.pojo.Users;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import javax.faces.model.SelectItem;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class DailyExerciseController {
    public Dailyexercise dailyExercise=new Dailyexercise();
public ArrayList<Dailyexercise> dailyExercises=new ArrayList<Dailyexercise>();
DailyExerciseDao dailyExerciseDao =new DailyExerciseDao();
public String msg ="";
public Dailylog dailylog=new Dailylog();
    ArrayList<SelectItem> selectItemsDailylog =new ArrayList<SelectItem>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    public Excercise excercise =new Excercise();
    ArrayList<SelectItem> selectItemsExercise =new ArrayList<SelectItem>();
    ExcerciseDao exerciseDao =new ExcerciseDao();
    Users users=new  Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public DailyExerciseController() {
    }

    public Dailylog getDailylog() {
        return dailylog;
    }

    public void setDailylog(Dailylog dailylog) {
        this.dailylog = dailylog;
    }

    public ArrayList<SelectItem> getSelectItemsDailylog() {
        
        return selectItemsDailylog;
    }

    public void setSelectItemsDailylog(ArrayList<SelectItem> selectItemsDailylog) {
        this.selectItemsDailylog = selectItemsDailylog;
    }

    public Excercise getExcercise() {
        return excercise;
    }

    public void setExcercise(Excercise excercise) {
        this.excercise = excercise;
    }

    public ArrayList<SelectItem> getSelectItemsExercise() {
        selectItemsExercise.clear();
        for(Excercise e: exerciseDao.getAll(excercise)){
            selectItemsExercise.add(new SelectItem(e.getExcerciseId(), e.getExcerciseName()));
        }
        return selectItemsExercise;
    }

    public void setSelectItemsExercise(ArrayList<SelectItem> selectItemsExercise) {
        this.selectItemsExercise = selectItemsExercise;
    }

    public Dailyexercise getDailyExercise() {
        return dailyExercise;
    }

    public void setDailyExercise(Dailyexercise dailyExercise) {
        this.dailyExercise = dailyExercise;
    }

    public ArrayList<Dailyexercise> getDailyExercises() {
        return dailyExercises;
    }

    public void setDailyExercises(ArrayList<Dailyexercise> dailyExercises) {
        this.dailyExercises = dailyExercises;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        dailyExercise.setDailylog(dailylog);
        dailyExerciseDao.save(dailyExercise);
        setMsg("Daily Exercise Save");
        clear();
    }
     public void delete(){
        dailyExerciseDao.delete(dailyExercise);
        setMsg("Daily Exercise Deleted");
        clear();
    }
      public void update(){
        dailyExerciseDao.update(dailyExercise);
        setMsg("Daily Exercise Updated");
    }
       public void find(){
           Dailyexercise de=dailyExerciseDao.find(dailyExercise);
           if(de!=null){
               dailyExercise.setDailylog(de.getDailylog());
               dailyExercise.setExcercise(de.getExcercise());
               dailyExercise.setTime(de.getTime());
        }else{
        
        setMsg("Daily Exercise not Found");  
           }
       
    }
        public void clear(){
       dailyExercise.setDailyExerciseId(null);
       dailyExercise.setTime(null);
       }
    public void display(){
        dailyExercises=dailyExerciseDao.getAll(dailyExercise);
    }
     public void newDailyExercise(){
       dailyExercise=new Dailyexercise();
    }
     public void selectDailylog() {
    dailylog=dailyLogDao.getDailylogById(users.getUserId());
    }
}
