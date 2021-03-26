package ass3_Sub;
public interface Item {
	 int item_id=0;
	 String item_name ="";
	 int quantity = 0;
	 double Unit_Price =0;
	 


	
	public abstract int Get_Item_Id();       // definning abstract class for Getting item id
	public abstract String Get_Item_Name();       // defining abstract class for getting item name
	public abstract double Get_Unit_Price();               // defining abstract class to get unit price
	public abstract double Get_Total_Price();             // defining abstract class to get total price
	public abstract String to_String();                    // defining abstract class to display output
	

}
