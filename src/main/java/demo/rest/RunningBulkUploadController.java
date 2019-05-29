package demo.rest;

import demo.domain.Location;
import demo.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunningBulkUploadController {

  @Autowired
  private LocationService locationService;

  @RequestMapping(value = "/running", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void upload(@RequestBody List<Location> locations) {
    locationService.saveRunningLocation(locations);
  }

  @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
  public void purge() {
    locationService.deleteAll();
  }

  @RequestMapping(value = "/running/{movementType}", method = RequestMethod.GET)
  public Page<Location> findByMovementType(@PathVariable String movementType,
      @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
    return this.locationService.findByRunnerMovementType(movementType, new PageRequest(page, size));
  }
}
