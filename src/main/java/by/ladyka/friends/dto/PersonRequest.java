package by.ladyka.friends.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonRequest {
    private String surname;
    private String name;
    private String fathername;
    private String phone;
    private LocalDate birthday;
}
