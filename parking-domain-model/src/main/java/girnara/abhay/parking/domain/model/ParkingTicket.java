package girnara.abhay.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
/**
 * Created by abhay on 30/03/19.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingTicket implements Serializable {
  private static final long serialVersionUID = -7648495699896111569L;
  private String id;
  private String parkingSpotId;
  private long timestamp;
  private DateTime issueAt;
  private DateTime payedAt;
  private double payedAmount;
  private AbstractConstants.ParkingTicketStatus status;
  private String paymentReferenceId;
}
