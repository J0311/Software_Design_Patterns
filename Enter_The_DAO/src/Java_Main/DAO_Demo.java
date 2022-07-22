// In computer software, a data access object (DAO) is an object that provides 
/* an abstract interface to some type of database or other persistence mechanism. 

	In this example, we create a method and we create an insert method on that method.
	When you perform an insert query in JDBC, do not use "Statement" interface. Here, we 
	utilize the PreparedStatement interface instead. We create a method for connection. 
	When you create an insert query, it's necessary to create an execute query. */

// SUCCESSFULLY CREATED DB TABLE "student" 

package Java_Main;

import java.sql.SQLException;

public class DAO_Demo {

	public static void main(String[] args) throws SQLException {
		
		/**  Instantiating our "dao" object for the student class.
		 The Student data access object calls the ".getStudent()" 
		 method, passing 12, which we pass in our query statement
		 to grab the corresponding information from our database, "student". */

		StudentDAO dao = new StudentDAO();
		
		// casting Java_Main
		
		Student s1 = (Java_Main.Student) dao.getStudent(12);
		
		// Successfully extracts our student object and returns it's name from table.

		System.out.println(s1.sname);

	}
	
	
	}
	


