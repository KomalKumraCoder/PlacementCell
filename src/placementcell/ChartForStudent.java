/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placementcell;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Admin
 */
public class ChartForStudent {
    public static void main(String[] args) {
        try{
    String q="select * from tbresultmain";
     myConnection obj=new myConnection();
     PreparedStatement st=obj.db.prepareStatement(q);
      ResultSet resultSet = st.executeQuery();
     
      DefaultPieDataset dataset = new DefaultPieDataset( );
      while(resultSet.next() ) 
      {
         dataset.setValue(resultSet.getString( "Rollno" ) ,Integer.parseInt( resultSet.getString( "cans" )));
      }
        JFreeChart chart= ChartFactory.createPieChart(
         "Student Answer Correction",  // chart title           
         dataset,         // data           
         true,            // include legend          
         true,           
         false );
      int width = 560; /* Width of the image */
      int height = 370; /* Height of the image */ 
      File pieChart = new File( "Pie_Chart.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
            
            
            
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
  
}
