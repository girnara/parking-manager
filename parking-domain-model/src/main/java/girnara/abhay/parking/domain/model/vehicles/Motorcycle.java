package girnara.abhay.parking.domain.model.vehicles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Motorcycle extends Vehicle implements Serializable {

  private static final long serialVersionUID = 3112042892202879653L;
  @JsonCreator
  public Motorcycle() {
    super(AbstractConstants.VehicleType.MOTORBIKE);
  }
}