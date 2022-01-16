/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import ac.dia.weightwatcher.dao.UserDao;
import ac.dia.weightwatcher.pojo.Users;
import java.util.List;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class UserController {
public Users user=new Users();
public ArrayList<Users> userses=new ArrayList<Users>();
UserDao userDao =new UserDao();
public String msg ="";

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ArrayList<Users> getUserses() {
        return userses;
    }

    public void setUserses(ArrayList<Users> userses) {
        this.userses = userses;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void save(){
        double bmi=user.getWeight()/(user.getHeight()*user.getHeight());
        user.setBmi(bmi);
        userDao.save(user);
        setMsg("User Save");
        clear();
    }
      public void update(){
           double bmi=user.getWeight()/(user.getHeight()*user.getHeight());
        user.setBmi(bmi);
        userDao.update(user);
        setMsg("User Updated");
    }
       public void find(){
           Users u=userDao.find(user);
           if(u!=null){
        user.setUserName(u.getUserName());
        user.setGender(u.getGender());
        user.setHeight(u.getHeight());
        user.setWeight(u.getWeight());
        user.setWaistSize(u.getWaistSize());
        user.setAge(u.getAge());
        user.setBmi(u.getBmi());
        }else{
        setMsg("User not Found");  
           }
    }
        public void clear(){
       user.setUserId(null);
       user.setUserName(null);
       user.setGender(null);
       user.setHeight(null);
       user.setWeight(null);
       user.setWaistSize(0);
       user.setAge(null);
       user.setBmi(null);
       
       }
          public void delete(){
        userDao.delete(user);
        setMsg("User Deleted");
        clear();
    }
    public void display(){
        userses=userDao.getAll(user);
    }
    
    
    
//    public List getAllDetail(){
//    return null;
//    }
//    
}
