package dao;

import jpa.Climber;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClimberDao implements Dao<Climber, Integer> {
    EntityManager manager;

    public ClimberDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Climber climber) {
        manager.persist(climber);
    }

    @Override
    public void update(Climber climber) {
        manager.merge(climber);
    }

    @Override
    public Climber getByPK(Integer primaryKey) {
        return manager.find(Climber.class, primaryKey);
    }

    @Override
    public void delete(Climber climber) {
        manager.remove(climber);
    }


    @Override
    public void deleteByPK(Integer primaryKey) {
        Climber climber = getByPK(primaryKey);
        delete(climber);
    }

    @Override
    public List<Climber> getAll() {
        Query query = manager.createQuery("SELECT c FROM Climber c");
        List<Climber> climbers = (List<Climber>) query.getResultList();
        return climbers;
    }

}
