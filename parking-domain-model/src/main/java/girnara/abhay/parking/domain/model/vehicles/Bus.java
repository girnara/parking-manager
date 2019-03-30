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
public class Bus extends Vehicle implements Serializable {
  private static final long serialVersionUID = 2969760692531639014L;

  @JsonCreator
  public Bus() {
    super(AbstractConstants.VehicleType.BUS);
  }
}
