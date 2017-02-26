package railroad;

import railroad.imperative.DBManager;
import railroad.imperative.NotificationManager;
import railroad.imperative.ValidationManager;

import java.util.function.Supplier;

public class Railroad2 {
    public Person process(
            Supplier<Person> personSupplier,
            ValidationManager validationManager,
            DBManager dbManager,
            NotificationManager notificationManager
    ) throws RailroadException {
        Person person = personSupplier.get();
        if (person == null) {
            return null;
        }

        boolean isValid = validationManager.validate(person);
        if (!isValid) {
            return null;
        }

        boolean isUpdated = dbManager.updatePerson(person);
        if (!isUpdated) {
            return null;
        }

        boolean isSent = notificationManager.sendNotification(person);
        if (!isSent) {
            return null;
        }

        return person;
    }

}
