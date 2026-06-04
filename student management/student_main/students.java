package student_main;
import java.sql.*;
import java.util.*;
public class students{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        deletestudent();
       displayStudents();
    }
    public static void displayStudents() throws Exception{
       String url = "jdbc:mysql://localhost:3306/students";
       String username = "root";
       String pass = "root123";
       System.out.println("------STUDENT DETAILS------");
       String query = "select * from students";
         Connection con = DriverManager.getConnection(url,username,pass);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
        while(rs.next()){
           System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("Name") + " | " +
                rs.getString("Department") + " | " +
                rs.getInt("marks")
            );
            System.out.println("-----------------------------");
        }
        st.close();
        rs.close();
        con.close();
    }
    public static void insertstudent() throws Exception{
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root123";
        System.out.println("------INSERT STUDENTS------");
        System.out.println("---enter the student details---");
        System.out.print("enter student id number : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter student name : ");
        String name = sc.nextLine();
        System.out.print("enter student department : ");
        String dept = sc.nextLine();
        System.out.print("enter student marks : ");
        int marks = sc.nextInt();
        String query = "insert into students values (?,?,?,?)";
          Connection con = DriverManager.getConnection(url, username,password);
          PreparedStatement pst =  con.prepareStatement(query);
          pst.setInt(1, id);
          pst.setString(2,name);
          pst.setString(3,dept);
          pst.setInt(4,marks);
          int rows = pst.executeUpdate();
          if(rows > 0){
            System.out.println("---successfully inserted---");
          }
          else{
            System.out.println("---insert failed---");
          }
          pst.close();
          con.close();
    }
    public static void deletestudent() throws Exception{
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root123";
        System.out.println("------DELETE STUDENT------");
        System.out.print("enter student id : ");
        int id = sc.nextInt();
        String query = "delete from students where id = ?";
          Connection con = DriverManager.getConnection(url, username,password);
          PreparedStatement pst =  con.prepareStatement(query);
          pst.setInt(1, id);
          int rows = pst.executeUpdate();
          if(rows > 0){
            System.out.println("---successfully deleted---");
          }
          else{
            System.out.println("---student not found---");
          }
          pst.close();
          con.close();
    }
     public static void updatestudent() throws Exception{
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root123";
        System.out.println("------UPDATE STUDENTS------");
        System.out.print("enter student id : ");
        int id = sc.nextInt();
        System.out.print("enter student marks : ");
        int marks = sc.nextInt();
        String query = "update students set marks = ? where id = ?";
          Connection con = DriverManager.getConnection(url, username,password);
          PreparedStatement pst =  con.prepareStatement(query);
          pst.setInt(1,marks);
          pst.setInt(2, id);
          int rows = pst.executeUpdate();
          if(rows > 0){
            System.out.println("---successfully updated---");
          }
          else{
            System.out.println("---could not update---");
          }
          pst.close();
          con.close();
    }
     public static void searchstudent() throws Exception{
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "root123";
        System.out.println("------SEARCH STUDENTS------");
        System.out.print("enter student id : ");
        int id = sc.nextInt();
        String query = "select * from students where id = ?";
          Connection con = DriverManager.getConnection(url, username,password);
          PreparedStatement pst =  con.prepareStatement(query);
          pst.setInt(1,id);
          ResultSet rs = pst.executeQuery();
          if(rs.next()){
          System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getInt(4));
          System.out.println("---student found---");
          }
          else{
            System.out.println("student not found");
          }
          pst.close();
          rs.close();
          con.close();
    }
}