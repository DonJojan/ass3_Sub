package ass3_Sub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Item_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double total =0;
		int no,count=0;
		String s="";
		double p;
		int ont = 2;
		 String name1="";
	
			System.out.println("Enter 1 to insert --- 2 to generate bill for Ontario ---- 3 to generate bill for Alberta Store:");
			Scanner sc=new Scanner(System.in);
			
			int choice=sc.nextInt();  // getting choice input from the user
			if (choice ==1 )
			{

				Connection con=null;
				Statement stmt=null;
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");     // creating connection with the database
					
					String db="C:\\Users\\donjo\\eclipse-workspace\\Assignment3\\Database2.accdb";
			
					String myPath="jdbc:ucanaccess://"+db;
					
					
					con=DriverManager.getConnection(myPath);
					stmt=con.createStatement();
					
					System.out.println("\nEnter information about the new item");
					Scanner sc5=new Scanner(System.in);
	
							Scanner sc1=new Scanner(System.in);
					System.out.println("Enter item name:");
					String name=sc1.nextLine();
					
		
					Scanner sc2=new Scanner(System.in);
					System.out.println("Enter item unit price:");
					double percentage=sc2.nextDouble();
					
					//Inserting values into table
					String query="INSERT INTO Item(ItemName, UnitPrice) VALUES('"+name+"',"+percentage+")";
					
					stmt.executeUpdate(query);
					
					
				} 
				catch (ClassNotFoundException e) {
					System.out.print("Problem in loading Driver");
					e.printStackTrace();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					
					try {
						con.close();                 // closing connection with the database
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				


			}
			
			
			
			else {
				if(choice ==2)
				{
					 ont = 1;
				}
				else if (choice == 3)
				{
					ont = 0;
				}
				else {
					System.out.println("Invalid entry");    // displaying required output if user enters invalid input
				}
				if (ont == 1)
				{
			
			
				System.out.println("How many items are there in bill for Ontario:");
				count=sc.nextInt();
				}
				else if (ont ==0){
					System.out.println("How many items are there in bill for Alberta:");
					 count=sc.nextInt();
				}
				
				double[] arr =  new double[count];       // creating array to store price of items
				Item[] o = new Ontario[count];           // creating object for Ontario Class 
				Item[] a = new Alberta[count];           // creating object for Alberta Class

				
				for(int k=0;k< count; k++)
				{

					Connection con=null;
					Statement stmt=null;
					ResultSet rs=null;
						
					try {
						
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");     // creating connection with the database
						
						String db="C:\\Users\\donjo\\eclipse-workspace\\Assignment3\\Database2.accdb";
					
						String dbPath="jdbc:ucanaccess://"+db;
						
						con=DriverManager.getConnection(dbPath);
						
						
						stmt=con.createStatement();
						
						
						System.out.println("\nEnter the name of the item:");  // getting new item name from the user
						Scanner sc6=new Scanner(System.in);
						
						String name=sc6.nextLine();
						System.out.println("Enter quantity of items:");      // getting number of items from the user
						
						 no=sc.nextInt();
						
						String query="SELECT * FROM Item WHERE ItemName='"+name+"'";   // getting details from the database from the given itemname
						rs=stmt.executeQuery(query);
						
						boolean isNotThere=true;                   // flagging a variable to determine if the entered item is found in database
						
						while(rs.next()) {
							isNotThere=false;
					
							String name2=rs.getString(1);
						
							double price=rs.getDouble(2);
							
				
							
							if (ont == 1)
							{
							o[k] = new Ontario(1,name2,no,price);       // initiating Ontario class if user selects to generate bill for ontario
							
							 s = o[k].to_String();                   // calling to_String method in Ontario class
							}
							else if (ont == 0)
							{
								a[k] = new Alberta(1,name2,no,price);   // initiating Alberta class if user selects to generate bill for alberta
								
								 s = a[k].to_String();               // calling to_String method in Alberta class
							}
							double inum = Double.parseDouble(s);
							arr[k] = inum;
							total = arr[k]+total;
							
						}
						if(isNotThere)
							System.out.print("No Record Found for "+name);
						
				} catch (ClassNotFoundException e) {
						System.out.println("Problem loading the driver");    // displaying message incase of any exception
						e.printStackTrace();
					}	
					
					catch (SQLException e) {
						e.printStackTrace();
					}
					finally
					{
						
							try {
								rs.close();                  // closing connection with the database
								stmt.close();
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
						
					}

				}
				if(ont ==0 || ont ==1)
				{
				System.out.println("\nTotal price is :$" + total);           // displaying Total price
				}
				
		}
	}

}
