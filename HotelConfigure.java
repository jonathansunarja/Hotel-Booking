import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * HotelConfigure class provides a simple user interface, allowing user to choose a number of rooms, and for each room choose the number and size of beds
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class HotelConfigure {

	private String customHotelName; //a variable to store hotel's name
	private int customRoomAmount; //a variable to store the amount of rooms in hotel
	private int customBedAmount; //a variable to store the amount of beds in a room
	private String customBedSize; //a variable to store the size of a bed, i.e. single or double
	private String roomName; //a variable to store the room name, e.g. Room 1, Room 2
	private int person; //a variable to store the number of person on a bed
	private int maxPerson; //a variable to store the maximum occupancy in the hotel
	private List<String> totalRooms = new ArrayList<String>(); //a list to store the rooms in the hotel
	private List<String> totalBeds = new ArrayList<String>(); //a list to store the beds in each room
	private List<Integer> bedTotal = new ArrayList<Integer>(); //a list to store the number of beds in each room
	private String customVacancy; //a variable to store the vacancy status of each room
	private List<String> totalVacancies = new ArrayList<String>(); //a list to store the vacancy status of all rooms
	private String hotelVacancy; //a list to store the vacancy status of the hotel
	
	public void userInput(){ /*a method for the user interface, user input, and implementing them on the hotel*/
		/*User interface to set the hotel name*/
		System.out.println("Build your own hotel!");
		System.out.print("Enter hotel name: ");
		Scanner s1 = new Scanner (System.in);
		
		/*Use a Hotel object to create the given hotel*/
		Hotel a = new Hotel();
		a.setHotelName(s1.nextLine()); //set a String user input as the hotel name
		customHotelName = a.getHotelName(); //storing the name to a variable
		
		/*User interface to set the number of rooms in the hotel*/
		System.out.print("Number of rooms (enter an integer): ");
		Scanner s2 = new Scanner (System.in);
		customRoomAmount = s2.nextInt(); //set an integer value as the number of rooms
		
		/*Creating the rooms*/
		for (int i=0; i<customRoomAmount; i++){ //for loop to keep on creating rooms
			roomName = "Room "+(i+1); //storing the room name to a variable
			System.out.println(roomName); //print the room name
			
			/*User interface to set the room vacancy status*/
			System.out.print("Is the room vacant or occupied? ");
			Scanner s3 = new Scanner (System.in);
			customVacancy = s3.next(); //set a String value as the vacancy status
			
			/*User interface to set the number of beds in a room*/
			System.out.print("Number of beds: ");
			Scanner s4 = new Scanner (System.in);
			customBedAmount = s4.nextInt(); //set an integer value as the number of beds
			
			/*Creating the beds*/
			for (int n=0; n<customBedAmount; n++){ //for loop to keep on creating beds
				
				/*User interface to set the bed size*/
				System.out.print("Bed "+(n+1)+" (single/double): ");
				Scanner s5 = new Scanner (System.in);
				customBedSize = s5.next(); //set a String value as the bed size
				
				/*if user type "single", the bed stores 1 person
				 * if user type "double, the bed stores 2 person
				 */
				if (customBedSize.equalsIgnoreCase("single")){
					person = 1;
				}
				else if (customBedSize.equalsIgnoreCase("double")){
					person = 2;
				}
				maxPerson = maxPerson+person; //calculate the maximum number of person in a room, by taking the number of person in each bed and add them
				totalBeds.add(customBedSize); //listing the bed sizes
			}
			bedTotal.add(customBedAmount); //listing the number of beds in each room
			totalRooms.add(totalBeds.toString()); //listing all beds in a room
			totalVacancies.add(customVacancy); //listing vacancy status of all rooms
			
			totalBeds.removeAll(totalBeds); //remove the bed sizes from former room as we need the list to store the bed sizes from the next room
		}
	}
	
	public String hasVacancies(){ /*a method to get the vacancy of the hotel*/
		for (String s: totalVacancies){ //for loop to continuously look for values in the list of room vacancies
			/*if there is any vacant room, hotel vacancy is reported as vacant*/
			if (s.equalsIgnoreCase("vacant")){
				hotelVacancy = "This hotel has a vacancy";
				return hotelVacancy;
			}
		}
		/*if there is no vacant room, hotel vacancy is reported as "no vacancy"*/
		hotelVacancy = "There is no vacancy in this hotel";
		return hotelVacancy;
	}
	
	public void displayInfo(){ /*a method to display all information about the created hotel to user*/
		System.out.println("------------------------------");
		System.out.println(customHotelName.toUpperCase()); //print out the hotel name fully in capital letters as title
		System.out.println("------------------------------");
		System.out.println("There are "+customRoomAmount+" room(s) in "+customHotelName); //print out the number of rooms in the hotel
		for (int s=0; s<customRoomAmount; s++){ //for loop to keep on looking for the next room
			System.out.println("Room "+(s+1)+" ("+totalVacancies.get(s)+") contains "+bedTotal.get(s)+" bed(s): "+totalRooms.get(s)); //print out each room's information
		}
		System.out.println("Maximum occupancy is "+maxPerson+" person(s)"); //print out the maximum occupancy of the hotel
		System.out.println(hasVacancies()); //method call to hasVacancies method
	}
	
	public static void main (String[] args){
		/*Create a HotelConfigure object*/
		HotelConfigure hc = new HotelConfigure();
		hc.userInput(); //prints user interface and takes user input
		hc.displayInfo(); //display the information of the created hotel
	}
}
