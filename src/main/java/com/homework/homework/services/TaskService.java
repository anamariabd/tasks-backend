package com.homework.homework.services;

import com.homework.homework.entities.Task;
import com.homework.homework.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task save(Task task);

    Task findById(long id);

    Task update(Task task);

    List<Task> findAll();

    boolean delete(long id);


}
