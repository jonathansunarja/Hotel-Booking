import java.util.Random; //to randomly get an integer
/**
 * Bed class stores the size of a bed and the maximum number of person it can hold
 * 
 * @author Jonathan Valentinus Sunarja
 *
 */
public class Bed {
	
	private String size; //a variable to store the bed size as either "single" or "double"
	private int person; //a variable to store the maximum number of person on a bed
	private int randomSize; //a variable to store random integer from 1 to 2
	private final int BED_SIZE_AMOUNT = 2; //a constant to store the number of different types of bed
	
	public int randomiseBedSize(){ /*a method to randomise integer from 1 to 2 to represent "single" or "double" bed sizes*/
		randomSize = (int)(Math.random() * BED_SIZE_AMOUNT + 1); //operation to randomise the integers
		return randomSize;
	}
	
	public String getBedSize(){ /*a method to get bed size*/
		return size;
	}
	
	public void setBedSize(String size){ /*a method to set bed size*/
		this.size = size;
	}
	
	public int getPerson(){ /*a method to get the maximum number of person on a bed*/
		/*a single bed stores 1 person*/
		if (getBedSize().equalsIgnoreCase("single bed")){
			person = 1;
		}
		/*a double bed stores 2 persons*/
		else if (getBedSize().equalsIgnoreCase("double bed")){
			person = 2;
		}
		return person;
	}
}
