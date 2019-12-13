package wkda.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import wkda.domain.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {
}
