package com.restful.webserver.tasklist.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webserver.tasklist.dao.TaskDAO;
import com.restful.webserver.tasklist.model.Task;

@RestController
// @CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskDAO taskDAO;

	@GetMapping("/listall")
	public List<Task> list() {
		return taskDAO.findAllByOrderByUpdatedatDesc();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		System.out.println(String.format("ID: %s", id));
		taskDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update")
	public ResponseEntity<Task> updateTodo(@RequestBody Task task) {
		task.setUpdatedat(LocalDateTime.now());
		taskDAO.save(task);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Task> save(@RequestBody Task task) {
		task.setCreatedat(LocalDateTime.now());
		task.setUpdatedat(LocalDateTime.now());
		task.setStatus(1);
		taskDAO.save(task);
		return ResponseEntity.ok().build();
	}

}
