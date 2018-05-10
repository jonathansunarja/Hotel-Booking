/**
 * HotelTest class creates a hotel and asks for its report to be shown
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class HotelTest {
	
	public static void main (String[] args) {
		/*Use a Hotel object to create a hotel that will be given its report*/
		Hotel test = new Hotel();
		test.setHotelName("Budget Hotel"); //set the hotel name
		test.createRooms(); //create the rooms in the hotel
		
		/*Use a HotelReport object to create a hotel report*/
		HotelReport hr = new HotelReport();
		hr.createReport(test); //create a report of the hotel
	}
}
