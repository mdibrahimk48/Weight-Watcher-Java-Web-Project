/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Course;
import ac.dia.weightwatcher.pojo.Users;
import java.util.Iterator;

/**
 *
 * @author Babu
 */
public class CourseDao extends WeightWatcherDao<Course>{
     public Course find(Course value) {
        return find(value, value.getCourseId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Course value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Course value) {
        session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Course c=(Course) session.get(value.getClass(),value.getCourseId());
        if(c!=null){
        c.setUsers(value.getUsers());
        c.setStartDate(value.getStartDate());
        c.setEndDate(value.getEndDate());
        c.setBmi(value.getBmi()); 
        session.update(value);
        session.getTransaction().commit();
    }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }
 public Course getCourseById(int id){
 Course c=new Course();
 session=WeightWatcherUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Users u=(Users) session.get(Users.class,id);
         Iterator<Course> ui = u.getCourses().iterator();
         if(ui.hasNext())
             c=ui.next();
       
 return c;
 }
}
