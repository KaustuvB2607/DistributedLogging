package in.felinetechnologies.microservice4.DAO.interfaces;

import in.felinetechnologies.microservice4.DAO.DB1Entity;
import org.springframework.data.repository.CrudRepository;

public interface DB1EntityRepository extends CrudRepository<DB1Entity, Integer> {
}
