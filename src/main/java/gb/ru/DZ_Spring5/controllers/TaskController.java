package gb.ru.DZ_Spring5.controllers;

import gb.ru.DZ_Spring5.model.Status;
import gb.ru.DZ_Spring5.model.Task;

import gb.ru.DZ_Spring5.repository.TaskRepository;
import gb.ru.DZ_Spring5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/tasks")
@RestController
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setLdt(LocalDateTime.now());
        return (Task) taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
       return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatus(id,task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

    }

    @GetMapping("/status/{status}")
    public <TaskStatus> List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findByStatus((Status) status);
    }
}
