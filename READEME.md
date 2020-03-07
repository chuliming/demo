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

[flywaydb](https://flywaydb.org/getstarted/firststeps/maven)

## 工具
[Git](https://git-scm.com/)

[Visual Paradigm](https://www.visual-paradigm.com/cn/download/community.jsp)

## 脚本
```sql
create table USER
(
  ID           INTEGER default NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_C3B3085E_D211_40FF_8C81_D8419A208BE7"
    primary key,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50),
  TOKEN        CHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT
);
```