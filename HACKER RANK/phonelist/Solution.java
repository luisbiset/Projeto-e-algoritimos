package aleatorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
	 
	 
	public static void main(String[] args) {
		 
		 Scanner in = new Scanner(System.in);
		 
		 
		 Map<String, String> telList = new HashMap<String, String>();
		 
		 int addnums = Integer.parseInt(in.nextLine());
		 
		 for(int i =0; i<addnums;i++) {
			 String name = in.nextLine();
			 String phone = in.nextLine();
			 telList.put(name, phone);
		 }
		 
		 
		 
		 
		 while(in.hasNext()) {
			 
			 	String namef = in.nextLine();		
			 
			 if(telList.containsKey(namef) == true) {
				System.out.println(namef+"="+telList.get(namef)); 
			 } else
				 System.out.println("Not Found");
			 
		 }
	}
		 
}		 
			 
		 
		 
		 
		 
		 
		
		 
		 
		 
		 
		 


			
		 
	
	


			 
			 
		 
		
		
		
	
			
			 
		
		
		 

		 
	 
	  
	  
		 
	 		
	
		 
		 
	 
	 
	 

	
	
	

	 


		
		
		
    
		
		
		
		
		
			
			
		
		
		
		
		
		
		
		
				


