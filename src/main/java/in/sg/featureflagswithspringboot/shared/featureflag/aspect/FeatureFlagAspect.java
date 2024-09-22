package in.sg.featureflagswithspringboot.shared.featureflag.aspect;

import in.sg.featureflagswithspringboot.shared.constants.ErrorConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * This aspect class manages feature flag validation based on annotations. It includes a method that
 * intercepts calls to methods annotated with @FeatureFlag, validates the feature flag using the
 * provided validators, and throws a GenericException if the validation doesn't pass.
 */
@Aspect
@Component
public class FeatureFlagAspect {

  @Autowired private ApplicationContext applicationContext;

  /**
   * Intercepts method calls annotated with @FeatureFlag, validates the feature flag using the
   * specified validators, and throws a GenericException if the validation fails.
   *
   * @param joinPoint the ProceedingJoinPoint object representing the method being intercepted
   * @param featureFlag the FeatureFlag annotation object containing the validators to be applied
   * @return the result of the method execution if all validators pass
   * @throws Throwable if an error occurs during the interception or validation process
   */
  @Around(value = "@annotation(featureFlag)", argNames = "featureFlag")
  public Object checkFeatureFlag(ProceedingJoinPoint joinPoint, FeatureFlag featureFlag)
      throws Throwable {
    Object[] args = joinPoint.getArgs();
    for (Class<? extends FeatureFlagValidator> validatorClass : featureFlag.validators()) {
      FeatureFlagValidator validator = applicationContext.getBean(validatorClass);
      if (!validator.validate(args)) {
        throw new RuntimeException(ErrorConstants.FEATURE_NOT_ENABLED.getMessage());
      }
    }
    // All validators returned true, proceed with the method execution
    return joinPoint.proceed();
  }
}
