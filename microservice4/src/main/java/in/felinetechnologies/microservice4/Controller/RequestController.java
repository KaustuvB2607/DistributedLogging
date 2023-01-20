package in.felinetechnologies.microservice4.Controller;



import in.felinetechnologies.microservice4.DAO.DB1Entity;
import in.felinetechnologies.microservice4.DAO.interfaces.DB1EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DB1EntityRepository db1EntityRepository;


    @GetMapping(value = "/getDB1DataMS4Method1")
    public @ResponseBody Iterable<DB1Entity> getDB1DataMS4Method1() {
        LOG.info("Inside getDB1DataMethod1 of Microservice4");
        LOG.info("Sending response: Response from DB1 --> MS4 --> MS2 --> MS1");

        return db1EntityRepository.findAll();
    }
}
