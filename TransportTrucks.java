
package VehicleHiringSystem;

public class TransportTrucks extends Truck{
    
    private boolean goesAbroad;
    
     public TransportTrucks(int plateNumber, int numberOfTires,int dailyFee,boolean available,int loadingCapacity, boolean goesAbroad){
     super(plateNumber,numberOfTires,dailyFee,available,loadingCapacity);
     this.goesAbroad=goesAbroad;
     }
     
     public boolean isGoesAbroad(){
         return goesAbroad;
     }
} 
