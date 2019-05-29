package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Embeddable
@Data
@RequiredArgsConstructor
public class MedicalInfo {

  private final long bfr;

  private final long fmi;
}
