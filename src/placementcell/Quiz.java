/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package placementcell;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Admin
 */
public class Quiz extends javax.swing.JFrame {
    ArrayList<CsQuiz> cArray = new ArrayList<>();
    
    

    /**
     * Creates new form Quiz
     */
    String Rollno;
    String CompanyId;
    public Quiz() {
        initComponents();
        //display();
    }
    public Quiz(String rollno,String cid){
        System.out.println(rollno);
        System.out.println(cid);
       Rollno=rollno;
       CompanyId=cid;
       initComponents();
       display();
       getContentPane().setBackground(Color.BLUE);
    }
   
void display(){
 try{
     String q="select * from tbquestion";
     myConnection obj=new myConnection();
     PreparedStatement pst=obj.db.prepareStatement(q);
     ResultSet rs;
     rs=pst.executeQuery();
     
     JRadioButton op1=null,op2=null,op3=null,op4=null;
     JLabel lop1=null;
     int x=10,y=20,w=400,h=40;
     ButtonGroup b = null;
     while(rs.next()){
      b=new ButtonGroup();
      CsQuiz c = new CsQuiz();
      c.setId(rs.getInt("id"));
      c.setQname(rs.getString("question"));
      c.setOption1(rs.getString("option1"));
      c.setOption2(rs.getString("option2"));
      c.setOption3(rs.getString("option3"));
      c.setOption4(rs.getString("option4"));
      c.setAnswer(-1);
      c.setcorrectAnswer(rs.getInt("correctAnswer"));
      op1 = new JRadioButton(c.getOption1());
      op2 = new JRadioButton(c.getOption2());
      op3 = new JRadioButton(c.getOption3());
      op4 = new JRadioButton(c.getOption4());
      lop1 = new JLabel();
      lop1.setText(c.getQname());
      lop1.setBounds(x, y, w, h);
      y=y+20;
      op1.setBounds(x, y, w, h);
      y=y+20;
      op2.setBounds(x, y, w, h);
      y=y+20;
      op3.setBounds(x, y, w, h);
      y=y+20;
      op4.setBounds(x, y, w, h);
      y=y+20;
      b.add(op1);
      b.add(op2);
      b.add(op3);
      b.add(op4);
      add(lop1);
      add(op1);
      add(op2);
      add(op3);
      add(op4);
      
      cArray.add(c);
      op1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
         c.setAnswer(1);
          }
          
      });
      op2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              c.setAnswer(2);
          }
      });
      op3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              c.setAnswer(3);
          }
      });
      op4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              c.setAnswer(4);
          }
      }); 
     }
     JButton bsubmit = new JButton("Submit");
       bsubmit.setBounds(x, y+40, w, h);
       add(bsubmit);
       bsubmit.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             if(e.getSource() == bsubmit){
                 JOptionPane.showMessageDialog(rootPane, "These answers will be submitted");
             }
             int cans=0,inans=0,unatt=0;
             for(int i=0;i<cArray.size();i++){
               CsQuiz ca=null;
               
               ca = (CsQuiz)cArray.get(i);
               if(ca.getAnswer()==-1)
               {
                   unatt=unatt+1;
               }
              else if(ca.getAnswer()==ca.getcorrectAnswer()){
                   cans=cans+1;
               }
              else
                   inans=inans+1;
               
               try{
                   myConnection obj = new myConnection();
                   String q="insert into tbresult(QID,Rollno,Answer,createDate)values(?,?,?,?)";
                   PreparedStatement pst=obj.db.prepareStatement(q);
                   pst.setInt(1, ca.getId());
                   pst.setString(2,Rollno);
                   pst.setInt(3, ca.getAnswer());
                   System.out.println(ca.getAnswer());
                   Date d=new Date();
                   pst.setString(4,"" +d);
                   pst.executeUpdate();
                 
               }
               catch(SQLException e1){
                   System.out.println(e1.getMessage());
               }
                 System.out.println("Qname is "+ca.getQname()+"Answer is"+ca.getAnswer());
               
               
             }
               try{
                   
                  myConnection obj = new myConnection();
                   String q="insert into tbresultmain(cid,Rollno,createDate,cans,inans,submitted)values(?,?,?,?,?,?)";
                   PreparedStatement pst=obj.db.prepareStatement(q);
                   
                   
                   pst.setString(1,CompanyId);
                   pst.setString(2,Rollno);
                   Date d1=new Date();
                   pst.setString(3, ""+d1);
                   pst.setInt(4, cans);
                   pst.setInt(5, inans);
                   pst.setInt(6, unatt);
                   
                   pst.executeUpdate();
                   
                 
             }
             catch(Exception e1){
                 System.out.println(e1.getMessage());
             }
             
          }
      });
     
     
     
 }
 catch(SQLException e){
     System.out.println(e.getMessage());
  
 }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
