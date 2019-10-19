package pl.coderslab.app.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.common.GenericDao;

@Repository
public class PersonDao extends GenericDao<Person> {

    public PersonDao() {
        super(Person.class);
    }
}
