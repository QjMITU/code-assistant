package org.zgd.code.domain.handler;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.SystemProperty;
import org.zgd.code.utils.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;


/**
 * @author thesky
 * @date 2022/7/14 14:35
 */
public class ServiceCreateHandler implements CreateHandler<PojoDateInfo> {

    @Override
    public void creat(PojoDateInfo pojoDateInfo){
        String path = "template/Service";
        String data = FileUtils.readFile(path);
        //替换模板
        data = data.replace("#{entityFullPath}",pojoDateInfo.getEntityFullPath())
                .replace("#{entityName}",pojoDateInfo.getEntityName())
                .replace("#{auth}",pojoDateInfo.getComment().getComment());
        //更新接口属性
        pojoDateInfo.setInterfaceName(pojoDateInfo.getEntityName()+"Service");
        String interfacePackage = pojoDateInfo.getPackagePath()+".service";
        pojoDateInfo.setInterfaceFullPath(interfacePackage);
        data = data.replace("#{interfaceFullPath}",pojoDateInfo.getInterfaceFullPath());
        //写入java文件
        String filePath = SystemProperty.javaPath+File.separator+interfacePackage.replace(".", File.separator)+File.separator+pojoDateInfo.getInterfaceName()+".java";
        FileUtils.writeFile(filePath,data.getBytes(StandardCharsets.UTF_8));
    }


}
