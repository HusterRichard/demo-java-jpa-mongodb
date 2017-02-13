package com.huawei;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.huawei.domain.scenario", mongoTemplateRef = "scenarioMongoTemplate")
public class ScenarioConfig {

	/**
	 * Configuration properties for Mongo.
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.data.mongodb.scenario")
	public MongoProperties scenarioMongoProperties() {
		return new MongoProperties();
	}

	/**
	 * Class that specifies a basic set of MongoDB operations.<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "scenarioMongoTemplate")
	public MongoTemplate scenarioMongoTemplate() throws Exception {
		MongoProperties mongoProperties = scenarioMongoProperties();
		MongoClient mongoClient = new MongoClient(mongoProperties.getHost(), mongoProperties.getPort());
		return new MongoTemplate(mongoClient, mongoProperties.getDatabase());
	}
}
