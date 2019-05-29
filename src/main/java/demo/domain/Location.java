package demo.domain;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "RUNNING_LOCATION")
public class Location {

  enum GpsStatus {
    EXCELLENT, OK, UNRELIABLE, BAD, NOTFIX, UNKNOWN;
  }

  public enum RunnerMovementType {
    STOPPED, IN_MOTION;

    public boolean isMoving() {
      return this != STOPPED;
    }
  }

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  @AttributeOverride(name = "bandMake", column = @Column(name = "unit_band_make"))
  private final UnitInfo unitInfo;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "fmi", column = @Column(name = "medical_fmi")),
      @AttributeOverride(name = "bfr", column = @Column(name = "medical_bfr"))
  })
  private MedicalInfo medicalInfo;

  private double latitude;
  private double longitude;

  private String heading;
  private double gpsSpeed;
  private GpsStatus gpsStatus;

  private double odometer;
  private double totalRunningTime;
  private double totalIdleTime;
  private double totalCaloriesBurnt;
  private String address;
  private Date timestamp = new Date();
  private String gearProvider;
  private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
  private String serviceType;

  public Location(String runningId) {
    this.unitInfo = new UnitInfo(runningId);
  }
}
