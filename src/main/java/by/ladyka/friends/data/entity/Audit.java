package by.ladyka.friends.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Getter
@Setter
public class Audit {
    @CreatedBy
    @Column(value = "created_by")
    private String createdBy;
    @CreatedDate
    @Column(value = "created_date")
    private Instant createdDate;
    @LastModifiedBy
    @Column(value = "last_modified_by")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(value = "last_modified_date")
    private Instant lastModifiedDate;
    @Version
    @Column(value = "version")
    private Long version;
}
