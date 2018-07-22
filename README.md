# PlacementCell
Admin Login: We have to enter username and password of the current session.
Admin has the authority to change password, add new student , add new company,edit student,edit company,view eligible students.
Add a Student:We require rollno,firstName,LastName,Email,Contact,Address,FatherName,Marks etc.
Add Company:Information like id,CompanyName,Director,Email,Contact,Location,Profile,TenthMarks Required,TwelthVMarks Required,Graduation Cgpa,ComputerTest,Password,AboutCompany is required.
Company Login: We have to enter the username and password .
Company could Change Password,Edit Profile,View Eligible Students,Upload Questions,Update Questions,View Test Result
Student Login:
Student can change Password,View Eligible Company,Test for Company,Result of Test.

In Java i have used:
OOPs Concept
JDBC Concepts 
Servelets

Jdbc Drivers: Software Components enables java application and interact with database.
Steps To Connect To Database:
Registering Driver Class
Creating Connection
Creating Statement
Executing Queries
Closing Connection.

public class myConnection{
Connection db;
myConnection(){
try{
Class.forName("com.mysql.jdbcDriver");
db=DriverManager.getConnection("jdbc:mysql://localHost/dbplacement","root","");
}
catch(Exception e){
System.out.println(e.getMessage)
}
}
}

