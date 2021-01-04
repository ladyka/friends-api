package by.ladyka.friends.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(value = "occasions_has_persons")
public class RelationOccasionPerson extends Audit {
    @Id
    private Long personId;
    @Id
    private Long occasionId;
}
