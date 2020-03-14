## 社区demo
## 资料
[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[对标项目](https://elasticsearch.cn/explore)

[本项目开源路径](https://github.com/chuliming/demo)

[Bootstrap](https://www.bootcss.com/)

[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[OkHttp](https://square.github.io/okhttp/)

[Mvnrepository](https://mvnrepository.com/)

[fastjson](https://mvnrepository.com/artifact/com.alibaba/fastjson)

[h2database](http://www.h2database.com/html/main.html)

[h2database jar](https://mvnrepository.com/artifact/com.h2database/h2)

[mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[spring boot](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-connect-to-production-database)

[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)

[Spring Web on Servlet Stack](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html)

[mybatis spring boot autoconfigure](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[mybatis generator](https://mybatis.org/generator/index.html)
## 工具
[Git](https://git-scm.com/)

[Visual Paradigm](https://www.visual-paradigm.com/cn/download/community.jsp)

[flyway](https://flywaydb.org/getstarted/firststeps/maven)

[Lombok](https://projectlombok.org/setup/maven)

## 脚本
```sql
create table USER
(
  ID           int AUTO_INCREMENT primary key NOT NULL,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50),
  TOKEN        CHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```