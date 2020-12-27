package specification;

import jpa.Group;
import jpa.Group_;
import jpa.Mountain;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class GroupByNameOfMountain implements Specification<Group>{

    private Mountain mountain;

    public GroupByNameOfMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    @Override
    public Predicate getPredicate(Root<Group> groupRoot, CriteriaBuilder builder) {
        return builder.equal(groupRoot.get(Group_.mountain), mountain);
    }
}
