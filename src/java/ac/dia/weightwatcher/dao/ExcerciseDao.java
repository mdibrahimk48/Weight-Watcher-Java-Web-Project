/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Excercise;

/**
 *
 * @author Babu
 */
public class ExcerciseDao extends WeightWatcherDao<Excercise>{
    public Excercise find(Excercise value) {
        return find(value, value.getExcerciseId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Excercise value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Excercise value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Excercise e=(Excercise) session.get(value.getClass(),value.getExcerciseId());
        if(e!=null){
        e.setExcerciseName(value.getExcerciseName());
        e.setType(value.getType());
        e.setTime(value.getTime());
        e.setBurnCalorie(value.getBurnCalorie());
        
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
}
