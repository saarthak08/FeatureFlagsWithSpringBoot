package in.sg.featureflagswithspringboot.shared.featureflag.aspect;

/** The interface required by any feature flag to be implemented. */
public interface FeatureFlagValidator {

  boolean validate(Object... args);
}
