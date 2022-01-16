/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.dao.ExcerciseDao;
import ac.dia.weightwatcher.pojo.Excercise;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class ExcerciseController {
    public Excercise excercise=new Excercise();
public ArrayList<Excercise> excercises=new ArrayList<Excercise>();
ExcerciseDao excerciseDao =new ExcerciseDao();
public String msg ="";

    /**
     * Creates a new instance of UserController
     */
    public ExcerciseController() {
    }

    public Excercise getExcercise() {
        return excercise;
    }

    public void setExcercise(Excercise excercise) {
        this.excercise = excercise;
    }

    public ArrayList<Excercise> getExcercises() {
        return excercises;
    }

    public void setExcercises(ArrayList<Excercise> excercises) {
        this.excercises = excercises;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        excerciseDao.save(excercise);
        setMsg("Excercise Save");
      
    }
     public void delete(){
        excerciseDao.delete(excercise);
        setMsg("Excercise Deleted");
        clear();
    }
      public void update(){
        excerciseDao.update(excercise);
        setMsg("Excercise Updated");
    }
       public void find(){
           Excercise e=excerciseDao.find(excercise);
           if(e!=null){
        excercise.setExcerciseName(e.getExcerciseName());
        excercise.setType(e.getType());
        excercise.setTime(e.getTime());
        excercise.setBurnCalorie(e.getBurnCalorie());
        }else{
        
        setMsg("Excercise not Found");  
           }
       
    }
        public void clear(){
       excercise.setExcerciseId(null);
       excercise.setExcerciseName(null);
       excercise.setType(null);
       excercise.setTime(null);
       excercise.setBurnCalorie(null);
       
       }
    public void display(){
        excercises=excerciseDao.getAll(excercise);
    }
     public void newExcercise(){
       excercise=new Excercise();
    }
}
