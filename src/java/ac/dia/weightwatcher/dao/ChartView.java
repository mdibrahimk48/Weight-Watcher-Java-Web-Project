/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.dia.weightwatcher.dao;

import ac.dia.weightwatcher.controller.ReportChartController;
import ac.dia.weightwatcher.controller.ReportController;
import ac.dia.weightwatcher.pojo.Users;
import ac.dia.weightwatcher.report.Report;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author NSohel
 */
@ManagedBean
@RequestScoped
public class ChartView {
  private LineChartModel lineModel1;
    private LineChartModel lineModel2;
     ArrayList<Report> reports = new ArrayList<Report>();
    UserDao userDao = new UserDao();
    Users users = new Users();

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel2=initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
       
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        Axis xAxis=lineModel1.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(50);
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
    reports=(ArrayList<Report>) userDao.getAllDetails();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Meal Intake");
        int i=1;
        for (Report report : reports) {
            series1.set(i++,report.getMealIntake());
        }

        model.addSeries(series1);
        return model;
    }
}
