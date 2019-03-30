package girnara.abhay.parking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ParkingLot {
  private String id;
  private String name;
  private Address address;
  private ParkingRate parkingRate;
  private int largeSpotCount;
  private int motorbikeSpotCount;
  private int maxLargeCount;
  private int maxMotorbikeCount;
  private Map<String, String> existingVehicles = new ConcurrentHashMap<>();
  private List<EntranceGate> entranceGates = new ArrayList<>();
  private List<ExitGate> exitGates = new ArrayList<>();
  // all active parking floors
  private List<ParkingFloor> parkingFloors = new ArrayList<>();
  // all active parking tickets, identified by their ticketNumber
  private Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
}