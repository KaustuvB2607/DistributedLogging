package in.felinetechnologies.microservice2.Controller;



import in.felinetechnologies.microservice2.DAO.DB1Entity;
import in.felinetechnologies.microservice2.DAO.DB2Entity;
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

    @GetMapping(value = "/getDB1DataMS2Method1")
        public @ResponseBody Iterable<DB1Entity> getDB1DataMS2Method1() {
        LOG.info("Inside getDB1DataMethod1 of Microservice2");
        String baseUrl = "http://localhost:8083/getDB1DataMS4Method1";
        Iterable<DB1Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB1DataMethod1 of Microservice2 is: " + response.toString());
        return response;
    }

    @GetMapping(value = "/getDB2DataMS2Method2")
    public @ResponseBody Iterable<DB2Entity> getDB2DataMS2Method2() {
        LOG.info("Inside getDB2DataMethod2 of Microservice2");
        String baseUrl = "http://localhost:8084/getDB2DataMS5Method1";
        Iterable<DB2Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB2DataMethod2 of Microservice2 is: " + response.toString());
        return response;
    }
}
