/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.Util.WeightWatcherUtil;
import ac.dia.weightwatcher.pojo.Users;
import ac.dia.weightwatcher.report.Report;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class UserDao extends WeightWatcherDao<Users> {

    Report report = new Report();

    public Users find(Users value) {
        return find(value, value.getUserId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Users value) {
        super.delete(find(value)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Users value) {
        Users u = find(value);
        if (u != null) {
            u.setUserName(value.getUserName());
            u.setGender(value.getGender());
            u.setHeight(value.getHeight());
            u.setWeight(value.getWeight());
            u.setAge(value.getAge());
            u.setWaistSize(value.getWaistSize());
            u.setBmi(value.getBmi());
            super.update(u);
        }
        //super.update(value); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Report> getAllDetail(int id) {
        List<Report> reports = new ArrayList<Report>();
        Session session = WeightWatcherUtil.getSessionFactory().openSession();
        String sql = "select users.userId, users.userName, course.course_id, dailylog.logId, dailylog.date,"
                + " dailyexercise.time, dailymeal.mealIntake, meal.mealCalorie, excercise.burnCalorie "
                + " from users "
                + " left join course on users.userId=course.userId "
                + " left join dailylog on course.course_id=dailylog.courseId "
                + " left join dailymeal on dailylog.logId=dailymeal.logId "
                + " left join dailyexercise on dailylog.logId=dailyexercise.logId "
                + " left join meal on dailymeal.mealId=meal.mealId "
                + " left join excercise on dailyexercise.exerciseId=excercise.excerciseId "
                + " where users.userId = "+id ;
        List<Object[]> list = session.createSQLQuery(sql).list();
        for (Object[] objects : list) {
            Report r = new Report();
            r.setUserId(objects[0].toString());
            r.setUserName(objects[1].toString());
            r.setCourse_id(objects[2].toString());
            r.setLogId(objects[3].toString());
            r.setDate(objects[4].toString());
            r.setTime(objects[5].toString());
            r.setMealIntake(Double.parseDouble(objects[6].toString()));
            r.setMealCalorie(Double.parseDouble(objects[7].toString()));
            r.setBurnCalorie(Double.parseDouble(objects[8].toString()));
            reports.add(r);
        }
        return reports;
    }
     public List<Report> getAllDetails() {
        List<Report> reports = new ArrayList<Report>();
        Session session = WeightWatcherUtil.getSessionFactory().openSession();
        
        String sql = "select users.userId, users.userName, course.course_id, dailylog.logId, dailylog.date, dailyexercise.time, dailymeal.mealIntake,  meal.mealCalorie, excercise.burnCalorie"
                + " from users "
                + " left join course on users.userId=course.userId "
                + " left join dailylog on course.course_id=dailylog.courseId "
                + " left join dailymeal on dailylog.logId=dailymeal.logId "
              
                + " left join dailyexercise on dailylog.logId=dailyexercise.logId "
                + " left join meal on dailymeal.mealId=meal.mealId "
                + " left join excercise on dailyexercise.exerciseId=excercise.excerciseId "
               + " where users.userId = 17 " ;
               

        List<Object[]> list = session.createSQLQuery(sql).list();
        for (Object[] objects : list) {
            Report r = new Report();
            r.setUserId(objects[0].toString());
            r.setUserName(objects[1].toString());
            r.setCourse_id(objects[2].toString());
            r.setLogId(objects[3].toString());
            r.setDate(objects[4].toString());
            r.setTime(objects[5].toString());
            r.setMealIntake(Double.parseDouble(objects[6].toString()));
            r.setMealCalorie(Double.parseDouble(objects[7].toString()));
            r.setBurnCalorie(Double.parseDouble(objects[8].toString()));

            reports.add(r);
        }

        return reports;
    }
    
}
