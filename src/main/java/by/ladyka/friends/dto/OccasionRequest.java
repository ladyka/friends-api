package by.ladyka.friends.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class OccasionRequest {
    private String name;
    private String description;
    private Instant start;
    private Instant end;
}
