package railroad.functional;

import railroad.Person;

import java.io.IOException;

public interface DBManager {
    Person updatePerson(Person person) throws IOException;
}
