package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/*Room number: 8021 OK
Check-in date (dd/MM/yyyy): 23/09/2019 OK
Check-out date (dd/MM/yyyy): 26/09/2019 OK
Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights OK

Enter data to update the reservation: OK
Check-in date (dd/MM/yyyy): 24/09/2019 OK
Check-out date (dd/MM/yyyy): 29/09/2019 OK 
Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights8*/
		
		Scanner in = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		
		System.out.println("Room number:");
		Integer roomNumber = in.nextInt();
		
		System.out.println("Check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(in.next());
		
		System.out.println("Check-out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(in.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else{
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
		
		System.out.println("");
		
		System.out.println("Enter data to update the reservation:");
		System.out.println("Check-in date (dd/MM/yyyy):");
		checkIn = sdf.parse(in.next());
		System.out.println("Check-out date (dd/MM/yyyy):");
		checkOut = sdf.parse(in.next());
		
		if(checkIn.before(now) || checkOut.before(now)) 
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		
		else{
			reservation.updates(checkIn, checkOut);
			System.out.println(reservation);
		}
		//ok
		}
	}

}
