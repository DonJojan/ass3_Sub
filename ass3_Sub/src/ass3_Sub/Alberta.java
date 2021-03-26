package ass3_Sub;
public class Alberta implements Item {
	 private int item_id;
	 private String item_name ;
	 private int quantity;
	 private double Unit_Price ;
	 public Alberta(int item_no , String name, int quantity_no, double price)
	 {
		 item_id = item_no;                  // Initiating attributes in ALberta Class
		 item_name = name;
		 quantity = quantity_no;
		 Unit_Price = price;
		 
	 }
	 public int Get_Item_Id(){                  // getter method to return item_id
	        return item_id;
	    }
	    
	    public String Get_Item_Name(){          // getter method to get item name
	        return item_name;
	    }
	    
	    public double Get_Unit_Price(){         // getter method to get unit price
	        return Unit_Price;
	    }
	    public double Get_Total_Price(){        // method to compute total price
	    	double Total_price=0;
	    	Total_price = (Get_Unit_Price()*quantity)+(Get_Unit_Price()*quantity*0.07);
	        return Total_price;
	    }
	    public String to_String()                 // method to display output 
	    {
	    	String s1="";
	    	System.out.println("\n"+Get_Item_Name()+" with unit price: "+Get_Unit_Price()+" and quantity: "+quantity+" with GST costed :"+Get_Total_Price());
	    	s1 = String.valueOf(Get_Total_Price());
	    	return s1;
	    	
	    }

}
