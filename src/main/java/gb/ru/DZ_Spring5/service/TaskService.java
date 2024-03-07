package gb.ru.DZ_Spring5.service;

import gb.ru.DZ_Spring5.model.Status;
import gb.ru.DZ_Spring5.model.Task;
import gb.ru.DZ_Spring5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;


    public Task addTask(Task task) {
        return repository.save(task);
    }


    public List<Task> getAllTasks() {
        return repository.findAll();
    }


    public List<Task> findByStatus(Status status) {
        return repository.findByStatus(status);
    }


    public Task updateTaskStatus(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task1 = optionalTask.get();
            task1.setStatus(task.getStatus());
            return repository.save(task1);
        } else {
            throw new IllegalArgumentException("Task not found with id");
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}