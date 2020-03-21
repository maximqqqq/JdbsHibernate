package servise;

import bl.SessionUtil;
import dao.PetsDAO;
import entity.Employee;
import entity.Pets;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class PetsServise extends SessionUtil implements PetsDAO {
    @Override
    public void add(Pets pets) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(pets);

        closeTransactionSession();
    }

    @Override
    public List<Pets> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME PETS";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Pets.class);
        List<Pets> petsList = query.list();

        closeTransactionSession();

        return petsList;
    }

    @Override
    public Pets getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROME PETS WHERE ID= :id";

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Pets.class);
        query.setParameter("id",id);

        Pets pets = (Pets) query.getSingleResult();

        closeTransactionSession();

        return pets;
    }

    @Override
    public void update(Pets pets) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(pets);

        closeTransactionSession();
    }

    @Override
    public void delete(Pets pets) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(pets);

        closeTransactionSession();
    }
}
