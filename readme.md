# 目的 #
 
 通过Demo，演示jpa-MongoDB操纵NoSQL数据库（MongoDB）
	
# 基本操作 #

## 0.安装mongodb server ##
	https://www.mongodb.com/download-center#community

## 1.数据库定义DDL ##
### 1.1.自动生成DDL ###
	step1.在start.spring.io中生成一个支持spring-boot-starter-data-mongodb的demo；
	step2.在application.properties中配置数据库ip、port、database；
	step3.在xxxConfig.java中，配置ORM映射对应的domain model，配置MongoTemplate；
	step4.定义domain model，spring boot服务启动时，回扫描model，生成数据库的schema。

## 2.数据库操纵DML ##
	step1.每个domain model，都要定义一个dao接口xxxRepository,它从接口MongoRepository派生，
	且通过泛型与该domain model建立关联关系；
	step2.xxxRepository可以通过对象化操作来实现数据的增/删/查/改等。

# 多数据源&数据库连接 #

## 1.多数据源 ##
	step1.不同领域的模型，放在不同的package下；
	step2.每个数据源配置一个xxxConfig.java；
	step3.使用@Primary注解，定义有且仅有一个数据源为主数据源；
	step4.在confi.properties中配置多个数据库，使用前缀区分；
	step5.xxxConfig.java文件中，定义每个数据源ORM对应的模型的package名、数据库配置信息的前缀。

## 2.多数据库连接 ##
	似乎不用关注

# 事务 #
	ACID、事务性、回滚，需要充电

# 性能 #
	数据库的性能调优工具，需要持续去学习，加油

# 运维 #
	mongodb集群、主备倒换，不要气馁，未来你就是一个DBA，路还很长

# reference #
	http://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-mongodb
	http://bolg.withword.com/2015/07/02/spring-boot-mongodb多数据源配置/
	http://www.jincon.com/archives/95/
