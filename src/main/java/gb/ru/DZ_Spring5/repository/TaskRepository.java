package gb.ru.DZ_Spring5.repository;

import gb.ru.DZ_Spring5.model.Status;
import gb.ru.DZ_Spring5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);


}
