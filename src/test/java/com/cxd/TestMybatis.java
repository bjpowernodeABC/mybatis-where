package com.cxd;

import com.cxd.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void TestInsert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始(target/classes)
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5[重要]获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6[重要]指定要执行的SQL语句的标识。SQL映射文件中的 namespace+ "." + 标签的id值
        String sqlId = "com.cxd.dao.StudentDao"+"."+"insertStudent";
        //7执行SQL语句，通过SQLID找到语句
        Student student = new Student();
        student.setId(1005);
        student.setName("王五");
        student.setEmail("123456@136.com");
        student.setAge(39);
        int ret = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，所以在insert,update,delete后要手工提交事务。
        sqlSession.commit();
        //关闭连接
        sqlSession.close();
        Assert.assertEquals(1,ret);
        //8输出结果
//        System.out.println(ret ==1?"插入成功":"插入失败");
        //9关闭SqlSession对象
//        sqlSession.close();
    }
}
