package in.felinetechnologies.microservice6.Controller;



import in.felinetechnologies.microservice6.DAO.DB3Entity;
import in.felinetechnologies.microservice6.DAO.interfaces.DB3EntityRepository;
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
    DB3EntityRepository db3EntityRepository;

    @GetMapping(value = "/getDB3DataMS6Method1")
    public @ResponseBody Iterable<DB3Entity> getDB3DataMS6Method1() {
        LOG.info("Inside getDB3DataMethod1 of Microservice6");
        LOG.info("Sending response: Response from DB3 --> MS6 --> MS3 --> MS1");
        return db3EntityRepository.findAll();
    }
}
