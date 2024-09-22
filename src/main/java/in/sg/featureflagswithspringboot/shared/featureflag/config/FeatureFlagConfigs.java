package in.sg.featureflagswithspringboot.shared.featureflag.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** This class is used to load all the feature flag configurations. */
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "feature-flags")
@Getter
public class FeatureFlagConfigs {
  final Boolean featureAEnabled;
  final Boolean featureBEnabled;
  final String featureBEnabledFlowTypeValues;
}
