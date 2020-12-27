package specification;

import jpa.Mountain;
import jpa.Mountain_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MountainByCountry implements Specification<Mountain> {

    private  String country;

    public MountainByCountry(String country) {
        this.country = country;
    }

    @Override
    public Predicate getPredicate(Root<Mountain> mountainRoot, CriteriaBuilder builder) {
        return builder.equal(mountainRoot.get(Mountain_.country.getName()), country);
    }
}
