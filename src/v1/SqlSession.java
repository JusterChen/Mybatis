package v1;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 14:37
 */
public class SqlSession {

    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T  getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }

    public <T> T selectOne(String statement, String parameter){
        return executor.query(statement, parameter);
    }
}
