package girnara.abhay.parking.domain.model.commons;

import org.joda.time.DateTimeZone;

public abstract class AbstractConstants {
  public static final String DEFAULT_TYPE_DAY = "DEFAULT";
  public static final double DEFAULT_PARKING_FEE = 100.0;
  public static final DateTimeZone DEFAULT_TIME_ZONE = DateTimeZone.UTC;
  public enum ExceptionCode {
    NONE("Successfully processed your request"),
    DOWN_STREAM_SERVICE_ERROR("Downstream System is Unavailable. Please try after sometime or contact our support team"),
    OBJECT_DEEP_COPY_CLONE_FAILED_ERROR("Object is not serializable"),
    DESERIALIZATION_FAILED_ERROR("Error occurred while deserializing of request object"),
    SERIALIZATION_FAILED_ERROR("Error occurred while serializing of request object"),
    NULL_REQUEST_ERROR("Request can not be null"),
    ENTRANCE_GATE_NULL_ERROR("Entrance gate can not be zero"),
    VEHICLE_REGISTRATION_NUMBER_NULL_ERROR("Vehicle registration number can not be null"),
    VEHICLE_TYPE_NULL_ERROR("Vehicle type can not be empty"),
    EXIT_GATE_NULL_ERROR("Exit gate can not be zero"),
    PARKING_FLOORS_NULL_ERROR("Parking floors can not be zero"),
    PARKING_LOT_ADDRESS_NULL_ERROR("Parking lot address can not be empty"),
    PARKING_LOT_RATE_NULL_ERROR("Parking Lot fare rate can not be null"),
    PARKING_LOT_NAME_NULL_ERROR("Parking lot name can not be null"),
    PARKING_LOT_ALREADY_EXISTS_ERROR("Can not recreate a existing parking lot"),
    PARKING_FULL_ERROR("Parking full, Please visit another nearest parking lot"),
    PARKING_LOT_DOES_NOT_EXISTS_ERROR("Invalid client Id"),
    PARKING_TICKET_INVALID_ERROR("Parking ticket is invalid"),
    INVALID_VEHICLE_TYPE_ERROR("Invalid vehicle type"),
    INVALID_REQUEST_ERROR("Request is not valid");

    private String message;

    private ExceptionCode(String message) {
      this.message=message;
    }

    public String getMessage() {
      return message;
    }

  }

  public static final String FAILED_STATUS_CODE = "FAILED";
  public static final String SUCCESS_STATUS_CODE = "SUCCESS";

  public enum VehicleType {
    CAR, BUS, MOTORBIKE
  }

  public enum ParkingSpotType {
     LARGE, MOTORBIKE
  }

  public enum ParkingTicketStatus {
    ACTIVE, PAID, LOST
  }

  public enum DayType {
    WEEKDAY, WEEKENDS,PUBLIC_HOLIDAY, DEFAULT;
  }


}
