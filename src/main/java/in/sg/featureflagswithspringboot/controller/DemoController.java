package in.sg.featureflagswithspringboot.controller;

import in.sg.featureflagswithspringboot.service.DemoService;
import in.sg.featureflagswithspringboot.shared.featureflag.aspect.FeatureFlag;
import in.sg.featureflagswithspringboot.shared.featureflag.impl.FeatureBFeatureFlag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

  private final DemoService demoService;

  @GetMapping("/a")
  public ResponseEntity<String> featureA() {
    String result = demoService.featureA();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/b")
  @FeatureFlag(validators = {FeatureBFeatureFlag.class})
  public ResponseEntity<String> featureB(@RequestParam String flowType) {
    String result = demoService.featureB(flowType);
    return ResponseEntity.ok(result);
  }
}
