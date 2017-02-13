package com.huawei.domain.scenario;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NodeRepository extends MongoRepository<Node, String>{

	/**
	 * ������Ԫ���ƣ�������Ԫ���󣬻�NULL<br>
	 * @param name
	 * @return
	 */
	public Node findByName(String name);
	
	/**
	 * ������Ԫ���ƣ�ɾ����Ӧ��Ԫ����<br>
	 * 
	 * @param name
	 */
	public void deleteByName(String name);
}
