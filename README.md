# Mybatis
1.Mapper在spring管理下其实是单例，为什么可以是一个 单例？ SCOPE -> application

mapper在mybatis里是一个Method级别的,当一次sqlSession结束之后,也就关闭了;在Spring管理下,变成了一个单列,让它一直存在,可以在该mapper的所有sqlSession使用,变成了一个application级别的

2.MyBatis在Spring集成下没有mapper的xml文件会不会报错,为什么？
不会,可以用注解的方式annotation

3.TypeHandler手写
4.手写Plugin,多个interceptor到底谁先执行？顺序由谁 决定的？

后注册的先执行,然后通过for循环遍历一一取出来,与MapperProxy代理有关，倒序

5.怎么验证一级缓存的存在？

对于某个查询,去缓存Cache中取出对应的的缓存结果,如果命中,取出结果值,没有就去查询数据库,可以在给某个查询设置查询时间,观察时间进行对比

6.验证N+1问题

2表关联学生表与班级表,进行嵌套查询,开启懒加载,当只需要查询班级信息,就取班级信息,就是1,当取学生信息时就是N,一个班级对应多个学生,减轻数据库的压力
