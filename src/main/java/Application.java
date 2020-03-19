import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Pets;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("Belorus");

        Employee employee = new Employee();
        employee.setFirstName("Maxim");
        employee.setLastName("Steponenko");
        employee.setAge(30);

        Pets pets = new Pets();
        pets.setName("Bobik");
        pets.setAge(13);

        Set<Pets> pets1 = new HashSet<>();
        pets1.add(pets);
        employee.setPets(pets1);

        session.save(address);
        session.save(employee);
        session.save(pets);

        session.getTransaction().commit();
        HibernateUtil.shutdowm();
    }
}
