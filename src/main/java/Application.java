import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Pets;
import servise.AddresServise;
import servise.EmployeeServise;
import servise.PetsServise;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws SQLException {
        AddresServise addresServise = new AddresServise();
        EmployeeServise employeeServise = new EmployeeServise();
        PetsServise petsServise = new PetsServise();


        Address address = new Address();
        address.setCity("Gomel");
        address.setCountry("Belorus");

        Employee employee = new Employee();
        employee.setFirstName("Vasa");
        employee.setLastName("Pupkin");
        employee.setAge(35);
        employee.setAddress(address);

        Pets pets = new Pets();
        pets.setName("Tuzik");
        pets.setAge(9);
        pets.setEmployee(employee);

        Set<Pets> pets1 = new HashSet<>();
        pets1.add(pets);
        employee.setPets(pets1);
//add
//        try {
//            addresServise.add(address);
//            employeeServise.add(employee);
//            petsServise.add(pets);
//        }catch (SQLException e){
//            System.err.println("ERRORE "+e);
//            e.printStackTrace();
//        }

        //get
        Address a = addresServise.getById(1L);
        System.out.println(a);

            HibernateUtil.shutdowm();
        }
    }
