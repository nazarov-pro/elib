package org.nazarov.shaheen.elib.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.nazarov.shaheen.elib.mybatis.domain.Category;
import org.nazarov.shaheen.elib.mybatis.tool.Constants;

import java.util.List;

/**
 * Created by Shahin on 5/18/2017.
 */
@Mapper
public interface CategoryMapper {

    @Select(Constants.SELECT_CATEGORY_LIST)
    List<Category> list();
}
