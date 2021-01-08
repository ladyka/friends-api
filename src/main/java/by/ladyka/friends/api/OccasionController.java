package by.ladyka.friends.api;

import by.ladyka.friends.data.entity.Occasion;
import by.ladyka.friends.data.repository.OccasionRepository;
import by.ladyka.friends.dto.OccasionRequest;
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
public class OccasionController {
    private final OccasionRepository occasionRepository;

    @GetMapping("/occasions")
    public Flux<Occasion> occasions() {
        return occasionRepository.findAll();
    }

    @GetMapping("/occasion/{id}")
    public Mono<Occasion> occasion(@PathVariable("id") Long id) {
        return occasionRepository.findById(id);
    }

    @PostMapping("/occasion")
    public Mono<Occasion> occasion(@RequestBody OccasionRequest request) {
        return Mono.just(request)
                .map(occasionRequest -> updateOccasion(occasionRequest, new Occasion()))
                .flatMap(occasionRepository::save);
    }

    @PutMapping("/occasion/{id}")
    public Mono<Occasion> occasion(@PathVariable("id") Long id, @RequestBody OccasionRequest dto) {
        return occasionRepository.findById(id)
                .map(occasion -> updateOccasion(dto, occasion))
                .flatMap(occasionRepository::save);
    }

    private Occasion updateOccasion(OccasionRequest dto, Occasion entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStart(dto.getStart());
        entity.setEnd(dto.getEnd());
        return entity;
    }
}
