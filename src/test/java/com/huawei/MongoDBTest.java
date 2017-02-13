package com.huawei;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huawei.domain.project.Project;
import com.huawei.domain.project.ProjectRepository;
import com.huawei.domain.scenario.Node;
import com.huawei.domain.scenario.NodeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MongoDBApplication.class)
public class MongoDBTest {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private NodeRepository nodeRepository;

	@Test
	public void test() {
		
		// 0.clear tables
		projectRepository.deleteAll();
		nodeRepository.deleteAll();
		
		// 1.DML-insert
		projectRepository.save(new Project("prj1", "zxc"));
		projectRepository.save(new Project("prj2", "liudehua"));
		projectRepository.save(new Project("prj3", "guofucheng"));
		projectRepository.save(new Project("prj4", "zhangxueyou"));
		projectRepository.save(new Project("prj5", "liming"));

		Assert.assertEquals(5, projectRepository.findAll().size());

		nodeRepository.save(new Node("PTN950", "Huawei"));
		nodeRepository.save(new Node("PTN960", "Cisco"));
		nodeRepository.save(new Node("PTN1900", "Juniper"));

		Assert.assertEquals(3, nodeRepository.findAll().size());

		// 2.DML-delete
		projectRepository.deleteByName("prj5");
		Assert.assertEquals(4, projectRepository.findAll().size());

		nodeRepository.deleteByName("PTN1900");
		Assert.assertEquals(2, nodeRepository.findAll().size());

		// 3.DML-select
		Project oPrj1 = projectRepository.findByName("prj1");
		Assert.assertEquals("zxc", oPrj1.getCreator());

		Node oNodePtn950 = nodeRepository.findByName("PTN950");
		Assert.assertEquals("Huawei", oNodePtn950.getVendor());

		// 4.DML-update
		Project oPrj4Update = projectRepository.findByName("prj1");
		oPrj4Update.setCreator("liangcaowei");
		projectRepository.save(oPrj4Update);

		Project oPrj4Check = projectRepository.findByName("prj1");
		Assert.assertEquals("liangcaowei", oPrj4Check.getCreator());

		Node oNode4Update = nodeRepository.findByName("PTN950");
		oNode4Update.setVendor("ALU");
		nodeRepository.save(oNode4Update);

		Node oNode4Check = nodeRepository.findByName("PTN950");
		Assert.assertEquals("ALU", oNode4Check.getVendor());
	}

}
