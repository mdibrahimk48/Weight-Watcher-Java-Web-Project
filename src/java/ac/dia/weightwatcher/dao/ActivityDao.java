/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Activity;

/**
 *
 * @author Babu
 */
public class ActivityDao extends WeightWatcherDao<Activity>{
     public Activity find(Activity value) {
        return find(value, value.getActivityId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Activity value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Activity value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Activity ac=(Activity) session.get(value.getClass(),value.getActivityId());
        if(ac!=null){
            ac.setActivityName(value.getActivityName());
           
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
}
