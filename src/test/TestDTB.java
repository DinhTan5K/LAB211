package test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class TestDTB {
    private SQLServerDataSource ds ;

    public TestDTB() {
        ds = new SQLServerDataSource();
        ds.setTrustServerCertificate(true);
        ds.setUser("sa");
        ds.setPassword("1234");
        ds.setServerName("LAPTOP-6BUQRB4T");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Worker");
    }


    static class Student{
        String id;
        String name;
        int age;

        public Student( String id, String name, int age) {
            this.age = age;
            this.id = id;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    boolean checkDupli(String id){
            String query = "select count(*) from student where id = ? ";
            try(Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
            ){
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }


            }catch(SQLException e){
                e.printStackTrace();
            }
        return false;
    }

      void  addVaLtoDbi(Student student){
          String query = "insert into student(id, name, age) values(?,?,?)";
          try(Connection conn = ds.getConnection();
              PreparedStatement ps = conn.prepareStatement(query);){
              ps.setString(1,student.getId());
              ps.setString(2,student.getName());
              ps.setInt(3,student.getAge());
          }catch (SQLException e){
              e.printStackTrace();
          }
    }

    public static void main(String[] args) {

    }
}
