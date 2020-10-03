package fina;
import java.util.ArrayList;;
public class fin {
		
		public static void main(String[] args)
		{

			 FileIo reader = new FileIo();
			 String[] coordinates1 = reader.load("coordinate1.txt");
			 String[] coordinates2 = reader.load("coordinate2.txt");
//			 System.out.println(coordinates1[810]);
//			 System.out.println(coordinates2[810]);

			 double distance = 0.0;
			 double finalr = 10000;
			 double land1 = 0.0;
			 double land2 = 0.0;
			 int destination =0;
			 int count =0;
			 int counter =0;
			 ArrayList  strike1= new ArrayList();
			 ArrayList  strike2= new ArrayList();
			 ArrayList desto = new ArrayList();
			 desto.add(0);
				 for(int j=1;j<coordinates2.length;j++)
				 {
					 counter=j+1;
				//if array doesnt contain those coordinates proceed
				 double lona = Double.parseDouble(coordinates1[0]);
				 double lonb = Double.parseDouble(coordinates1[j]);
				 double lata = Double.parseDouble(coordinates2[0]);
				 double latb = Double.parseDouble(coordinates2[j]);
				 double lon1 = Math.toRadians(lona); 
			      double   lon2 = Math.toRadians(lonb); 
			        double lat1 = Math.toRadians(lata); 
			       double lat2 = Math.toRadians(latb); 
			  
			        // Haversine formula  
			        double dlon = lon2 - lon1;  
			        double dlat = lat2 - lat1; 
			        double a = Math.pow(Math.sin(dlat / 2), 2) 
			                 + Math.cos(lat1) * Math.cos(lat2) 
			                 * Math.pow(Math.sin(dlon / 2),2); 
			              
			        double c = 2 * Math.asin(Math.sqrt(a)); 
			 
			        // Radius of earth in kilometers. Use 3956  
			        // for miles 
			        double r = 6371; 
			  
			        // calculate the result 
			        double result =(c * r); 
			       //if result greater than 100
			        	//if result less than previous distance
			        	if(result<finalr && result>=100)
			        	{
			        		//gets the smallest result out of the loop
			        		finalr = result;
			        		land1 = lonb;
			        		land2 = latb;
			        		destination = counter;
			        	}
			    } 
				 count++;
				 desto.add(destination);
				 strike1.add(land1);
				 strike2.add(land2);
				 System.out.println(finalr);
				 distance +=finalr;
				  airporttravel(desto,count,land1,land2,strike1,strike2,distance,coordinates1,coordinates2);
			  
			} 
		
