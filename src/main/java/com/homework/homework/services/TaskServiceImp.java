package com.homework.homework.services;

import com.homework.homework.entities.Task;
import com.homework.homework.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    static Logger log = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Task update(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public boolean delete(long id) throws RuntimeException{
        Task taskDelete = this.findById(id);

        if(taskDelete == null){
            return false;
        }

        taskRepository.delete(taskDelete);

        return true;
    }

}
