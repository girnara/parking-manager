package girnara.abhay.parking.domain.model.spots;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ParkingSpot implements Serializable {
  private static final long serialVersionUID = 5179640744833877988L;
  private String number;
  private boolean free;
  private Vehicle vehicle;
  private final AbstractConstants.ParkingSpotType type;

  public boolean IsFree() {
    return this.free;
  }

  public ParkingSpot(AbstractConstants.ParkingSpotType type) {
    this.type = type;
    this.free = true;
  }

  public void assignVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.free = false;
  }

  public void removeVehicle() {
    this.vehicle = null;
    free = true;
  }
}