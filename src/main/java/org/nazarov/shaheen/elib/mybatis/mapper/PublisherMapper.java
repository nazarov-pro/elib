package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nazarov.shaheen.elib.mybatis.domain.Book;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Mapper
public interface PublisherMapper {

    @Select(Constants.SELECT_PUBLISHER_LIST)
    List<Book> list();
}
