package railroad.functional;

import railroad.Person;

import java.io.IOException;

public interface NotificationManager {
    Person sendNotification(Person person) throws IOException;
}
