/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.UserDao;
import ac.dia.weightwatcher.pojo.Users;
import ac.dia.weightwatcher.report.Report;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Babu
 */
@ManagedBean
@RequestScoped
public class ReportController  {
    ArrayList<Report> reports=new ArrayList<Report>();
    UserDao userDao=new UserDao();
    Users users=new Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
    
   public void viewReport() {
    reports=(ArrayList<Report>) userDao.getAllDetail(users.getUserId());
   
    }
}
