package com.cxd;

import com.cxd.domain.Student;
import com.cxd.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {

        new Thread(()->{
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            //6[重要]指定要执行的SQL语句的标识。SQL映射文件中的 namespace+ "." + 标签的id值
            String sqlId = "com.cxd.dao.StudentDao"+"."+"selectStudents";
            //7执行SQL语句，通过SQLID找到语句
            List<Student> studentList = sqlSession.selectList(sqlId);
            //8输出结果
            studentList.forEach(stu-> System.out.println(stu));
            //9关闭SqlSession对象
            sqlSession.close();
        }).start();
        System.out.println("==============");
        new Thread(()->{
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            //6[重要]指定要执行的SQL语句的标识。SQL映射文件中的 namespace+ "." + 标签的id值
            String sqlId = "com.cxd.dao.StudentDao"+"."+"selectStudents";
            //7执行SQL语句，通过SQLID找到语句
            List<Student> studentList = sqlSession.selectList(sqlId);
            //8输出结果
            studentList.forEach(stu-> System.out.println(stu));
            //9关闭SqlSession对象
            sqlSession.close();
        }).start();
    }
}
