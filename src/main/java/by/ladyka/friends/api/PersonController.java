package by.ladyka.friends.api;

import by.ladyka.friends.data.entity.Person;
import by.ladyka.friends.data.repository.PersonRepository;
import by.ladyka.friends.dto.PersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/persons")
    public Flux<Person> persons() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Mono<Person> person(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

    @PostMapping("/person")
    public Mono<Person> person(@RequestBody PersonRequest request) {
        return Mono.just(request)
                .map(personRequest -> updatePerson(personRequest, new Person()))
                .flatMap(personRepository::save);
    }

    @PutMapping("/person/{id}")
    public Mono<Person> person(@PathVariable("id") Long id, @RequestBody PersonRequest dto) {
        return personRepository.findById(id)
                .map(person -> updatePerson(dto, person))
                .flatMap(personRepository::save);
    }

    private Person updatePerson(PersonRequest dto, Person entity) {
        entity.setSurname(dto.getSurname());
        entity.setName(dto.getName());
        entity.setFathername(dto.getFathername());
        entity.setPhone(dto.getPhone());
        entity.setBirthday(dto.getBirthday());
        return entity;
    }
}
