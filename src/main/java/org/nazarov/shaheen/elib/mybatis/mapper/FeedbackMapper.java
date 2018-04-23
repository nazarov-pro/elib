package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.nazarov.shaheen.elib.mybatis.domain.Feedback;
import org.nazarov.shaheen.elib.mybatis.domain.User;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Mapper
public interface FeedbackMapper {

    @Insert(Constants.INSERT_FEEDBACK)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void save(Feedback feedback);

    @Update(Constants.UPDATE_FEEDBACK)
    void update(Feedback feedback);

    @Delete(Constants.DELETE_FEEDBACK)
    void delete(int id);

    @Select(Constants.SELECT_FEEDBACK_LIST)
    List<Feedback> list();

    @Select(Constants.SELECT_FEEDBACK_ID)
    Feedback getById(int id);

    @Select(Constants.SELECT_FEEDBACK_MESSAGE)
    List<Feedback> getByMessage(String message);

    @Select(Constants.SELECT_FEEDBACK_NAME)
    List<Feedback> getByName(String name);

    @Select(Constants.SELECT_FEEDBACK_EMAIL)
    List<Feedback> getByEmail(String email);
}
