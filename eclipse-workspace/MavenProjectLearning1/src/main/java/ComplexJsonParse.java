import io.restassured.path.json.JsonPath;
import files.Payload;

public class ComplexJsonParse {

	public static void main (String[] args) {
	
	JsonPath js= new JsonPath(Payload.Courseprice());
	
	//print no of courses returned by API
	int count= js.getInt("courses.size()");
	System.out.println("size of the array:" + count);
	
	//print purchase amount returned by API
	
	int totalAmount= js.getInt("dashboard.purchaseAmount");
	System.out.println("purchaseamount :=" + totalAmount );
	
	//print title of the first course
	
	String firstTitle= js.getString("courses[0].title");
	System.out.println("firstTitle :=" + firstTitle );
	
	//print all title of the course
	
		String allTitle= js.getString("courses.title");
		System.out.println("allTitle :=" + allTitle );
	
	//print second title of the first course
		
		String secondTitle= js.getString("courses[2].title");
		System.out.println("secondTitle :=" + secondTitle );
	
		//print all courses title and respective prices
		
				for (int i=0; i<=count; i++)
				{
					String courseTitles= js.getString("courses["+i+"].title");
					//System.out.println(js.get("courses["+i+"].price").toString());
					System.out.println(courseTitles);
					
					Integer prices=js.get("courses["+i+"].price");
					if (prices != null) {
					    System.out.println("Price is: " + prices);
					} else {
					    System.out.println("Price is missing or null.");
					}
				//	break;
				
					//System.out.println(prices);
				}
				
				
				//print no of copies sold by RPA title
				
				System.out.println("print no of copies sold by RPA title");
				
				for (int i=0; i<=count; i++)
				{
					String courseTitles= js.getString("courses["+i+"].title");
					if (courseTitles.equalsIgnoreCase("RPA"))
					{
						//copies sold
						int copies= js.get("courses["+i+"].copies");
						
						System.out.println("copies"+ copies);
						break;
					}
	

	//verify if sum of all course prices matches with purchase amount
					
					//System.out.println("verify if sum of all course prices matches with purchase amount");
					
					//for (int j=0; j<=count; j++)
					//{
						
						int purchaseAmount = js.getInt("dashboard.purchaseAmount");
						System.out.println("purchase amount is: "+ purchaseAmount );
						
						int totalSum=0;
						for (int j=0; j<count; j++)
						{
			
						int price= js.getInt("courses["+j+"].price");
					
						int copies= js.getInt("courses["+j+"].copies");
						int totalsumofprice= price*copies;
						
						totalSum+= totalsumofprice;
						}
						System.out.println("total sum of all prices: "+ totalSum );
						if (totalSum==purchaseAmount)
						{
							//copies sold
							//int copies= js.get("courses["+i+"].copies");
							
							System.out.println("sum is getting match with purchaseAmount");
						}
						else
						{
							System.out.println("sum is not getting match with purchaseAmount");	
						}
							
							break;
					
					}
				}

	}