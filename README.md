# Mybatis
1.Mapper在spring管理下其实是单例，为什么可以是一个 单例？ SCOPE -> application
mapper在mybatis里是一个Method级别的,当一次sqlSession结束之后,也就关闭了;在Spring管理下,变成了一个单列,让它一直存在,可以在该mapper的所有sqlSession使用,变成了一个application级别的
