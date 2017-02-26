import railroad.imperative.RailroadImperativeUtils;
import org.junit.Test;
import railroad.Person;
import railroad.Railroad1;

public class Railroad1Test {
    @Test
    public void processMissingPerson() throws Exception {
        Person person = new Railroad1().process(
                () -> null,
                RailroadImperativeUtils::validatePerson,
                RailroadImperativeUtils::updatePerson,
                RailroadImperativeUtils::sendNotification
        );
        System.out.println("I have my person!");
    }

    @Test
    public void processMissingEmail() throws Exception {
        new Railroad1().process(
                Person::new,
                RailroadImperativeUtils::validatePerson,
                RailroadImperativeUtils::updatePerson,
                RailroadImperativeUtils::sendNotification
        );
    }

}