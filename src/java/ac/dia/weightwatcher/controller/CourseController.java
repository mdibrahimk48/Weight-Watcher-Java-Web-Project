/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.CourseDao;
import ac.dia.weightwatcher.dao.UserDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.pojo.Course;
import ac.dia.weightwatcher.pojo.Users;
import javax.faces.model.SelectItem;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class CourseController {
    public Course course=new Course();
public ArrayList<Course> courses=new ArrayList<Course>();
CourseDao courseDao =new CourseDao();
public String msg ="";
public Users users=new Users();
ArrayList<SelectItem> selectItemsUser =new ArrayList<SelectItem>();
UserDao userDao=new UserDao();

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CourseController() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public ArrayList<SelectItem> getSelectItemsUser() {
        selectItemsUser.clear();
        selectItemsUser=new ArrayList<>();
        for(Users u : userDao.getAll(users)){
            selectItemsUser.add(new SelectItem(u.getUserId(), u.getUserName()));
        }
        return selectItemsUser;
    }

    public void setSelectItemsUser(ArrayList<SelectItem> selectItemsUser) {
        this.selectItemsUser = selectItemsUser;
    }
    
    
     
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Creates a new instance of UserController
     */
    public void setCourses(ArrayList<Course> courses) {     
        this.courses = courses;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        users.setUserId(course.getUsers().getUserId());
        users=userDao.find(users);
        course.setBmi(users.getBmi());
        if(users.getBmi()>24)
            course.setBmi(24-users.getBmi());
        else if(users.getBmi()<18)
            course.setBmi(users.getBmi()-18);
        courseDao.save(course);
        setMsg("Course Save");
        clear();
        
    }
     public void delete(){
        courseDao.delete(course);
        setMsg("Course Deleted");
        clear();
    }
      public void update(){
        courseDao.update(course);
        setMsg("Course Updated");
    }
       public void find(){
           Course c=courseDao.find(course);
           if(c!=null){
               course.setUsers(c.getUsers());
               course.setStartDate(c.getStartDate());
               course.setEndDate(c.getEndDate());
               course.setBmi(c.getBmi());
               
        }else{
        
        setMsg("Course not Found");  
           }
       
    }
      public void clear(){
     course.setCourseId(null);
     course.setEndDate(null);
     course.setStartDate(null);
     
       }
    public void display(){
        courses=courseDao.getAll(course);
    }
     public void newCourse(){
       course=new Course();
    }
}
