
package VehicleHiringSystem;


public class StationWagon extends Car implements Loadable {
    private int loadingCapacity;
    
      public StationWagon(int plateNumber, int numberOfTires,int dailyFee,boolean available, String color, int seatingCapacity, int numOfDoors,int loadingCapacity){
     super(plateNumber, numberOfTires,dailyFee,available, color,seatingCapacity,numOfDoors); 
     this.loadingCapacity=loadingCapacity;
      }
      
      public int getLoadingCapacity(){
          return loadingCapacity;
      }
          public void loadMe(int additionalLoad)throws OverWeightException {
       
              if(additionalLoad>loadingCapacity){
            throw new OverWeightException("Loading capacity is exceeded");
        }
              else{                 
                  System.out.println("Additional load: " + additionalLoad + " has been loaded onto the station wagon");   
                  loadingCapacity-=additionalLoad;
              }
              }
    }

