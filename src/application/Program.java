package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.print("Room number:");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy):");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy):");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt1);
				if(!checkOut.isAfter(checkIn)) {
					System.out.println("Error in reservation: Check-out date must be after check-in date");
				}
				else {
					Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
					System.out.println(reservation);
				
					System.out.println("Enter data to update the reservation:");
					System.out.print("Check-in date (dd/MM/yyyy):");
					checkIn = LocalDate.parse(sc.nextLine(), fmt1);
					System.out.print("Check-out date (dd/MM/yyyy):");
					checkOut = LocalDate.parse(sc.nextLine(), fmt1);
					LocalDate now = LocalDate.now();
						if(!checkIn.isAfter(now) || !checkOut.isAfter(now)) {
							System.out.println("Error in reservation: Reservation dates for update must be future dates");
						}else if(!checkOut.isAfter(checkIn)) {
								System.out.println("Error in reservation: Check-out date must be after check-in date");
								}else {
									reservation.updatereservation(checkIn, checkOut);
									System.out.println(reservation);
								}

					}
		sc.close();
	}

}
