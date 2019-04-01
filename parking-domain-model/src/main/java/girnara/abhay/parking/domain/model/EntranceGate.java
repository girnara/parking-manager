package girnara.abhay.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.Serializable;

/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntranceGate implements Serializable {
  private static final long serialVersionUID = 440816596643868784L;
  private String id;
}
