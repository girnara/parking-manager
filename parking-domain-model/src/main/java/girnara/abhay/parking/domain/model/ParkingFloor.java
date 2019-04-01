package girnara.abhay.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.spots.LargeSpot;
import girnara.abhay.parking.domain.model.spots.MotorbikeSpot;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingFloor implements Serializable {
  private static final long serialVersionUID = 540509149161430150L;
  private String name;
  private Map<String, LargeSpot> largeSpots = new ConcurrentHashMap<>();
  private Map<String, MotorbikeSpot> motorbikeSpots = new ConcurrentHashMap<>();

}