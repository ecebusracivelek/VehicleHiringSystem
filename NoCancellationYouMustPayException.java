
package VehicleHiringSystem;


public class NoCancellationYouMustPayException extends Exception {
      String msg;
    public NoCancellationYouMustPayException(String msg){
        this.msg=msg;
    }
}
