package in.sg.featureflagswithspringboot.shared.featureflag.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** This annotation is applied to methods intended for use with feature flags. */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FeatureFlag {

  /**
   * This method returns a list of validator classes specified in the FeatureFlag annotation, which
   * are used to verify the condition for enabling the feature flag.
   */
  Class<? extends FeatureFlagValidator>[] validators();
}
