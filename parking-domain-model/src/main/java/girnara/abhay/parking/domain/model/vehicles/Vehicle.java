package girnara.abhay.parking.domain.model.vehicles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import lombok.Data;
/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
    include = JsonTypeInfo.As.PROPERTY,
    property = "class")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Bus.class, name = "BUS"),
    @JsonSubTypes.Type(value = Car.class, name = "CAR"),
    @JsonSubTypes.Type(value = Motorcycle.class, name = "MOTORBIKE")
})
public abstract class Vehicle {
  private String registrationNumber;
  private final AbstractConstants.VehicleType type;
  private ParkingTicket ticket;
  public Vehicle(AbstractConstants.VehicleType type) {
    this.type = type;
  }

  public void assignTicket(ParkingTicket ticket) {
    this.ticket = ticket;
  }
}