package in.sg.featureflagswithspringboot.service;

public interface DemoService {
  String featureA();

  String featureB(String flowType);
}
