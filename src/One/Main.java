package One;
import java.sql.*;
import java.util.*;
public class Main {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		int choice=1;
		String name;
		int age;
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:5432/data","root","mshllh6868");
		Statement st=con.createStatement();
		while(choice!=3) {
			System.out.print("1)Insert \n2)Display\n3)Exit\n");
			System.out.print("Enter The Choice:");
			choice=sc.nextInt();
			if(choice==1) {
				System.out.print("Enter a name:");
				name=sc.next();
				System.out.print("Enter a age:");
				age=sc.nextInt();
				st.executeUpdate("insert into user values('"+name+"',"+age+")");
				System.out.print("Added\n");
			}
			else if(choice==2) {
				ResultSet rs=st.executeQuery("select * from user;");
				System.out.println("Name    Age");
				while(rs.next()) {
					
					System.out.print(rs.getString(1)+"  "+rs.getInt(2));
					System.out.println();
				}
			}
		}
		con.close();
		System.out.print("Connection Closed");
	}

}
