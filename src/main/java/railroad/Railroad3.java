package railroad;

import railroad.imperative.DBManager;
import railroad.imperative.NotificationManager;
import railroad.imperative.ValidationManager;

import java.util.function.Supplier;

public class Railroad3 {
    public Person process(
            Supplier<Person> personSupplier,
            ValidationManager validationManager,
            DBManager dbManager,
            NotificationManager notificationManager
    ) throws RailroadException {
        Person person = null;
        try {
            person = personSupplier.get();
            if (person == null) {
                throw new RailroadException("Supplied person was null");
            }
        } catch (Exception e) {
            throw new RailroadException("Unexpected error getting person", e);
        }

        try {
            boolean isValid = validationManager.validate(person);
            if (!isValid) {
                throw new RailroadException("railroad.Person is invalid");
            }
        } catch (Exception e) {
            throw new RailroadException("Unexpected error validating person", e);
        }

        try {
            boolean isUpdated = dbManager.updatePerson(person);
            if (!isUpdated) {
                throw new RailroadException("railroad.Person was not updated");
            }
        } catch (Exception e) {
            throw new RailroadException("Unexpected error updating person", e);
        }

        try {
            boolean isSent = notificationManager.sendNotification(person);
            if (!isSent) {
                throw new RailroadException("Notification was not sent");
            }
        } catch (Exception e) {
            throw new RailroadException("Unexpected error sending notification", e);
        }

        return person;
    }

}
