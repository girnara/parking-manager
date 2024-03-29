package girnara.abhay.parking.domain.model.spots;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MotorbikeSpot extends ParkingSpot implements Serializable {
  private static final long serialVersionUID = 6985755430312098145L;

  /**
   * Instantiates a new Motorbike spot.
   */
  public MotorbikeSpot() {
    super(AbstractConstants.ParkingSpotType.MOTORBIKE);
  }
}
