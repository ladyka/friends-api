package by.ladyka.friends.api;

import by.ladyka.friends.data.entity.Occasion;
import by.ladyka.friends.data.entity.Person;
import by.ladyka.friends.data.repository.OccasionRepository;
import by.ladyka.friends.data.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class Endpoint {
    private final OccasionRepository occasionRepository;
    private final PersonRepository personRepository;

    @GetMapping("/occasions")
    public Flux<Occasion> occasions() {
        return occasionRepository.findAll();
    }

    @GetMapping("/persons")
    public Flux<Person> persons() {
        return personRepository.findAll();
    }

}

