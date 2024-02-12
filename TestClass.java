
package VehicleHiringSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TestClass {


  private static VehiclePark vehiclePark = new VehiclePark();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Hiring System!");
        System.out.print("Are you an admin (A) or a customer (C)? ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("A")) {
            adminMenu();
        } else if (role.equalsIgnoreCase("C")) {
            customerMenu();
        } else {
            System.out.println("Invalid role. Exiting the program.");
        }
    }

 
   
    private static void adminMenu(){
        Scanner scn=new Scanner(System.in);        
        boolean adminMenu=true;    
                while(adminMenu){
            System.out.println("==== Admin Menu ====");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Display available vehicles");
            System.out.println("3. Add a new vehicle to the system");
            System.out.println("4. Remove a vehicle from the system");
            System.out.println("5. Generate daily reports");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice=scn.nextInt();
            VehiclePark vehiclePark=new VehiclePark();
            switch (choice){
            case 1:
                 vehiclePark.displayVehicles();
                    break;
            case 2:                 
                System.out.println("Enter a start date: ");
                String start=scn.nextLine();
               Date s= vehiclePark.stringToDate(start);
                System.out.println("Enter a start date: ");
                String end=scn.nextLine();
                Date e=vehiclePark.stringToDate(end);
                 System.out.println("If you want to enter vehicle type write 1,if not write 2: ");
               int t=scn.nextInt();
               switch(t){
                   case 1:                  
                       System.out.println("Enter the vehicle type: ");
                       String type=scn.nextLine();
                       vehiclePark.displayAvailableVehicles(s,e,type);
                       break;
                   case 2:
                       vehiclePark.displayAvailableVehicles(s,e);
                       break;
                   default:
                        System.out.println("Enter correct value");
               }                 
         
                break;
            case 3:                    
                System.out.println("Enter the plate number: ");
                int plateNumber=scn.nextInt();
                 System.out.println("Enter the number of tires: ");
                int numberOfTires=scn.nextInt();
                 System.out.println("Enter the daily fee: ");
                int dailyFee=scn.nextInt();
                 System.out.println("Enter the daily fee: ");
                boolean available=scn.nextBoolean();
                Vehicle newVehicle=new Vehicle(plateNumber,numberOfTires,dailyFee,available);
                vehiclePark.addVehicle(newVehicle);
                break;
            case 4:   
     System.out.println("Enter the info of the vehicle to remove: ");
              System.out.println("Enter the plate number: ");
                int plateNum=scn.nextInt();
                 System.out.println("Enter the number of tires: ");
                int numOfTires=scn.nextInt();
                 System.out.println("Enter the daily fee: ");
                int dailyfee=scn.nextInt();
                 System.out.println("Enter the daily fee: ");
                boolean avAilable=scn.nextBoolean();
                Vehicle rem=new Vehicle(plateNum,numOfTires,dailyfee,avAilable);
                vehiclePark.removeVehicle(rem);
     break;
            case 5: 
                break;
            case 6:   
                System.out.println("Exiting...");
                adminMenu=false;
                break;
        default:
            System.out.println("Invalid input");
            }
            }
            }
    
    private static void customerMenu() {
            
            System.out.println("==== Customer Menu ====");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Display available vehicles");
            System.out.println("3. Display available vehicles by type");
            System.out.println("4. Book a vehicle");
            System.out.println("5. Cancel a booking");
            System.out.println("6. Rent a vehicle");
            System.out.println("7. Drop a vehicle");
            System.out.println("8. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                vehiclePark.displayVehicles();
                    break;
                case 2:
                    System.out.println("Enter a start date: ");
                String start=scanner.nextLine();
               Date s= vehiclePark.stringToDate(start);
                System.out.println("Enter a start date: ");
                String end=scanner.nextLine();
                Date e=vehiclePark.stringToDate(end);
                    vehiclePark.displayAvailableVehicles(s,e);
                    break;
                case 3:
                    System.out.println("Enter a start date: ");
                String start2=scanner.nextLine();
               Date s2= vehiclePark.stringToDate(start2);
                System.out.println("Enter a start date: ");
                String end2=scanner.nextLine();
                Date e2=vehiclePark.stringToDate(end2);
                 System.out.println("Enter the vehicle type: ");
                       String type=scanner.nextLine();
                    vehiclePark.displayAvailableVehicles(s2,e2,type);
                    break;
                case 4:
         System.out.println("Enter a starting date to book: ");
         String s3=scanner.next();
         System.out.println("Enter a ending date to book: ");
         String e3=scanner.next();
         Date start3=vehiclePark.stringToDate(s3);
         Date end3=vehiclePark.stringToDate(e3); 
                    vehiclePark.bookVehicle(start3,end3);                    
                    break;
                case 5:
           System.out.println("Enter a starting date to book: ");
         String s4=scanner.next();
         System.out.println("Enter a ending date to book: ");
         String e4=scanner.next();
         Date cancel=vehiclePark.stringToDate(s4);
         Date rental=vehiclePark.stringToDate(e4); 
                    vehiclePark.cancelBooking(cancel,rental); 
                    break;
                case 6:
                    System.out.println("Enter a starting date to book: ");
         String s5=scanner.next();
         System.out.println("Enter a ending date to book: ");
         String e5=scanner.next();
         Date start5=vehiclePark.stringToDate(s5);
         Date end5=vehiclePark.stringToDate(e5); 
          System.out.println("Enter a delivery location: ");
         String delLoc=scanner.next();
          System.out.println("Enter a dropping location: ");
         String dropLoc=scanner.next();
                    vehiclePark.rentVehicle(start5,end5,delLoc,dropLoc);
                    break;
                case 7:
                    vehiclePark.dropVehicle();
                    break;
                case 8:
                    System.out.println("Exiting...");                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
    }  

}

