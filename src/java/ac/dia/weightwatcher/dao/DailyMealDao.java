/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Dailymeal;

/**
 *
 * @author Babu
 */
public class DailyMealDao extends WeightWatcherDao<Dailymeal>{
    public Dailymeal find(Dailymeal value) {
        return find(value, value.getDailyMealId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dailymeal value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Dailymeal value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Dailymeal dm=(Dailymeal) session.get(value.getClass(),value.getDailyMealId());
        if(dm!=null){
            dm.setDailylog(value.getDailylog());
            dm.setMeal(value.getMeal());
            dm.setMealIntake(value.getMealIntake());
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
}
