package girnara.abhay.parking.domain.model.spots;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ParkingSpot implements Serializable {
  private static final long serialVersionUID = 5179640744833877988L;
  private String number;
  private boolean free;
  private Vehicle vehicle;
  private final AbstractConstants.ParkingSpotType type;

  /**
   * Is free boolean.
   *
   * @return the boolean
   */
  public boolean IsFree() {
    return this.free;
  }

  /**
   * Instantiates a new Parking spot.
   *
   * @param type the type
   */
  public ParkingSpot(AbstractConstants.ParkingSpotType type) {
    this.type = type;
    this.free = true;
  }

  /**
   * Assign vehicle.
   *
   * @param vehicle the vehicle
   */
  public void assignVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.free = false;
  }

  /**
   * Remove vehicle.
   */
  public void removeVehicle() {
    this.vehicle = null;
    free = true;
  }
}