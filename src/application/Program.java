package application;

import java.time.Duration;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), Reservation.DTF);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), Reservation.DTF);	
		
		if (!checkout.isAfter(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
		
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), Reservation.DTF);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), Reservation.DTF);
			
			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		
		}		
		
		sc.close();
	}

}
