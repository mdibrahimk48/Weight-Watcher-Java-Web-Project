/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Meal;

/**
 *
 * @author Babu
 */
public class MealDao extends WeightWatcherDao<Meal>{
    public Meal find(Meal value) {
        return find(value, value.getMealId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Meal value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Meal value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Meal e=(Meal) session.get(value.getClass(),value.getMealId());
        if(e!=null){
        e.setMealName(value.getMealName());
        e.setMealUnit(value.getMealUnit());
        e.setMealCalorie(value.getMealCalorie());
        
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
}
