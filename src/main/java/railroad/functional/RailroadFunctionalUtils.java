package railroad.functional;

import org.apache.commons.lang3.StringUtils;
import railroad.Person;
import railroad.RailroadException;
import railroad.ValidPerson;

import java.io.IOError;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class RailroadFunctionalUtils {
    public static ValidPerson validate(Person person) throws RailroadException {
        if (StringUtils.isEmpty(person.email)) {
            throw new RailroadException("railroad.Person failed validation");
        }

        System.out.println("Validation was successful");
        return new ValidPerson(person);
    }

    public static Person updatePerson(Person person) throws IOException {
        double failProbability = Math.random();
        if (failProbability < 0.2) {
            throw new ConnectException();
        }

        System.out.println("Update to DB was successful");
        return person;
    }

    public static Person sendNotification(Person person) throws IOException {
        double failProbability = Math.random();
        if (failProbability < 0.2) {
            throw new UnknownHostException();
        }

        System.out.println("Notification was sent");
        return person;
    }
}
