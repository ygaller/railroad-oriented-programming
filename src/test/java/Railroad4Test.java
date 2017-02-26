import javaslang.control.Try;
import org.junit.Test;
import railroad.Person;
import railroad.Railroad4;
import railroad.functional.RailroadFunctionalUtils;

public class Railroad4Test {
    @Test
    public void process() {
        Railroad4 railroad4 = new Railroad4();
        for (int i = 0 ; i < 10 ; i++) {
            Try<Person> person = railroad4.process(
                    this::supplyPerson,
                    RailroadFunctionalUtils::validate,
                    RailroadFunctionalUtils::updatePerson,
                    RailroadFunctionalUtils::sendNotification
            );

            person.andThen(p -> System.out.println("railroad.Person was processed\n"))
                    .orElseRun(e -> System.out.println("railroad.Person failed on processing:\n" + e + "\n"));
        }
    }

    private Person supplyPerson() {
        double failProbability = Math.random();
        if (failProbability < 0.2) {
            throw new NullPointerException("Error when creating person");
        }

        return new Person() {{
            if (failProbability > 0.4) {
                this.email = "howdy@doody.com";
            }
        }};
    }

}