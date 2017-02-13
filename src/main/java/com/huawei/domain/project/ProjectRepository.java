package com.huawei.domain.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

	/**
	 * 输入工程名，返回工程对象<br>
	 * 
	 * @param name
	 * @return
	 */
	public Project findByName(String name);

	/**
	 * 输入工程名，删除指定的工程<br>
	 * 
	 * @param name
	 */
	public void deleteByName(String name);
}
