
package VehicleHiringSystem;


public class SUV extends Car {
        private String wd;
        
    public SUV(int plateNumber, int numberOfTires,int dailyFee,boolean available, String color, int seatingCapacity, int numOfDoors,int loadingCapacity,String wd){
     super(plateNumber, numberOfTires,dailyFee,available,color,seatingCapacity,numOfDoors); 
     this.wd=wd;
    }
    
    public String getWd(){
        return wd;
    }
}
