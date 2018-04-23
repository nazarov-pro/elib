package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.nazarov.shaheen.elib.mybatis.domain.User;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

/**
 * Created by Shahin on 5/17/2017.
 */
@Mapper
public interface UserMapper {

    @Insert(Constants.INSERT_USER)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void save(User user);

    @Select(Constants.SELECT_USER_BY_EMAIL)
    User findUserByEmail(String email);
}
