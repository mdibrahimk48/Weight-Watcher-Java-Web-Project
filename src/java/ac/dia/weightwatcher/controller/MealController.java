/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.dao.MealDao;
import ac.dia.weightwatcher.pojo.Meal;

/**
 *
 * @author Numan
 */
@ManagedBean
@RequestScoped
public class MealController {
    public Meal meal=new Meal();
public ArrayList<Meal> meals=new ArrayList<Meal>();
MealDao mealDao =new MealDao();
public String msg ="";

    /**
     * Creates a new instance of UserController
     */
    public MealController() {
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        mealDao.save(meal);
        
        setMsg("Meal Save");
        clear();
    }
     public void delete(){
        mealDao.delete(meal);
        setMsg("Meal Deleted");
        clear();
    }
      public void update(){
        mealDao.update(meal);
        setMsg("Meal Updated");
    }
       public void find(){
           Meal m=mealDao.find(meal);
           if(m!=null){
        meal.setMealName(m.getMealName());
        meal.setMealUnit(m.getMealUnit());
        meal.setMealCalorie(m.getMealCalorie());
        }else{
        
        setMsg("Meal not Found");  
           }
       
    }
        public void clear(){
       meal.setMealId(null);
       meal.setMealName(null);
       meal.setMealUnit(null);
       meal.setMealCalorie(null);
       
       }
    public void display(){
        meals=mealDao.getAll(meal);
    }
     public void newMeal(){
       meal=new Meal();
    }
}
