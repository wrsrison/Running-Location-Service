package demo.domain;

import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UnitInfo {

  private final String runningId;
  private String bandMake;
  private String customerName;
  private String unitNumber;

  public UnitInfo() {
    runningId = "";
  }

  public UnitInfo(String runningId) {
    this.runningId = runningId;
  }

  public UnitInfo(String runningId, String bandMake, String customerName, String unitNumber) {
    this.runningId = runningId;
    this.bandMake = bandMake;
    this.customerName = customerName;
    this.unitNumber = unitNumber;
  }

}
