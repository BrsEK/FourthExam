package repository;

import specification.Specification;

import java.util.List;

public interface Repository <T> {
    List<T> getBySpecification(Specification<T> specification);
}
