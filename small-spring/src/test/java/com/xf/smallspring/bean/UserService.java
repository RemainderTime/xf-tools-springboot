package com.xf.smallspring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: xf-tools-springboot
 * @ClassName User
 * @description:
 * @author: xiongfeng
 * @create: 2022-09-22 10:20
 **/
@Slf4j
@Service
public class UserService {

	public void getUserInfo(){
		log.error("构建用户bean对象成功啦");
	}
}
