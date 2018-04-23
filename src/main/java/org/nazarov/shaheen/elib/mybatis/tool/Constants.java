package org.nazarov.shaheen.elib.mybatis.tool;

/**
 * Created by Shahin on 5/18/2017.
 */
public interface Constants {

    String SELECT_BOOK_BY_ID = "select b.id,b.name,b.description,b.image,b.download,b.language,b.publisher_id as publisherId," +
            "b.page,b.status,b.date from books b where b.id=#{id}";

    String SELECT_BOOK_LIST = "select b.id,b.name,b.description,b.image,b.download,b.language,b.publisher_id as publisherId," +
            "b.page,b.status,b.date from books b where b.status='TRUE' order by b.date desc";

    String SELECT_BOOK_LIST_LIMIT = "select b.id,b.name,b.description,b.image,b.download,b.language,b.publisher_id as publisherId," +
            "b.page,b.status,b.date from books b where b.status='TRUE' order by b.date desc limit #{limit}";

    String SELECT_BOOK_LIST_DOWNLOAD = "select b.id,b.name,b.description,b.image,b.download,b.language," +
            "b.publisher_id as publisherId,b.page,b.status,b.date from books b inner join counter c on" +
            " c.id=b.id where b.status='TRUE' order by c.download desc, b.date desc limit #{limit}";

    String SELECT_BOOK_LIST_VIEW = "select b.id,b.name,b.description,b.image,b.download,b.language," +
            "b.publisher_id as publisherId,b.page,b.status,b.date from books b inner join counter c on" +
            " c.id=b.id where b.status='TRUE' order by c.view desc, b.date desc limit #{limit}";


    String SELECT_CATEGORY_LIST = "select c.id as id,c.name as name,c.category_id as categoryId from categories c";




    String SELECT_COUNTER_LIST = "select c.* from counter c";
    String SELECT_COUNTER_BY_BOOK = "select c.* from counter c where c.id=#{id}";


    //FeedBacks SQL
    String INSERT_FEEDBACK = "insert into elib.feedbacks(name,email,message,date) " +
            "values (#{name},#{email},#{message},#{date})";
    String UPDATE_FEEDBACK = "Update elib.feedbacks f set f.name=#{name},f.email=#{email}," +
            "f.message=#{message},f.date=#{date} where f.id=#{id}";
    String DELETE_FEEDBACK = "delete from elib.feedbacks f where f.id=#{id}";
    String SELECT_FEEDBACK_LIST = "Select f.* from feedbacks f order by f.date desc";
    String SELECT_FEEDBACK_ID = "Select f.* from feedbacks f where f.id=#{id}";
    String SELECT_FEEDBACK_MESSAGE = "Select f.* from feedbacks f where f.message like #{message}";
    String SELECT_FEEDBACK_NAME = "Select f.* from feedbacks f where f.name=#{name}";
    String SELECT_FEEDBACK_EMAIL = "Select f.* from feedbacks f where f.email=#{email}";

    String SELECT_PUBLISHER_LIST = "select p.* from publishers p";


    String INSERT_USER = "insert into elib.users(FULLNAME,EMAIL,PASSWORD,IMAGE,PHONE,ROLE,STATUS) " +
            "values (#{fullName},#{email},#{password},#{image},#{phone},#{role,typeHandler=org.apache.ibatis.type.EnumTypeHandler},#{status,typeHandler=org.apache.ibatis.type.EnumTypeHandler})";
    String SELECT_USER_BY_EMAIL = "Select u.* from elib.users u where u.email=#{email}";


}
