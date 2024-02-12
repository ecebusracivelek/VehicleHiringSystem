
package VehicleHiringSystem;


public class SorryWeDontHaveThatOneException extends Exception{
    String msg;
    public SorryWeDontHaveThatOneException(String msg){
        this.msg=msg;
    }
}
