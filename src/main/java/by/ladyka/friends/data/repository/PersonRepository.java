package by.ladyka.friends.data.repository;

import by.ladyka.friends.data.entity.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
