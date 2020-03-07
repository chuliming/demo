package vip.xming.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import vip.xming.demo.model.User;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER (NAME,ACCOUNT_ID,TOKEN,GMT_CREATE,GMT_MODIFIED) VALUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("SELECT * FROM USER WHERE TOKEN = #{token}")
    User findByToken(@Param("token") String token);
}
