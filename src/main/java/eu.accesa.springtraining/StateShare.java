package eu.accesa.springtraining;

import com.hazelcast.core.HazelcastInstance;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateShare {

//  @Autowired
//  HazelcastInstance hazelcastInstance;

  @PostConstruct
  public void doShit() {
//    hazelcastInstance.getList("springtraining").add("Cristi");
  }

}
