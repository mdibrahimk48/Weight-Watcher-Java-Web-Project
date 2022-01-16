/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Course;
import ac.dia.weightwatcher.pojo.Dailylog;
import ac.dia.weightwatcher.pojo.Users;
import java.util.Iterator;
import org.hibernate.Session;

/**
 *
 * @author Babu
 */
public class DailyLogDao extends WeightWatcherDao<Dailylog>{
     public Dailylog find(Dailylog value) {
        return find(value, value.getLogId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dailylog value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Dailylog value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Dailylog dl=(Dailylog) session.get(value.getClass(),value.getLogId());
        if(dl!=null){
            dl.setCourse(value.getCourse());
            dl.setActivity(value.getActivity());
            dl.setDate(value.getDate());
            dl.setProgress(value.getProgress());
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
    public Dailylog getDailylogById(int id){
         Dailylog dl=new Dailylog();
        Session session = WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Users u=(Users) session.get(Users.class,id);
         Iterator<Course> ui = u.getCourses().iterator();
         if(ui.hasNext()){
           Course  c=ui.next();
           Iterator<Dailylog> dui =  c.getDailylogs().iterator();
             while(dui.hasNext())
                 dl=dui.next();
         }
 return dl;
 }
}
