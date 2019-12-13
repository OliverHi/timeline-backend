package wkda.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import wkda.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {}
