import java.util.ArrayList;
import java.util.List;
/**
 * Hotel class stores the hotel name, number of rooms, the rooms and their vacancies, number of beds in each room and the beds, maximum occupancy of the hotel, and hotel's vacancy
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class Hotel {
	
	private String name; //a variable to store the hotel name
	private int roomAmount; //a variable to store the number of rooms in the hotel
	private List<Room> rooms = new ArrayList<Room>(); //a list to store all the rooms in the hotel
	private List<Integer> bedTotal = new ArrayList<Integer>(); //a list to store the number of beds in each room
	private List<List> bedSizes = new ArrayList<List>(); //a list to store the list of bed sizes in each room
	private List<String> roomVacancies = new ArrayList<String>(); //a list to store the vacancy status of each room
	private int maxOccupancy; //a variable to store the maximum occupancy of the hotel
	private int randomRoomAmount; //a variable to store randomised number of rooms in a hotel
	private int MAX_ROOM_AMOUNT = 30; //a constant to store the maximum number of rooms in a hotel
	private String hotelVacancy; //a variable to store hotel vacancy status
		
	public void createRooms(){ /*a method to create a number of rooms in a hotel*/
		randomiseRoomAmount(); //method call to randomiseRoomAmount method
		for (int i=0; i<randomRoomAmount; i++){ //for loop to keep on creating rooms
			
			/*Use a Room object to create room*/
			Room r = new Room();
			r.putBeds(); //put beds in the room
			bedSizes.add(r.displayBeds()); //put the displayed list of beds into a list
			rooms.add(r); //add the room created into the list of rooms
			roomAmount = rooms.size(); //put the size of lists of rooms as the number of rooms in the hotel
			maxOccupancy = maxOccupancy + r.getPersonAmount(); //calculate the maximum number of person in the hotel, by taking the number of person in each room and add them
			bedTotal.add(r.getBedAmount()); //add the number of beds in each room into a list
			roomVacancies.add(r.getVacancy()); //add the room vacancy status to a list of room vacancy status
		}
	}
	
	public int randomiseRoomAmount(){ /*a method to randomise integer from 1 to 20 to represent number of rooms in a hotel*/
		randomRoomAmount = (int)(Math.random() * MAX_ROOM_AMOUNT + 1); //operation to randomise the integers
		return randomRoomAmount;
	}
	
	public void displayRooms(){ /*a method to display each room's information*/
		for (int i=0; i<roomAmount; i++){ //for loop to keep on looking for the next room
			System.out.format("Room "+(i+1)+" ("+roomVacancies.get(i)+") contains "+bedTotal.get(i)+" bed(s): "+bedSizes.get(i)+"\n"); //formatted print for each room's information
		}
	}
	
	public String getHotelName(){ /*a method to get the hotel's name*/
		return name;
	}
	
	public void setHotelName(String name){ /*a method to set the hotel's name*/
		this.name = name;
	}
	
	public int getRoomAmount(){ /*a method to get the number of rooms in the hotel*/
		return roomAmount;
	}
	
	public void setRoomAmount(int roomAmount){ /*a method to set the number of rooms in the hotel*/
		this.roomAmount = roomAmount;
	}
	
	public int getMaxOccupancy(){ /*a method to get the maximum occupancy of the hotel*/
		return maxOccupancy;
	}
	
	public String hasVacancies(){ /*a method to get the vacancy of the hotel*/
		for (String s : roomVacancies){ //for loop to continuously look for values in the list of room vacancies
			/*if there is any vacant room, hotel vacancy is reported as vacant*/
			if (s.equals("vacant")){
				hotelVacancy = "This hotel has a vacancy";
				return hotelVacancy;
			}
		}
		/*if there is no vacant room, hotel vacancy is reported as "no vacancy"*/
		hotelVacancy = "There is no vacancy in this hotel";
		return hotelVacancy;
	}
}
