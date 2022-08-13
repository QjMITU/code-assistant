package org.zgd.code.domain.handler;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.SystemProperty;
import org.zgd.code.utils.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author thesky
 * @date 2022/7/18 10:23
 */
public class ServiceImplCreateHandler implements CreateHandler<PojoDateInfo>{

    @Override
    public void creat(PojoDateInfo info) {
        String path = "template/ServiceImpl";
        String data = FileUtils.readFile(path);

        data = data.replace("#{packagePath}", info.getPackagePath())
                .replace("#{entityFullPath}",info.getEntityFullPath())
                .replace("#{interfaceFullPath}", info.getInterfaceFullPath())
                .replace("#{interfaceName}",info.getInterfaceName())
                .replace("#{auth}",info.getComment().getComment())
                .replace("#{indexName}",info.getIndexName())
                .replace("#{entityName}",info.getEntityName())
                .replace("#{methodGetId}",info.getMethodGetId());

        String implPath = info.getInterfaceFullPath()+".impl";
        String filePath = SystemProperty.javaPath+ File.separator+implPath.replace(".", File.separator)+File.separator+info.getInterfaceName()+"Impl.java";
        FileUtils.writeFile(filePath,data.getBytes(StandardCharsets.UTF_8));
    }
}
