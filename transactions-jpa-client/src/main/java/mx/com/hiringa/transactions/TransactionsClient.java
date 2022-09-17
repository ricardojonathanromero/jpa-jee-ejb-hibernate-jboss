package mx.com.hiringa.transactions;

import mx.com.hiringa.transactions.domain.Person;
import mx.com.hiringa.transactions.service.PersonServiceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class TransactionsClient {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            log.info("start main app()");
            Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL,"http-remoting://0.0.0.0:8080");
            jndiProps.put("jboss.naming.client.ejb.context", true);

            Context ctx = new InitialContext(jndiProps);
            PersonServiceRemote personServiceRemote = (PersonServiceRemote) ctx.lookup("ejb:/transactions-jpa-service/PersonServiceImpl!mx.com.hiringa.transactions.service.PersonServiceRemote");
            log.info("initializing test for transaction management for PersonService...");

            log.info("looking for person object...");
            Person person = personServiceRemote.FindPersonById(new Person(1));

            log.info("person_found: " + person);

            log.info("changing last_name field...");
            person.setLastName("Example");

            personServiceRemote.ModifyPerson(person);

            log.info("object modified: " + person);

            log.info("ends EJB transaction test");
        } catch (NamingException e) {
            log.error("error naming exception: " + e.getMessage());
        }
    }
}
