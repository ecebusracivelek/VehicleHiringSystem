
package VehicleHiringSystem;

import java.util.Date;


public class Sports extends Car implements Bookable {
    private int horsePower;
     
    public Sports(int plateNumber, int numberOfTires,int dailyFee,boolean available, String color, int seatingCapacity, int numOfDoors){
     super(plateNumber, numberOfTires,dailyFee,available,color,seatingCapacity,numOfDoors); 
     this.horsePower=horsePower;
    }
     public int getHorsePower(){
         return horsePower;
                 
     }
        public void bookMe(Date start,Date end) throws SorryWeDontHaveThatOneException {
         if(available){           
             available=false;
         System.out.println("Sports car: " + id + " has been booked from " + start + " to " + end );   
         }
         else{
             throw new SorryWeDontHaveThatOneException("This Sports car is not available");
         }
         
        }

    public void cancelMe(Date cancellation,Date rental)throws NoCancellationYouMustPayException {
      if (cancellation.after(rental)) {
            throw new NoCancellationYouMustPayException("Can't cancel booking, rental has already started.");
        }

        if (!available) {
            available = true;
            System.out.println("Booking the sports car: " + id + " has been canceled.");
        }
        else {
            throw new NoCancellationYouMustPayException("You must pay first!");
        }

    }
}
