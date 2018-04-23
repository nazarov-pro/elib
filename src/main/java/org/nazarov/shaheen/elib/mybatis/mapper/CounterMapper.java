package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nazarov.shaheen.elib.mybatis.domain.Counter;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Mapper
public interface CounterMapper {

    @Select(Constants.SELECT_COUNTER_LIST)
    List<Counter> list();
    @Select(Constants.SELECT_COUNTER_BY_BOOK)
    Counter getByBookId(int id);

}
