/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Dailymeasurement;

/**
 *
 * @author Babu
 */
public class DailyMeasurementDao extends WeightWatcherDao<Dailymeasurement>{
     public Dailymeasurement find(Dailymeasurement value) {
        return find(value, value.getDailyMeasurementId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dailymeasurement value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Dailymeasurement value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Dailymeasurement dmm=(Dailymeasurement) session.get(value.getClass(),value.getDailyMeasurementId());
        if(dmm!=null){
            dmm.setDailylog(value.getDailylog());
            dmm.setWaistSize(value.getWaistSize());
            dmm.setWeight(value.getWeight());
            dmm.setShift(value.getShift());
            
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
    
}
