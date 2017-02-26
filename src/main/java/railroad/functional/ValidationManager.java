package railroad.functional;

import railroad.Person;
import railroad.RailroadException;

public interface ValidationManager {
    Person validate(Person person) throws RailroadException;
}
