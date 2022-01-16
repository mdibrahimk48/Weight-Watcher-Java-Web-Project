/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.DailyLogDao;
import ac.dia.weightwatcher.dao.DailyMealDao;
import ac.dia.weightwatcher.dao.MealDao;
import ac.dia.weightwatcher.pojo.Dailylog;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.pojo.Dailymeal;
import ac.dia.weightwatcher.pojo.Meal;
import ac.dia.weightwatcher.pojo.Users;
import java.util.Iterator;
import javax.faces.model.SelectItem;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class DailyMealController {
    public Dailymeal dailyMeal=new Dailymeal();
public ArrayList<Dailymeal> dailyMeals=new ArrayList<Dailymeal>();
DailyMealDao dailyMealDao =new DailyMealDao();
public String msg ="";
public Meal meal =new Meal();
    ArrayList<SelectItem> selectItemsMeal =new ArrayList<SelectItem>();
    MealDao mealDao=new MealDao();
    public Dailylog dailylog=new Dailylog();
    ArrayList<SelectItem> selectItemsDailylog =new ArrayList<SelectItem>();
    DailyLogDao dailyLogDao = new DailyLogDao();
    Users users =new Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

   
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public ArrayList<SelectItem> getSelectItemsMeal() {
        return selectItemsMeal;
    }

    public void setSelectItemsMeal(ArrayList<SelectItem> selectItemsMeal) {
        this.selectItemsMeal = selectItemsMeal;
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

    /**
     * Creates a new instance of UserController
     */
    public void setSelectItemsDailylog(ArrayList<SelectItem> selectItemsDailylog) {   
        this.selectItemsDailylog = selectItemsDailylog;
    }

    public DailyMealController() {
    }

    public Dailymeal getDailyMeal() {
        for(Meal m: mealDao.getAll(meal)){
            selectItemsMeal.add(new SelectItem(m.getMealId(), m.getMealName()));
        }
        return dailyMeal;
    }

    public void setDailyMeal(Dailymeal dailyMeal) {
        this.dailyMeal = dailyMeal;
    }

    public ArrayList<Dailymeal> getDailyMeals() {
        return dailyMeals;
    }

    public void setDailyMeals(ArrayList<Dailymeal> dailyMeals) {
        this.dailyMeals = dailyMeals;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        dailyMeal.setDailylog(dailylog);
        dailyMealDao.save(dailyMeal);
        setMsg("Daily Meal Save");
        clear();
    }
     public void delete(){
        dailyMealDao.delete(dailyMeal);
        setMsg("Daily Meal Deleted");
        clear();
    }
      public void update(){
        dailyMealDao.update(dailyMeal);
        setMsg("Daily Meal Updated");
    }
       public void find(){
           Dailymeal dm=dailyMealDao.find(dailyMeal);
           if(dm!=null){
               dailyMeal.setDailylog(dm.getDailylog());
               dailyMeal.setMeal(dm.getMeal());
               dailyMeal.setMealIntake(dm.getMealIntake());

        }else{
        
        setMsg("Daily Meal not Found");  
           }
       
    }
        public void clear(){
      dailyMeal.setDailyMealId(null);
      dailyMeal.setMealIntake(null);
      
       }
    public void display(){
        dailyMeals=dailyMealDao.getAll(dailyMeal);
    }
     public void newDailyMeal(){
       dailyMeal=new Dailymeal();
    }
      public void selectDailylog() {
    dailylog=dailyLogDao.getDailylogById(users.getUserId());
    }
}
