package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nazarov.shaheen.elib.mybatis.domain.Book;
import org.nazarov.shaheen.elib.mybatis.domain.Counter;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Mapper
public interface BookMapper {

    @Select(Constants.SELECT_BOOK_LIST)
    List<Book> list();
    @Select(Constants.SELECT_BOOK_LIST_LIMIT)
    List<Book> listWithLimit(int limit);
    @Select(Constants.SELECT_BOOK_LIST_DOWNLOAD)
    List<Book> listDownload(int limit);
    @Select(Constants.SELECT_BOOK_LIST_VIEW)
    List<Book> listView(int limit);

    @Select(Constants.SELECT_BOOK_BY_ID)
    Book getBook(int id);
}
