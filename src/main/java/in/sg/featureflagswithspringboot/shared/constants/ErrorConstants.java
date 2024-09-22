package in.sg.featureflagswithspringboot.shared.constants;

import lombok.Getter;

@Getter
public enum ErrorConstants {
  FEATURE_NOT_ENABLED("Feature not enabled");

  private String message;

  ErrorConstants(String message) {
    this.message = message;
  }
}
