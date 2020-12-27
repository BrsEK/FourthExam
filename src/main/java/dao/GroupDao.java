package dao;

import jpa.Group;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class GroupDao implements Dao<Group, Integer> {
    private EntityManager manager;

    public GroupDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Group group) {
        manager.persist(group);
    }

    @Override
    public void update(Group group) {
        manager.merge(group);
    }

    @Override
    public Group getByPK(Integer primaryKey) {
        return manager.find(Group.class, primaryKey);
    }

    @Override
    public void delete(Group group) {
        manager.remove(group);
    }

    @Override
    public void deleteByPK(Integer primaryKey) {
        Group group = getByPK(primaryKey);
        delete(group);
    }

    @Override
    public List<Group> getAll() {
        Query query = manager.createQuery("SELECT g FROM Group g");
        List<Group> groups = (List<Group>) query.getResultList();
        return groups;
    }

}




