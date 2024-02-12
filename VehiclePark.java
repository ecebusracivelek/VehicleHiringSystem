
package VehicleHiringSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class VehiclePark {
       private ArrayList<Vehicle>vehicles;            
       private ArrayList<Vehicle>bookedVehicles;                  
       private ArrayList<Vehicle>rentedVehicles;

  
       public VehiclePark(){
       
   }
       public ArrayList<Vehicle>getVehicles(){
        return vehicles;
}
       public void displayVehicles(){
       getVehicles();

    }
    
     public void displayAvailableVehicles(Date start, Date end) {
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();
         for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }

        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }
    }
     public void displayAvailableVehicles(Date start, Date end,String vehicleType) {
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();
         for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }

        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }
    }
     public void addVehicle(Vehicle vehicle){
         vehicles.add(vehicle);
     }
     public void removeVehicle(Vehicle vehicle){
         if(vehicles.contains(vehicle)){
             vehicles.remove(vehicle);
             
         }
     }
     
    public void bookVehicle(Date startDate, Date endDate) {
   Vehicle vehicle=new Vehicle();
    try {
            vehicle.bookMe(startDate, endDate);           
            System.out.println("Vehicle booked.");
       
    } catch (SorryWeDontHaveThatOneException e) {
        System.out.println("No vehicle type available for the specified dates.");
    }
}

public void cancelBooking(Date cancel,Date rental) {
   Vehicle vehicle=new Vehicle();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the ID of the vehicle to cancel the booking: ");
    int vehicleId = scanner.nextInt();
        if (vehicle.getId() == vehicleId ) {
            try {
                vehicle.cancelMe(cancel,rental);
                System.out.println("Booking canceled");
                return;
            } catch (NoCancellationYouMustPayException e) {
                System.out.println("Can't cancel the booking after the starting date of rental");
                return;
            }
        }
    System.out.println("Invalid vehicle ID");
}

public void rentVehicle(Date startDate, Date endDate, String deliveryLocation, String dropOffLocation) {
   Vehicle vehicle=new Vehicle();   
    try {
        vehicle.rentMe(startDate, endDate, deliveryLocation, dropOffLocation);
       
    } catch (SorryWeDontHaveThatOneException e) {
        System.out.println("Sorry, we don't have that vehicle type available for the specified dates.");
    }
}

public void dropVehicle() {
    Vehicle vehicle=new Vehicle();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the ID of the vehicle to drop: ");
    int vehicleId = scanner.nextInt();
        if (vehicle.getId() == vehicleId ) {
            vehicle.dropMe();
            System.out.println("Vehicle dropped");
            return;
        }
    System.out.println("Invalid vehicle ID");
}

public void load(int additionalLoad) {
   Vehicle vehicle=new Vehicle();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the ID of the vehicle to load: ");
    int vehicleId = scanner.nextInt();

        if (vehicle.getId() == vehicleId) {
            try {
                vehicle.loadMe(additionalLoad);
                System.out.println("Additional load added");
                return;
            } catch (OverWeightException e) {
                System.out.println("Loading capacity exceeded.");
            }
        
    }

    System.out.println("Invalid vehicle ID");
}


     public void dailyReport(String fileName) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
        writer.println("Daily Report");
        writer.println("Vehicles:");
        for (Vehicle vehicle : vehicles) {
            writer.println(vehicle.getId() + " - " + vehicle.getPlateNumber());
        }
        writer.println();

        writer.println("Booked Vehicles:");
        for (Vehicle vehicle : bookedVehicles) {
            writer.println(vehicle.getId() + " - " + vehicle.getPlateNumber());
        }
        writer.println();

        writer.println("Rented Vehicles:");
        for (Vehicle vehicle : rentedVehicles) {
            writer.println(vehicle.getId() + " - " + vehicle.getPlateNumber());
        }
   
        writer.println();

        System.out.println("Daily report generated");

    } catch (IOException e) {
        System.out.println("Exception...");
        e.printStackTrace();
    }
     }
  public Date stringToDate(String s) {
    try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(s);
    } catch (Exception ex) {
    System.out.println("Exception!");
    }   
    return null; 
}
}
