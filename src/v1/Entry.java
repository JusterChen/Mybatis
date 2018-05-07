package v1;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 16:12
 */
public class Entry {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(),new SimpleExecutor());
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectById(13);
        System.out.println(test.toString());
    }
}
