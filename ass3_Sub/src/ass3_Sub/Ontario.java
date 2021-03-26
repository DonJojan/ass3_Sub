package ass3_Sub;
public class Ontario implements Item {
	 private int item_id;
	 private String item_name ;
	 private int quantity;
	 private double Unit_Price ;

	 public Ontario(int item_no , String name, int quantity_no, double price)  
	 {
		 item_id = item_no;                                  // initiating values to Ontario attributes
		 item_name = name;
		 quantity = quantity_no;
		 Unit_Price = price;
		 
	 }
	    public int Get_Item_Id(){                 // getter function to return item_id
	        return item_id;
	    }
	    
	    public String Get_Item_Name(){           // getter function to return Item Name
	        return item_name;
	    }
	    
	    public double Get_Unit_Price(){
	        return Unit_Price;
	    }
	    
	    public double Get_Total_Price(){   // computing Total price of the product
	    	double Total_price=0;
	    	Total_price = (Get_Unit_Price()*quantity)+(Get_Unit_Price()*quantity*0.07)+(Get_Unit_Price()*quantity*0.08);
	        return Total_price;
	    }
	    
	    public String to_String()            // displaying output in string format
	    {
	    	String s1="";
	    	System.out.println("\n"+Get_Item_Name()+" with unit price: "+Get_Unit_Price()+" and quantity:"+quantity+"  with GST and PST costed: "+Get_Total_Price());
	    	s1 = String.valueOf(Get_Total_Price());
	    	return s1;
	    	
	    }
}
