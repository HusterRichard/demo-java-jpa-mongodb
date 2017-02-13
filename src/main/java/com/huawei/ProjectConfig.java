package com.huawei;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.huawei.domain.project", mongoTemplateRef = "projectMongoTemplate")
public class ProjectConfig {

	/**
	 * Configuration properties for Mongo.
	 * 
	 * @return
	 */
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.data.mongodb.project")
	public MongoProperties projectMongoProperties() {
		return new MongoProperties();
	}

	/**
	 * Class that specifies a basic set of MongoDB operations.<br>
	 * 
	 * @return
	 * @throws Exception
	 */
	@Primary
	@Bean(name = "projectMongoTemplate")
	public MongoTemplate projectMongoTemplate() throws Exception {
		MongoProperties mongoProperties = projectMongoProperties();
		MongoClient mongoClient = new MongoClient(mongoProperties.getHost(), mongoProperties.getPort());
		return new MongoTemplate(mongoClient, mongoProperties.getDatabase());
	}
}
