package org.zgd.code.domain.base;

import lombok.Data;

/**
 * @author thesky
 * @date 2022/7/14 14:19
 */
@Data
public class PojoDateInfo {

    private String packagePath;     //基本包名

    private String entityFullPath;      //实体类包路径

    private String entityName;      //实体类名

    private String actualName;      //类实际意义名

    private String indexName = "name";       //ES索引名


    private String interfaceFullPath;       //实体类对应service接口包路径，packagePath+service，实现类包路径：packagePath+service+impl

    private String interfaceName;       //实体类对应service接口名  entityName+Service，实现类类名：entityName+Dto+ServiceImpl

    private String methodGetId;     //Es文档id获取方法，为null则由es自动分配

    private DocComment comment;     //文档注解模板

    private PojoFieldInfo[] pojoFieldInfos;     //类属性信息


}
