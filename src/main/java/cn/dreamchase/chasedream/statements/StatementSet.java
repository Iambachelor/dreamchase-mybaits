package cn.dreamchase.chasedream.statements;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.dreamchase.chasedream.pojos.Person;

/**
 * MyBatis入门 
 * 1.创建mybatis-config.xml \n 
 * 2.配置mysql数据库驱动 \r\n 
 * 	2.1. 配置如mybatis-config.xml 文件 \n 
 * 3.使用statement id
 * 
 * 关注点：
 * 	如mapper.xml文件
 * 
 * @author MENGDEFANG
 *
 */
public class StatementSet {

	private static SqlSessionFactory factory;

	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询单条记录
	 * -没有查询条件
	 * 
	 * 错误：
	 * 	### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for 
	 * 		cn.dreamchase.chasedream.statements.chasedream.selectPersonSigleNoCase
	 * 

	 */
	public void selectPersonSigleNoCase() {
		SqlSession session = factory.openSession();
		if (session != null) {
			Person person = session.selectOne("chasedream.selectPersonSigleNoCase");
			System.out.println(person);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 * 查询单条记录
	 * -存在查询条件
	 */
	public void selectPersonSigleExistsCase() {
		SqlSession session = factory.openSession();
		if (session != null) {
			Person person = session.selectOne("chasedream.selectPersonSigleExistsCase","2");
			System.out.println(person);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 * 查询多条记录
	 * -返回List
	 * -没有传递参数
	 */
	public void selectPersonsNoCase() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List<Person> persons = session.selectList("chasedream.selectPersonsReturnListNoCase");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回List
	 * -指定参数
	 */
	public void selectPersonsExistsCase() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List<Person> persons = session.selectList("chasedream.selectPersonsReturnListExistsCase","25");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	

	/**
	 *
	 * 查询多条记录
	 * -返回List
	 * -指定参数
	 * 异常：java.lang.UnsupportedOperationException
	 */
	public void selectPersonsNoCaseNotFanXing() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List persons = session.selectList("chasedream.selectPersonsReturnListNoCaseNotFanXing","25");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	
	/**
	 *
	 * 查询多条记录
	 * -返回List
	 * -指定参数
	 */
	public void selectPersonsReturnListFanXingIsMap() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List<Map<String, Object>> persons = session.selectList("chasedream.selectPersonsReturnListFanXingIsMap","25");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回List
	 * -指定参数
	 * 异常：java.lang.UnsupportedOperationException
	 */
	public void selectPersonsReturnListFanXingIsList() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List<List> persons = session.selectList("chasedream.selectPersonsReturnListFanXingIsList","25");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回List
	 * -指定参数
	 * 异常：java.lang.UnsupportedOperationException
	 */
	public void selectPersonsReturnListFanXingIsListInFX() {
		SqlSession session = factory.openSession();
		if (session != null) {
			List<List<Person>> persons = session.selectList("chasedream.selectPersonsReturnListFanXingIsListInFX","25");
			System.out.println(persons);
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回Map
	 * -指定参数
	 * selectMap(String statement,String mapKey)
	 * mapKey: 1.取决于返回Map的key是什么类型的值
	 * 		   2.必须取返回结果中的某个字段
	
	 */
	public void selectPersonsReturnMap() {
		SqlSession session = factory.openSession();
		if (session != null) {
			Map<Object, Object> map = session.selectMap("chasedream.selectPersonsReturnMap","id");
			
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				System.out.println("key：" + entry.getKey() + "value：" + entry.getValue());
			}
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	
	/**
	 *
	 * 查询多条记录
	 * -返回Map
	 * -指定参数
	 * selectMap(String statement,String mapKey)
	 * mapKey: 1.取决于返回Map的key是什么类型的值
	 * 		   2.必须取返回结果中的某个字段
	
	 */
	public void selectPersonsReturnEntityAcceptIsMap() {
		SqlSession session = factory.openSession();
		if (session != null) {
			Map<Object, Object> map = session.selectMap("chasedream.selectPersonsReturnEntityAcceptIsMap","name");
			
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				System.out.println("key：" + entry.getKey() + ",value：" + entry.getValue());
			}
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回Map
	 * -指定参数
	 * 异常：java.lang.UnsupportedOperationException
	
	 */
	public void selectPersonsReturnListAcceptIsMap() {
		SqlSession session = factory.openSession();
		if (session != null) {
			Map<Object, Object> map = session.selectMap("chasedream.selectPersonsReturnListAcceptIsMap","name");
			
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				System.out.println("key：" + entry.getKey() + ",value：" + entry.getValue());
			}
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
	/**
	 *
	 * 查询多条记录
	 * -返回Map
	 * -指定参数
	 * selectMap(String statement,String mapKey)
	 * mapKey: 1.取决于返回Map的key是什么类型的值
	 * 		   2.必须取返回结果中的某个字段
	
	 */
	public void selectPersonsReturnListFXIsEntityAcceptIsMap() {
		System.out.println("***************************");
		SqlSession session = factory.openSession();
		if (session != null) {
			Map<Object, Object> map = session.selectMap("chasedream.selectPersonsReturnListFXIsEntityAcceptIsMap","name");
			
			for (Map.Entry<Object, Object> entry : map.entrySet()) {
				System.out.println("key：" + entry.getKey() + ",value：" + entry.getValue());
			}
			try {
				session.close();
			} catch (Exception e) {
				System.out.println("关闭失败!");
			}
		}
	}
	
}
