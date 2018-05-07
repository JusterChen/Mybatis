package v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static v1.Configuration.TestMapperXml.map;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 14:36
 */
public class Configuration {

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},new MapperProxy(sqlSession));
    }

    static class TestMapperXml{
        public static final String namespace = "v1.TestMapper";
        public static final Map<String,String> map = new HashMap<>();
    }

    static {
        map.put("selectById","select * from user where id=%d");
    }
}
