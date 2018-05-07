package v1;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 14:36
 */
public interface Executor {

    <T> T query(String statement, String parameter);
}
