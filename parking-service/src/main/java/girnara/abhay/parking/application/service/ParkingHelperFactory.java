package girnara.abhay.parking.application.service;

import girnara.abhay.parking.application.service.helpers.ParkingHelper;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ParkingHelperFactory {
  @Autowired
  @Qualifier("motorBikeParkingHelper")
  private ParkingHelper motorBikeParkingHelper;
  @Autowired
  @Qualifier("largeVehicleParkingHelper")
  private ParkingHelper largeVehicleParkingHelper;

  public ParkingHelper getHelperByVehicleType(AbstractConstants.VehicleType vehicleType) throws NonRecoverableException {
    switch (vehicleType) {
      case BUS:
        return largeVehicleParkingHelper;
      case CAR:
        return largeVehicleParkingHelper;
      case MOTORBIKE:
        return motorBikeParkingHelper;
      default:
        throw new NonRecoverableException(AbstractConstants.ExceptionCode.INVALID_VEHICLE_TYPE_ERROR.getMessage(), AbstractConstants.ExceptionCode.INVALID_VEHICLE_TYPE_ERROR);
    }
  }
}
