/**
 * HotelReport class, when given a Hotel object, produces a short textual report on a Hotel object describing the hotel's name, the number of rooms, and, for each room, lists the number and size of the beds, and hotel vacancy status
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class HotelReport {

	public void createReport(Hotel h) { /*a method to create the textual report of the hotel*/		
		/*Printing the report*/
		System.out.println(h.getHotelName().toUpperCase()); //print out the hotel name fully in capital letters as title
		System.out.println("---------------------------------------");
		System.out.println(h.getHotelName()+" has "+h.getRoomAmount()+" room(s)"); //print out the number of rooms in the hotel
		h.displayRooms(); //method call to displayRooms method to print out each room's information
		System.out.println("Maximum occupancy is "+h.getMaxOccupancy()+" person(s)"); //print out the maximum occupancy of the hotel
		System.out.println(h.hasVacancies()); //print out hotel vacancy status
	}
}
