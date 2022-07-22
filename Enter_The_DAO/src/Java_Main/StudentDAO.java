package Java_Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO {
	 

	// will RETURN a student object. Passes integer rollno variable
	// we don't want to return a "blank" student object
	// we want a Student with a roll # and NAME

	public Student getStudent(int rollno) {

		// Although we're passing roll #, we must get student database

		Student s = new Student();
		s.rollno = rollno;

		try {	// load driver, create Conn obj.
			Class.forName("org.postgresql.Driver");
			Connection c;
            c = DriverManager
                    .getConnection("jdbc:postgresql://javadb-0.cpz1wwb1y5uo.us-east-1.rds.amazonaws.com:5432/postgres",
                            "J0311", "BestPasswordEver");
            
            // declaring & initialing our String query
            
            String sql = "select sname from student where rollno = " + rollno;
            
            
            // Preparing our query
            
            PreparedStatement ps = c.prepareStatement(sql);
            
            // saving execution of  prepared statement query in result set object:
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            // We pass int 1, because the column we're fetching only one column
            
            String name = rs.getString(1);
            s.sname = name;
            
		} catch (ClassNotFoundException sqe) {
			
			// printing stack trace in event of an exception

			sqe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s; // should return "sname"
	}
}
