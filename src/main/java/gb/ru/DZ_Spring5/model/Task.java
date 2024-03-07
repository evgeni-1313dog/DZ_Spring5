package gb.ru.DZ_Spring5.model;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column
    private String description;
    @Column(nullable = false)
    private Status status;
    @Column
    private LocalDateTime ldt;
}
