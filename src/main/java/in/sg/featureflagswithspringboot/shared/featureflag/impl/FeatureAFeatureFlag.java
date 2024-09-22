package in.sg.featureflagswithspringboot.shared.featureflag.impl;

import in.sg.featureflagswithspringboot.shared.featureflag.aspect.FeatureFlagValidator;
import in.sg.featureflagswithspringboot.shared.featureflag.config.FeatureFlagConfigs;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeatureAFeatureFlag implements FeatureFlagValidator {
  private final FeatureFlagConfigs featureFlagConfigs;
  private final Logger logger = LoggerFactory.getLogger(FeatureAFeatureFlag.class);

  @Override
  public boolean validate(Object... args) {
    boolean result = featureFlagConfigs.getFeatureAEnabled();
    if (!result) {
      logger.error("Feature A is not enabled!");
    }
    return result;
  }
}
