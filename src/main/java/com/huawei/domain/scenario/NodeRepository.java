package com.huawei.domain.scenario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NodeRepository extends MongoRepository<Node, String>{

	/**
	 * 输入网元名称，返回网元对象，或NULL<br>
	 * @param name
	 * @return
	 */
	public Node findByName(String name);
	
	/**
	 * 输入网元名称，删除对应网元对象<br>
	 * 
	 * @param name
	 */
	public void deleteByName(String name);
}
