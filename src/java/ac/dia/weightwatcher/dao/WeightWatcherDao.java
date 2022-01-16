/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import java.util.ArrayList;
import static javafx.scene.input.KeyCode.T;
import org.hibernate.Session;
import ac.dia.weightwatcher.Util.WeightWatcherUtil;

/**
 *
 * @author Babu
 */
public class WeightWatcherDao<T> {
    Session session=WeightWatcherUtil.getSessionFactory().openSession();
    
    public void save(T value){
        session.beginTransaction();
        session.save(value);
        session.getTransaction().commit();
        
        
    }
     public void update(T value){
        session.beginTransaction();
        session.update(value);
        session.getTransaction().commit();
        
    }
      public void delete(T value){
        session.beginTransaction();
        session.delete(value);
       session.getTransaction().commit();
        
    }
       public T find(T value,int id){
       return (T) session.get(value.getClass(), id);
       
    }
        public ArrayList<T> getAll(T value){
            return (ArrayList<T>) session.createCriteria(value.getClass()).list();
        }
}
