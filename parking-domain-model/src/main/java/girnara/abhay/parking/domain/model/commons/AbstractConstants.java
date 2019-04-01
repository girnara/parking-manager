package girnara.abhay.parking.domain.model.commons;

import org.joda.time.DateTimeZone;

/**
 * Created by abhay on 30/03/19.
 */
public abstract class AbstractConstants {
  /**
   * The constant DEFAULT_TYPE_DAY.
   */
  public static final String DEFAULT_TYPE_DAY = "DEFAULT";
  /**
   * The constant DEFAULT_PAYMENT_REF.
   */
  public static final String DEFAULT_PAYMENT_REF = "CASH";
  /**
   * The constant SECRET_KEY.
   */
  public static final String SECRET_KEY = "366xhegrndhfspwiryrskwhd0801";
  /**
   * The constant DEFAULT_PARKING_FEE.
   */
  public static final double DEFAULT_PARKING_FEE = 100.0;
  /**
   * The constant DEFAULT_TIME_ZONE.
   */
  public static final DateTimeZone DEFAULT_TIME_ZONE = DateTimeZone.UTC;

  /**
   * The enum Exception code.
   */
  public enum ExceptionCode {
    /**
     * The None.
     */
    NONE("Successfully processed your request"),
    /**
     * The Down stream service error.
     */
    DOWN_STREAM_SERVICE_ERROR("Downstream System is Unavailable. Please try after sometime or contact our support team"),
    /**
     * The Object deep copy clone failed error.
     */
    OBJECT_DEEP_COPY_CLONE_FAILED_ERROR("Object is not serializable"),
    /**
     * The Deserialization failed error.
     */
    DESERIALIZATION_FAILED_ERROR("Error occurred while deserializing of request object"),
    /**
     * The Serialization failed error.
     */
    SERIALIZATION_FAILED_ERROR("Error occurred while serializing of request object"),
    /**
     * The Null request error.
     */
    NULL_REQUEST_ERROR("Request can not be null"),
    /**
     * The Unauthorised access error.
     */
    UNAUTHORISED_ACCESS_ERROR("You are not allowed to access this service"),
    /**
     * The Entrance gate null error.
     */
    ENTRANCE_GATE_NULL_ERROR("Entrance gate can not be zero"),
    /**
     * The Vehicle registration number null error.
     */
    VEHICLE_REGISTRATION_NUMBER_NULL_ERROR("Vehicle registration number can not be null"),
    /**
     * The Vehicle type null error.
     */
    VEHICLE_TYPE_NULL_ERROR("Vehicle type can not be empty"),
    /**
     * The Exit gate null error.
     */
    EXIT_GATE_NULL_ERROR("Exit gate can not be zero"),
    /**
     * The Parking floors null error.
     */
    PARKING_FLOORS_NULL_ERROR("Parking floors can not be zero"),
    /**
     * The Parking lot address null error.
     */
    PARKING_LOT_ADDRESS_NULL_ERROR("Parking lot address can not be empty"),
    /**
     * The Parking lot rate null error.
     */
    PARKING_LOT_RATE_NULL_ERROR("Parking Lot fare rate can not be null"),
    /**
     * The Parking lot name null error.
     */
    PARKING_LOT_NAME_NULL_ERROR("Parking lot name can not be null"),
    /**
     * The Parking lot already exists error.
     */
    PARKING_LOT_ALREADY_EXISTS_ERROR("Can not recreate a existing parking lot"),
    /**
     * The Parking full error.
     */
    PARKING_FULL_ERROR("Parking full, Please visit another nearest parking lot"),
    /**
     * The Parking lot does not exists error.
     */
    PARKING_LOT_DOES_NOT_EXISTS_ERROR("Invalid client Id"),
    /**
     * The Vehicle is already in parking error.
     */
    VEHICLE_IS_ALREADY_IN_PARKING_ERROR("Vehicle is already assigned the parking ticket. Please search the parking ticket with vehicle registration"),
    /**
     * The Vehicle does not exists error.
     */
    VEHICLE_DOES_NOT_EXISTS_ERROR("Vehicle does not exist in this parking"),
    /**
     * The Parking ticket invalid error.
     */
    PARKING_TICKET_INVALID_ERROR("Parking ticket is invalid"),
    /**
     * The Invalid vehicle type error.
     */
    INVALID_VEHICLE_TYPE_ERROR("Invalid vehicle type"),
    /**
     * The Invalid request error.
     */
    INVALID_REQUEST_ERROR("Request is not valid");

    private String message;

    private ExceptionCode(String message) {
      this.message=message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
      return message;
    }

  }

  /**
   * The constant FAILED_STATUS_CODE.
   */
  public static final String FAILED_STATUS_CODE = "FAILED";
  /**
   * The constant SUCCESS_STATUS_CODE.
   */
  public static final String SUCCESS_STATUS_CODE = "SUCCESS";

  /**
   * The enum Vehicle type.
   */
  public enum VehicleType {
    /**
     * Car vehicle type.
     */
    CAR, /**
     * Bus vehicle type.
     */
    BUS, /**
     * Motorbike vehicle type.
     */
    MOTORBIKE
  }

  /**
   * The enum Parking spot type.
   */
  public enum ParkingSpotType {
    /**
     * Large parking spot type.
     */
    LARGE, /**
     * Motorbike parking spot type.
     */
    MOTORBIKE
  }

  /**
   * The enum Parking ticket status.
   */
  public enum ParkingTicketStatus {
    /**
     * Active parking ticket status.
     */
    ACTIVE, /**
     * Paid parking ticket status.
     */
    PAID, /**
     * Lost parking ticket status.
     */
    LOST
  }

  /**
   * The enum Day type.
   */
  public enum DayType {
    /**
     * Weekday day type.
     */
    WEEKDAY, /**
     * Weekends day type.
     */
    WEEKENDS, /**
     * Public holiday day type.
     */
    PUBLIC_HOLIDAY, /**
     * Default day type.
     */
    DEFAULT;
  }


}
