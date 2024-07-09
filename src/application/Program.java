package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException{

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if (!checkout.after(checkIn)) {
            System.out.println("Error in Reservation: check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data  to update reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkout);
            if (error != null) {
                System.out.println("Error in reservetion: " + error);
            }
            else{
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }
}
