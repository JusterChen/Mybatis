package v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 15:12
 */
public class MapperProxy implements InvocationHandler{

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(Configuration.TestMapperXml.namespace)){
            String sql = Configuration.TestMapperXml.map.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}
