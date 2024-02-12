
package VehicleHiringSystem;

import java.util.Date;

public interface Bookable {
 public abstract void bookMe(Date start,Date end)throws SorryWeDontHaveThatOneException;
  public abstract void cancelMe(Date cancellation,Date rental) throws NoCancellationYouMustPayException;
}
