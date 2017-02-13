package com.huawei.domain.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

	/**
	 * ���빤���������ع��̶���<br>
	 * 
	 * @param name
	 * @return
	 */
	public Project findByName(String name);

	/**
	 * ���빤������ɾ��ָ���Ĺ���<br>
	 * 
	 * @param name
	 */
	public void deleteByName(String name);
}
