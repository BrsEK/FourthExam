package dao;

import jpa.Mountain;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MountainDao  implements Dao<Mountain, Integer>{
    private EntityManager manager;

    public MountainDao() {
    }

    public MountainDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Mountain mountain) {
        manager.persist(mountain);
    }

    @Override
    public void update(Mountain mountain) {
        manager.merge(mountain);
    }

    @Override
    public Mountain getByPK(Integer primaryKey) {
        return manager.find(Mountain.class, primaryKey);
    }

    @Override
    public void delete(Mountain mountain) {
        manager.remove(mountain);
    }

    @Override
    public void deleteByPK(Integer primaryKey) {
        Mountain mountain = getByPK(primaryKey);
        delete(mountain);
    }

    @Override
    public List<Mountain> getAll() {
        Query query = manager.createQuery("SELECT m FROM Mountain m");
        List<Mountain> mountains = (List<Mountain>) query.getResultList();
        return null;
    }

}
