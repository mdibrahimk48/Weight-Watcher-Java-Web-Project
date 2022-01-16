/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.controller;

import ac.dia.weightwatcher.dao.UserDao;
import ac.dia.weightwatcher.pojo.Users;
import ac.dia.weightwatcher.report.Report;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Babu
 */
@ManagedBean
@ViewScoped

public class ReportChartController implements Serializable{

    LineChartModel model = new LineChartModel();
    LineChartSeries weightSeries = new LineChartSeries();
    LineChartSeries caloriSeries = new LineChartSeries();
    LineChartSeries burnSeries = new LineChartSeries();
    ArrayList<Report> reports = new ArrayList<Report>();
    UserDao userDao = new UserDao();
    Users users = new Users();

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public LineChartModel getModel() {
        return model;
    }

    public void setModel(LineChartModel model) {
        this.model = model;
    }

    public LineChartSeries getWeightSeries() {
        return weightSeries;
    }

    public void setWeightSeries(LineChartSeries weightSeries) {
        this.weightSeries = weightSeries;
    }

    public LineChartSeries getCaloriSeries() {
        return caloriSeries;
    }

    public void setCaloriSeries(LineChartSeries caloriSeries) {
        this.caloriSeries = caloriSeries;
    }

    public LineChartSeries getBurnSeries() {
        return burnSeries;
    }

    public void setBurnSeries(LineChartSeries burnSeries) {
        this.burnSeries = burnSeries;
    }
    
    public LineChartModel viewReport() {

        model.setTitle("Report Of Weight,Calorie Intake, Burn Calories");
        caloriSeries.setLabel("Calorie Intake");
        burnSeries.setLabel("Burn Calories");
        model.getAxes().put(AxisType.X, new CategoryAxis("Date"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
        users.setUserId(17);
        reports = (ArrayList<Report>) userDao.getAllDetail(users.getUserId());
      
        for (Report report : reports) {
            caloriSeries.set(report.getDate(), report.getMealCalorie());
          //  burnSeries.set(report.getDate(), report.getBurnCalorie());
            model.addSeries(caloriSeries);
            //model.addSeries(burnSeries);

        }
        return model;
    }
}
