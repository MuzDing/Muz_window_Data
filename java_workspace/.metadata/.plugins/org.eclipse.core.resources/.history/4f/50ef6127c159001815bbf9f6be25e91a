package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.muz.bean.User;

public class TestSpring {
	@Test
	public void fun() {
		//创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//让容器常见user 对象
		User u = (User)ac.getBean("user");
		//打印user对象
		System.out.println(u);
	}
	@Test
	public void fun2() {
		//创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//让容器常见user 对象
		User u = (User)ac.getBean("user2");
		//打印user对象
		System.out.println(u);
	}
	@Test
	public void fun3() {
		//创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//让容器常见user 对象
		User u = (User)ac.getBean("user3");
		//打印user对象
		System.out.println(u);
	}
	
}
