package ilab.assesment.utility;

import java.util.*;

public class PhoneNumber{

	public String mobileNumber() {
		
		int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the cell number number

        //Area code number; Will print 083
        num1 = randInt(0, 0);  
        num2 = randInt(6, 8); 
        num3 = randInt(1, 4);
 
        set2 = randInt(000, 999);
        
        set3 = randInt(0000, 9999);
		return num1 + "" + num2 + "" + num3  + " " + set2 + " " + set3 ;
		
		
	}
	
	private int randInt(int minimum, int maximum) {
		Random rand = new Random();

		int randomNum = rand.nextInt((maximum - minimum) + 1) + minimum;

		return randomNum;
	}
}
