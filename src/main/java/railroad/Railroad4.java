package railroad;

import railroad.functional.ValidationManager;
import javaslang.control.Try;
import railroad.functional.DBManager;
import railroad.functional.NotificationManager;

public class Railroad4 {
    public Try<Person> process(
            PersonSupplier personSupplier,
            ValidationManager validationManager,
            DBManager dbManager,
            NotificationManager notificationManager
    ) {
        return Try.of(personSupplier::supplyPerson)
                .mapTry(validationManager::validate)
                .mapTry(dbManager::updatePerson)
                .mapTry(notificationManager::sendNotification)
                .onFailure(e -> System.out.println("Encountered an error: " + e.getMessage()));
    }

}
