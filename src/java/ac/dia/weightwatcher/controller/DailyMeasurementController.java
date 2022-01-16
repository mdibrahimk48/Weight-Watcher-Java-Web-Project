/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.DailyLogDao;
import ac.dia.weightwatcher.dao.DailyMeasurementDao;
import ac.dia.weightwatcher.pojo.Dailylog;
import ac.dia.weightwatcher.pojo.Dailymeasurement;
import ac.dia.weightwatcher.pojo.Users;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class DailyMeasurementController {
    public Dailymeasurement dailyMeasurement=new Dailymeasurement();
    public ArrayList<Dailymeasurement> dailyMeasurements=new ArrayList<Dailymeasurement>();
    DailyMeasurementDao dailyMeasurementDao =new DailyMeasurementDao();
    public String msg ="";
    public Dailylog dailylog=new Dailylog();
    ArrayList<SelectItem> selectItemsDailylog =new ArrayList<SelectItem>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    Users users=new Users();

   
    public Users getUsers() {
        return users;
    }

    /**
     * Creates a new instance of UserController
     */
    public void setUsers(Users users) {   
        this.users = users;
    }

    public DailyMeasurementController() {
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

    public Dailymeasurement getDailyMeasurement() {
        return dailyMeasurement;
    }

    public void setDailyMeasurement(Dailymeasurement dailyMeasurement) {
        this.dailyMeasurement = dailyMeasurement;
    }

    public ArrayList<Dailymeasurement> getDailyMeasurements() {
        return dailyMeasurements;
    }

    public void setDailyMeasurements(ArrayList<Dailymeasurement> dailyMeasurements) {
        this.dailyMeasurements = dailyMeasurements;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
         dailyMeasurement.setDailylog(dailylog);
        dailyMeasurementDao.save(dailyMeasurement);
        setMsg("Daily Measurement Save");
        clear();
    }
     public void delete(){
        dailyMeasurementDao.delete(dailyMeasurement);
        setMsg("Daily Measurement Deleted");
        clear();
    }
      public void update(){
        dailyMeasurementDao.update(dailyMeasurement);
        setMsg("Daily Measurement Updated");
    }
       public void find(){
           Dailymeasurement dm=dailyMeasurementDao.find(dailyMeasurement);
           if(dm!=null){
               dailyMeasurement.setDailylog(dm.getDailylog());
               dailyMeasurement.setWaistSize(dm.getWaistSize());
               dailyMeasurement.setWeight(dm.getWeight());
               dailyMeasurement.setShift(dm.getShift());
        }else{
        
        setMsg("Daily Measurement not Found");  
           }
       
    }
       public void clear(){
       dailyMeasurement.setDailyMeasurementId(null);
       dailyMeasurement.setDailylog(null);
       dailyMeasurement.setWaistSize(0);
       dailyMeasurement.setWeight(0);
       dailyMeasurement.setShift(null);
       }
    public void display(){
        dailyMeasurements=dailyMeasurementDao.getAll(dailyMeasurement);
    }
     public void newDailyMeasurement(){
       dailyMeasurement=new Dailymeasurement();
    }
     public void selectDailylog() {
    dailylog=dailyLogDao.getDailylogById(users.getUserId());
    }
}
