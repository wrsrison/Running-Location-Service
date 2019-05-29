package demo.service;

import demo.domain.Location;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This interface represents a location service.
 */
public interface LocationService {

  List<Location> saveRunningLocation(List<Location> runningLocations);

  void deleteAll();

  Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);


}
