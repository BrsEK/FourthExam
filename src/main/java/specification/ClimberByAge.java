package specification;

import jpa.Climber;
import jpa.Climber_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClimberByAge implements Specification<Climber>{

    private int from;
    private int to;

    public ClimberByAge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Predicate getPredicate(Root<Climber> climberRoot, CriteriaBuilder builder) {
        return builder.and(builder.greaterThanOrEqualTo(climberRoot.get(Climber_.age), from),builder.lessThan(climberRoot.get(Climber_.age), to ));
    }
}
