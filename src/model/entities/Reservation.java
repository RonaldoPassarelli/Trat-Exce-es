package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {
	}
	
	public Reservation(Integer roomnumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomnumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomnumber() {
		return roomNumber;
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomNumber = roomnumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
	}
	
	public void updatereservation(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reservation Room: " + getRoomnumber() 
				+ ", check-in: "
				+ getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", check-out: "
				+ getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", " + duration()
				+ " nights";
	}
}

