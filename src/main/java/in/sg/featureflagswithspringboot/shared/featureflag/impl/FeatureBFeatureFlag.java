package in.sg.featureflagswithspringboot.shared.featureflag.impl;

import in.sg.featureflagswithspringboot.shared.featureflag.aspect.FeatureFlagValidator;
import in.sg.featureflagswithspringboot.shared.featureflag.config.FeatureFlagConfigs;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeatureBFeatureFlag implements FeatureFlagValidator {
  private final FeatureFlagConfigs featureFlagConfigs;
  private final Logger logger = LoggerFactory.getLogger(FeatureBFeatureFlag.class);
  private final HttpServletRequest httpServletRequest;

  @Override
  public boolean validate(Object... args) {
    boolean enabled = featureFlagConfigs.getFeatureBEnabled();
    String flowType = httpServletRequest.getParameter("flowType");
    boolean isFlowAllowed =
        Arrays.stream(featureFlagConfigs.getFeatureBEnabledFlowTypeValues().split(","))
            .toList()
            .contains(flowType);
    if (!(isFlowAllowed && enabled)) {
      logger.error("Feature B is not enabled!");
    }
    return isFlowAllowed && enabled;
  }
}
