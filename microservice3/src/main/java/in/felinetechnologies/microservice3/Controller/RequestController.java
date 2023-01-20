package in.felinetechnologies.microservice3.Controller;



import in.felinetechnologies.microservice3.DAO.DB3Entity;
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

    @GetMapping(value = "/getDB3DataMS3Method1")
    public @ResponseBody Iterable<DB3Entity> getDB3DataMS3Method1() {
        LOG.info("Inside getDB3DataMethod1 of Microservice3");
        String baseUrl = "http://localhost:8085/getDB3DataMS6Method1";
        Iterable<DB3Entity> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, Iterable.class).getBody();
        LOG.info("The response received by getDB3DataMethod1 of Microservice3 is: " + response.toString());
        return response;
    }
}
