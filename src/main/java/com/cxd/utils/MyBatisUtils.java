package com.cxd.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {


    private static SqlSessionFactory factory = null;

    static {
        //需要和你项目中的文件名一样
        String config="mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if(factory!=null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }



}
