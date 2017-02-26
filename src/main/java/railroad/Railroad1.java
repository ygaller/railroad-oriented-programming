package railroad;

import railroad.imperative.DBManager;
import railroad.imperative.NotificationManager;
import railroad.imperative.ValidationManager;

import java.util.function.Supplier;

public class Railroad1 {
    public Person process(
            Supplier<Person> personSupplier,
            ValidationManager validationManager,
            DBManager dbManager,
            NotificationManager notificationManager
    ) {
        Person person = personSupplier.get();
        validationManager.validate(person);
        dbManager.updatePerson(person);
        notificationManager.sendNotification(person);
        return person;
    }

}
