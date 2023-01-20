package in.felinetechnologies.microservice5.Controller;



import in.felinetechnologies.microservice5.DAO.DB2Entity;
import in.felinetechnologies.microservice5.DAO.interfaces.DB2EntityRepository;
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
    DB2EntityRepository db2EntityRepository;

    @GetMapping(value = "/getDB2DataMS5Method1")
    public @ResponseBody Iterable<DB2Entity> getDB2DataMS5Method1() {
        LOG.info("Inside getDB2DataMethod1 of Microservice5");
        LOG.info("Sending response: Response from DB2 --> MS5 --> MS2 --> MS1");

        return db2EntityRepository.findAll();
    }
}
