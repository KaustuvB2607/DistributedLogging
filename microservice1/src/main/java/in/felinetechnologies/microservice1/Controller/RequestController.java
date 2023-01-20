package in.felinetechnologies.microservice1.Controller;



import in.felinetechnologies.microservice1.DAO.DB1Entity;
import in.felinetechnologies.microservice1.DAO.DB2Entity;
import in.felinetechnologies.microservice1.DAO.DB3Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/getDB1DataMS1Method1")
    public @ResponseBody Iterable<DB1Entity> getDB1DataMS1Method1() {
        LOG.info("Inside getDB1DataMethod1 of Microservice1");
        String baseUrl = "http://localhost:8081/getDB1DataMS2Method1";
        Iterable<DB1Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB1DataMethod1 of Microservice1 is: " + response.toString());
        return response;
    }

    @GetMapping(value = "/getDB2DataMS1Method2")
    public @ResponseBody Iterable<DB2Entity> getDB2DataMS1Method2() {
        LOG.info("Inside getDB2DataMethod2 of Microservice1");
        String baseUrl = "http://localhost:8081/getDB2DataMS2Method2";
        Iterable<DB2Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB2DataMethod2 of Microservice1 is: " + response.toString());
        return response;
    }

    @GetMapping(value = "/getDB3DataMS1Method3")
    public @ResponseBody Iterable<DB3Entity> getDB3DataMS1Method3() {
        LOG.info("Inside getDB3DataMethod3 of Microservice1");
        String baseUrl = "http://localhost:8082/getDB3DataMS3Method1";
        Iterable<DB3Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB3DataMethod3 of Microservice1 is: " + response.toString());
        return response;
    }
}
