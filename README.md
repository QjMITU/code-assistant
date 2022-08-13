# code-assistant
> 代码助手 版本1.0 功能：用户提供基本的JavaBean，自动生成Elasticsearch相关的crud、excel导出、excel导入相关接口、包装类、service。
## 代码助手引入的第三方包如下：
```shell 
 slf4j-api 版本：1.7.36  
 elasticsearch-rest-high-level-client 版本：7.16.0，后续会升级到最新支持的Java Client8
 elasticsearch 版本：7.16.0
 logback-core 版本：1.2.11
 lombok 版本：1.18.24 
 hutool-all 版本：5.7.18
``` 
 ## 使用该助手生成代码，需要在项目中引入外部依赖如下：
 
```shell
  springspring-boot-starter-web
  easyexcel
```
