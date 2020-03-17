#这是一个 spring-boot-graphql simple demo

基于:

- spring-boot 2.0.0
- graphql-spring-boot-starter 4.0.0
- graphql-java-tools 4.3.0

run server:
    
    ./run.sh

graphql default endpoint: /graphql

    http://127.0.0.1:10001/graphql
    
exmple:
    
    request:
    
    {
      findAllBooks {
        id
        title
      }
    }
       
    response:
    
    {
      "data": {
        "findAllBooks": [
          {
            "id": 1,
            "title": "SUN"
          },
          {
            "id": 2,
            "title": "SUN1"
          },
          {
            "id": 3,
            "title": "SUN3"
          },
          {
            "id": 4,
            "title": "java"
          }
        ]
      }
    }

graphql 图形工具ui:<br>
    [An in-browser IDE for exploring GraphQL](https://github.com/graphql/graphiql)<br>
    [An App GraphQL](https://github.com/skevy/graphiql-app)

测试结果:

    - schema 的名字 和 model 的名字没有必然关系 Author.class > AuthorAaa.class 程序正常
    - schema Author 同时有 test.model.Author.class、test.entity.Author.class 程序正常
猜测(未看源码,仅供参考):

    query/mutation 做为入口, 解析也应该是从这里开始, query <=> QueryResolver.class 是对应的, 返回值得class会绑定到schema,同时schema的赋值 先找有没有对应的Resolver<T>.class的getXxx()/xxx(), 其次啊是class的this.getXxx()/xxx(), 若是都找不到程序启动异常, 也就是说 schema中的'每一个字段都必须有对应的处理方法' 无论是Resolver, 还是对应的class提供的方法都可以

    