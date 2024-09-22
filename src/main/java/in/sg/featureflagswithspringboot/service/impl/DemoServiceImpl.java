package in.sg.featureflagswithspringboot.service.impl;

import in.sg.featureflagswithspringboot.service.DemoService;
import in.sg.featureflagswithspringboot.shared.featureflag.aspect.FeatureFlag;
import in.sg.featureflagswithspringboot.shared.featureflag.impl.FeatureAFeatureFlag;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
  @Override
  @FeatureFlag(validators = {FeatureAFeatureFlag.class})
  public String featureA() {
    return "Hello from A";
  }

  @Override
  public String featureB(String flowType) {
    return "Hello from B with flowType: " + flowType;
  }
}
