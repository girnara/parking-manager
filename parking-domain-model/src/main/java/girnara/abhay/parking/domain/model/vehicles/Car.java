package girnara.abhay.parking.domain.model.vehicles;

import com.fasterxml.jackson.annotation.JsonCreator;
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
public class Car extends Vehicle implements Serializable {
  private static final long serialVersionUID = 5058144211719401728L;

  /**
   * Instantiates a new Car.
   */
  @JsonCreator
  public Car() {
    super(AbstractConstants.VehicleType.CAR);
  }
}