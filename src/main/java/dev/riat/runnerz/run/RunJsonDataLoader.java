package dev.riat.runnerz.run;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
  private final RunRepository runRepository;
  private final ObjectMapper objectMapper;

  public RunJsonDataLoader(RunRepository runRepository, ObjectMapper objectMapper){
    this.runRepository = runRepository;
    this.objectMapper = objectMapper;
  }

  @Override
  public void run(String... args) throws Exception {
    if(runRepository.count()<=3){
      try(InputStream is = getClass().getResourceAsStream("/data/runs.json")){
        log.info("Loading data from JSON file");
        Runs runs = objectMapper.readValue(is, Runs.class);
        runRepository.saveAll(runs.runs());

      }catch(IOException e){
        throw new RuntimeException("Failed to load data from JSON file", e);
      }
      
    }else{
      log.info("Data already existed in the database");
    }

  }
}