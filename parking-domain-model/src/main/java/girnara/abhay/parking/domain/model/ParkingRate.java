package girnara.abhay.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
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
public class ParkingRate implements Serializable {
  private static final long serialVersionUID = 73715282091918083L;
  private Map<AbstractConstants.DayType, Double> dayTypeHourlyRate = new ConcurrentHashMap<>();
  // DEFAULT: 45.0 INR/Hour
}
