package com.ice;

import com.ice.mybatis.bean.User;
import com.ice.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {
	// 默认required=true,表示注入的时候bean必须存在，否则注入失败。
	@Autowired(required = false)
	UserMapper userMapper;

	@Test
	void contextLoads() {
		List<User> allUser = userMapper.getAllUser();
		System.out.println(allUser);
	}

}
