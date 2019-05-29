package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MedicalInfo {

  private final long bfr;

  private final long fmi;
}
