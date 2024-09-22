package in.sg.featureflagswithspringboot.shared.exception;

import in.sg.featureflagswithspringboot.shared.constants.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
  ResponseEntity<?> handleException(Exception ex, Model model) {
    logger.error(ex.getMessage(), ex);
    if (ex.getMessage().equals(ErrorConstants.FEATURE_NOT_ENABLED.getMessage())) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
  }
}
