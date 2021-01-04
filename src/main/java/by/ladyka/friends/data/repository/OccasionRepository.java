package by.ladyka.friends.data.repository;


import by.ladyka.friends.data.entity.Occasion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OccasionRepository extends R2dbcRepository<Occasion, Long> {
}
