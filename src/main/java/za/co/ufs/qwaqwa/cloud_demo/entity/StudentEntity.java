package za.co.ufs.qwaqwa.cloud_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = "students")
@EqualsAndHashCode(callSuper = true)
public class StudentEntity extends AbstractEntity {
    private String name;
    private String email;
    private Integer age;
}
