# StudentCourseRegistration-SpringBoot-OracleDB

A Sample Spring Boot CRUD application which demonstrates features of Spring Boot and it's seamless integration with Oracle Database.
<br/>
<b>Project Structure : </b><a href="http://imgur.com/a/ihKuO" target="_blank">Click</a><br>
<b>View in browser : </b><a href="http://imgur.com/a/zsNz2" target="_blank">Click</a><br>
<b>IDE Used :</b> Intellij IDEA 2016.3<br/>
<b>Java Version Used :</b> 1.8<br/><br/>
<b>Dependencies (Maven) :</b><br/>
- JDBC
- Oracle
- Thymeleaf
- Web
- JPA

<b>Oracle DB integration :</b><br/>
- Driver version : 11.2.0.3<br/>
- Add Oracle JDBC driver in your local maven repository : 
<a href="https://www.mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository/">https://www.mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository/</a><br/>
- Add these lines within dependencies in pom.xml (maven) : <br/>
```
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>11.2.0.3</version>
        </dependency>
```
- Configure Oracle Database properties in application.properties : <br/>
```
#spring.datasource.url=jdbc:mysql://localhost:3306/springbootfirstapp
#spring.datasource.username=_YOUR_USERNAME
#spring.datasource.password=
#spring.datasource.driver-class-name=com.mysql.jdbc.Driver
#spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
#spring.jpa.hibernate.ddl-auto=update
#server.port=9080
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@10.21.20.108:1525:dnitstdb
spring.datasource.username=raijin
spring.datasource.password=raijin
spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect
spring.jpa.show-sql=true
server.port=8080
```
<b>Application URL :</b> <a href="http://localhost:8080/StudentApp/create/">http://localhost:8080/StudentApp/create/</a><br/><br/>
<b>pom.xml</b><br/>

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.priyam.spring</groupId>
	<artifactId>springoracledbcrud-demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>SpringOracleDBCRUD-Demo</name>
	<description>SpringOracleDBCRUD-Demo</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <!-- https://mvnrepository.com/artifact/oracle/ojdbc6 -->
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>11.2.0.3</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!--<dependency>-->
        <!--<groupId>mysql</groupId>-->
        <!--<artifactId>mysql-connector-java</artifactId>-->
        <!--<scope>runtime</scope>-->
        <!--</dependency>-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>


</project>

```


