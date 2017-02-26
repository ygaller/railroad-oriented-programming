package railroad.imperative;

import org.apache.commons.lang3.StringUtils;
import railroad.Person;

import java.io.IOError;
import java.net.ConnectException;
import java.net.UnknownHostException;

public class RailroadImperativeUtils {
    public static boolean validatePerson(Person person) {
        if (StringUtils.isEmpty(person.email)) {
            return false;
        }

        System.out.println("Validation was successful");
        return true;
    }

    public static boolean updatePerson(Person person) {
        double failProbability = Math.random();
        if (failProbability < 0.2) {
            throw new IOError(new ConnectException());
        }

        System.out.println("Update to DB was successful");
        return true;
    }

    public static boolean sendNotification(Person person) {
        double failProbability = Math.random();
        if (failProbability < 0.2) {
            throw new IOError(new UnknownHostException());
        }

        System.out.println("Notification was sent");
        return true;
    }
}