		static void airporttravel(ArrayList desto,int count,double land1,double land2,ArrayList strike1,ArrayList strike2,double distance,String[] coordinates1,String[] coordinates2)
		{
			double land1bc = 0.0;
			double land2bc = 0.0;
			double land2b = land2;
			double land1b =land1;
			int destination =0;
			for(int i=1;i<995;i++)
			{
				int counter =0;
				double finalr2 =20000;
			for(int j=0;j<coordinates2.length;j++)
			 {
			//if array doesnt contain those coordinates proceed
			 double lonb = Double.parseDouble(coordinates1[j]);
			 double latb = Double.parseDouble(coordinates2[j]);
			 counter =j+1;
			 if(!strike1.contains(lonb)&&!strike2.contains(latb))
				 {
				 double lon1 = Math.toRadians(land1b); 
			      double   lon2 = Math.toRadians(lonb); 
			        double lat1 = Math.toRadians(land2b); 
			       double lat2 = Math.toRadians(latb); 
			  
			        // Haversine formula  
			        double dlon2 = lon2 - lon1;  
			        double dlat2 = lat2 - lat1; 
			        double a = Math.pow(Math.sin(dlat2 / 2), 2) 
			                 + Math.cos(lat1) * Math.cos(lat2) 
			                 * Math.pow(Math.sin(dlon2 / 2),2); 
			              
			        double c2 = 2 * Math.asin(Math.sqrt(a)); 
			  
			        // Radius of earth in kilometers. Use 3956  
			        // for miles 
			        double r2 = 6371; 
			        // calculate the result 
			        double result =(c2 * r2); 
			       //if result greater than 100km
			       // System.out.println(result);
//			        	//if result less than previous distance
			        	if(result<finalr2 && result>=100)
			        	{
//			        		//gets the smallest result out of the loop
			        		finalr2 = result;
//			        		//System.out.println(finalr);
			        		land1bc = lonb;
			        		land2bc = latb;
			        		destination = counter;
			        	}
			 	}
		    } 
			land1b = land1bc;
			land2b =land2bc;
			desto.add(destination);
				if(!strike1.contains(land1bc))
				{
				strike1.add(land1bc);
				}
				if(!strike2.contains(land2bc))
				{
				strike2.add(land2bc);
				}
				System.out.println(finalr2);
			distance += finalr2;
			count++;
			}
			finalflights(desto,count,distance,land1bc,land2bc,strike1,strike2,coordinates1,coordinates2);
			
		}
		static void finalflights(ArrayList desto,int count,double distance,double land1bc,double land2bc,ArrayList strike1,ArrayList strike2,String[] coordinates1,String[] coordinates2)
		{
			double land1b = land1bc;
			double land2b = land2bc;
			int destination =0;
			strike1.add(35.6572957);
			strike2.add(139.5425587);
			for(int i=0;i<10;i++)
		    {
				int counter =0;
				double finalr2=1000;
				strike1.add(35.69715535);
				strike2.add(139.7625818);
				strike1.remove(36.6283706);
				strike2.remove(138.1873049);
				for(int j=0;j<coordinates2.length;j++)
						{
					counter =j+1;
				//if array doesnt contain those coordinates proceed
				 double lonb = Double.parseDouble(coordinates1[j]);
				 double latb = Double.parseDouble(coordinates2[j]);
			       if(!strike1.contains(lonb)&&!strike2.contains(latb))
					 {
				double lon1 = Math.toRadians(land1b); 
			      double   lon2 = Math.toRadians(lonb); 
			        double lat1 = Math.toRadians(land2b); 
			       double lat2 = Math.toRadians(latb);
			     
			    // Haversine formula  
			        double dlon2 = lon2 - lon1;  
			        double dlat2 = lat2 - lat1; 
			        double a = Math.pow(Math.sin(dlat2 / 2), 2) 
			                 + Math.cos(lat1) * Math.cos(lat2) 
			                 * Math.pow(Math.sin(dlon2 / 2),2); 
			              
			        double c2 = 2 * Math.asin(Math.sqrt(a)); 
			  
			        // Radius of earth in kilometers. Use 3956  
			        // for miles 
			        double r2 = 6371; 
			        // calculate the result 
			        double result =(c2 * r2);
			       
			        	if(result<finalr2 && result>=100)
		        		{
	//	        		//gets the smallest result out of the loop
		        		finalr2 = result;
		        		
		        		land1bc = lonb;
		        		land2bc = latb;
		        		 destination = counter;
		        		}
					 }
					}
				land1b = land1bc;
				land2b =land2bc;
				desto.add(destination);
					if(!strike1.contains(land1bc))
					{
					strike1.add(land1bc);
					}
					if(!strike2.contains(land2bc))
					{
					strike2.add(land2bc);
					}
					//System.out.println(finalr2);
		   	distance += finalr2;
		   	count++;
		       }
		        finaldestination(desto,count,distance,land1bc,land2bc);
		}
		static void finaldestination(ArrayList desto,int count,double distance,double land1bc, double land2bc)
		{
			double lon1 = Math.toRadians(land1bc); 
		      double   lon2 = Math.toRadians(53.3813); 
		        double lat1 = Math.toRadians(land2bc); 
		       double lat2 = Math.toRadians(6.5918); 
		       
		    // Haversine formula  
		        double dlon2 = lon2 - lon1;  
		        double dlat2 = lat2 - lat1; 
		        double a = Math.pow(Math.sin(dlat2 / 2), 2) 
		                 + Math.cos(lat1) * Math.cos(lat2) 
		                 * Math.pow(Math.sin(dlon2 / 2),2); 
		              
		        double c2 = 2 * Math.asin(Math.sqrt(a)); 
		  
		        // Radius of earth in kilometers. Use 3956  
		        // for miles 
		        double r2 = 6371; 
		        // calculate the result 
		        double result =(c2 * r2); 
		        distance += result;
		        count++;
		        desto.add(0);
		        timetaken(desto,count,distance);
		       // System.out.println(result);
		}
		
		static void timetaken(ArrayList desto,int count,double distance)
		{
			double refuelhrs = 1005*30/60;
			//System.out.println(refuelhrs);
			distance =Math.round(distance);
			//System.out.println(distance);
			double flighthrs = Math.round(distance/800);
			System.out.println(flighthrs);
			double fulltime = Math.round(refuelhrs+flighthrs);
			System.out.println("Time taken to travel around the world "+fulltime+" hrs");
			//System.out.println(count);
			System.out.println(desto);
			System.out.println(desto.size());
			Object[] array = desto.toArray(new Integer[0]);
			for(int i=0;i<array.length;i++)
			{
				System.out.print(array[i]+",");
			}
			System.out.println("HI");
			int counte=0;
			if(desto.contains(576))
			{
				counte++;
			}
			System.out.println(counte);
		}
}
