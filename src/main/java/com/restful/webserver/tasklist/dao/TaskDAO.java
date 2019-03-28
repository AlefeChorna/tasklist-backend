package com.restful.webserver.tasklist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webserver.tasklist.model.Task;

public interface TaskDAO extends JpaRepository<Task, Long> {
	
	public List<Task> findAllByOrderByUpdatedatDesc();

}