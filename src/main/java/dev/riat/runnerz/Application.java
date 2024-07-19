package dev.riat.runnerz;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.riat.runnerz.run.Location;
import dev.riat.runnerz.run.Run;
import dev.riat.runnerz.run.RunRepository;




@SpringBootApplication
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    log.info("Apllication initiaized successfully.");
	}

  // @Bean
  // CommandLineRunner runner(RunRepository runRepository){ {
  //   return args -> {
  //     Run run = new Run(4, "Long Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR);
  //     runRepository.create(run);
  //     };
  //   }
  // }
}
