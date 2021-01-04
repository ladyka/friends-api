package by.ladyka.friends.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Table(value = "persons")
public class Person extends Audit {
    @Id
    private Long id;
    private String surname;
    private String name;
    private String fathername;
    private String phone;
    private LocalDate birthday;
}
