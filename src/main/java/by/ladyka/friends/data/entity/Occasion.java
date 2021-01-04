package by.ladyka.friends.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@Table(value = "occasions")
public class Occasion extends Audit {
    @Id
    private Long id;
    private String name;
    private String description;
    private Instant start;
    private Instant end;

}
