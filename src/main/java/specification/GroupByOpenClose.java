package specification;

import jpa.Group;
import jpa.Group_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GroupByOpenClose implements Specification<Group> {

    private boolean isRecruiting;

    public GroupByOpenClose(boolean isRecruiting) {
        this.isRecruiting = isRecruiting;
    }

    @Override
    public Predicate getPredicate(Root<Group> groupRoot, CriteriaBuilder builder) {
        return builder.equal(groupRoot.get(Group_.isRecruiting), isRecruiting);
    }
}
