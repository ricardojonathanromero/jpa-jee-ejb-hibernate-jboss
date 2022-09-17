package mx.com.hiringa.transactions.web;

import mx.com.hiringa.transactions.domain.Person;
import mx.com.hiringa.transactions.service.PersonService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "people", value = "/people")
public class PersonServlet extends HttpServlet {
    @Inject
    PersonService personService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> people = personService.ListPersons();
        System.out.println("---------------------------------");
        System.out.println("people: " + people.toString() + " -- end");
        System.out.println("---------------------------------");
        request.setAttribute("people", people);
        request.getRequestDispatcher("/people.jsp").forward(request, response);
    }
}
