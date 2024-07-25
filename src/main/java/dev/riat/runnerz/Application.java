package dev.riat.runnerz;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.riat.runnerz.run.Run;
import dev.riat.runnerz.run.RunRepository;
import dev.riat.runnerz.user.User;
import dev.riat.runnerz.user.UserHttpClient;
import dev.riat.runnerz.user.UserRestClient;






@SpringBootApplication
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    log.info("Apllication initiaized successfully.");
	}
  
  @Bean
  UserHttpClient userHttpClient(){
    RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
    return factory.createClient(UserHttpClient.class);
  }


  @Bean
  CommandLineRunner runner(UserHttpClient client){
    return args -> {
      List<User> users = client.findAll();
      System.out.println(users);
    };
  }
}
