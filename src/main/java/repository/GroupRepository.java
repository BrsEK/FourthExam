package repository;

import jpa.Group;
import specification.Specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class GroupRepository implements Repository<Group>{
    private EntityManager manager;

    public GroupRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Group> getBySpecification(Specification<Group> specification) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
            Root<Group> root = criteriaQuery.from(Group.class);
            Predicate condition = specification.getPredicate(root, builder);
            criteriaQuery.where(condition);
            return manager.createQuery(criteriaQuery).getResultList();
    }
}
