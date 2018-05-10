import java.util.ArrayList;
import java.util.List;
/**
 * Room class stores the number of beds in a room and the maximum number of person occupying it
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class Room {
	
	private List<String> bedSize = new ArrayList<String>(); //a list to store all the bed sizes in a room
	private int bedAmount; //a variable to store the number of beds in a room
	private int personAmount; //a variable to store the maximum number of person in a room
	private int randomBedAmount; //a variable to store randomised number of beds in a room
	private final int MAX_BED_AMOUNT = 2; //a constant to store maximum number of beds in a room
	private int randomVacancy; //a variable to store randomised number indicating room vacancy
	private String vacancy; //a variable to store room vacancy status
	
	public void putBeds(){ /*a method to put a number of beds into a room*/
		randomiseBedAmount(); //method call to randomiseBedAmount method
		for(int i=0; i<randomBedAmount; i++){ //for loop to keep on creating beds
			
			/*Use a Bed object to create bed*/
			Bed b = new Bed();
			b.randomiseBedSize(); //randomise the size of bed
			
			/*if randomSize in Bed class is equal to 1, it refers to a single bed*/ 
			if (b.randomiseBedSize() == 1){
				b.setBedSize("Single bed"); //set the bed size as "single"
			}
			/*if randomSize in Bed class is equal to 2, it refers to a double bed*/
			else{
				b.setBedSize("Double bed"); //set the bed size as "double"
			}
			
			bedSize.add(b.getBedSize()); //add the size of bed created into the list of beds
			bedAmount = bedSize.size(); //put the size of list of beds as the number of beds in a room
			personAmount = personAmount + b.getPerson(); //calculate the maximum number of person in a room, by taking the number of person in each bed and add them
		}
	}
	
	public List<String> displayBeds(){ /*a method to display the list of beds in a room*/
		return bedSize;
	}
	
	public int getBedAmount(){ /*a method to get the number of beds in a room*/
		return bedAmount;
	}
	
	public void setBedAmount(int bedAmount){ /*a method to set the number of beds in a room*/
		this.bedAmount = bedAmount;
	}
	
	public int getPersonAmount(){ /*a method to get the maximum number of person in a room*/
		return personAmount;
	}
	
	public int randomiseBedAmount(){ /*a method to randomise integer from 1 to 3 to represent number of beds in a room*/
		randomBedAmount = (int)(Math.random() * MAX_BED_AMOUNT + 1); //operation to randomise the integers
		return randomBedAmount;
	}
	
	public int randomiseVacancy(){ /*a method to randomise integer from 0 to 1 to represent room vacancy status*/
		randomVacancy = (int)(Math.random() * 2 + 0); //operation to randomise the integers
		return randomVacancy;
	}
	public String getVacancy(){ /*a method to get each room vacancy status*/
		randomiseVacancy(); //method call to randomiseVacancy method
		/*if randomVacancy value is 0, it means the room is still vacant*/
		if (randomVacancy == 0){
			vacancy = "vacant";
		}
		/*if randomVacancy value is 1, it means the room is occupied*/
		else{
			vacancy = "occupied";
		}
		return vacancy;
	}
	
}
