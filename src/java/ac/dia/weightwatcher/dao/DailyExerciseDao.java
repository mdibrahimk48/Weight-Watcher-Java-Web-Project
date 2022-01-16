/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Dailyexercise;

/**
 *
 * @author Babu
 */
public class DailyExerciseDao extends WeightWatcherDao<Dailyexercise>{
    public Dailyexercise find(Dailyexercise value) {
        return find(value, value.getDailyExerciseId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dailyexercise value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Dailyexercise value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Dailyexercise de=(Dailyexercise) session.get(value.getClass(),value.getDailyExerciseId());
        if(de!=null){
            de.setDailylog(value.getDailylog());
            de.setExcercise(value.getExcercise());
            de.setTime(value.getTime());
           
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
}
