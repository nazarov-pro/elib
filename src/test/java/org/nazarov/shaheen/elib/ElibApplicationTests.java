package org.nazarov.shaheen.elib;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nazarov.shaheen.elib.mybatis.mapper.BookMapper;
import org.nazarov.shaheen.elib.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElibApplicationTests {

	@Autowired
	private BookMapper bookMapper;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(bookMapper.listView(5));
	}

}
