package org.zgd.code.domain.handler;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.SystemProperty;
import org.zgd.code.utils.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author thesky
 * @date 2022/8/9 15:09
 */
public class ControllerCreateHandler implements CreateHandler<PojoDateInfo>{

    @Override
    public void creat(PojoDateInfo info) {

        String path = "template/Controller";
        String data = FileUtils.readFile(path);

        data = data.replace("#{packagePath}",info.getPackagePath())
                .replace("#{entityFullPath}",info.getEntityFullPath())
                .replace("#{entityName}",info.getEntityName())
                .replace("#{interfaceFullPath}",info.getInterfaceFullPath())
                .replace("#{interfaceName}",info.getInterfaceName())
                .replace("#{auth}",info.getComment().getComment())
                .replace("#{baseurl}",info.getEntityName())
                .replace("#{name}",info.getActualName());
        String filePath = SystemProperty.javaPath+ File.separator+info.getPackagePath().replace(".", File.separator)+File.separator+"controller"+File.separator+info.getEntityName()+"Controller.java";
        FileUtils.writeFile(filePath,data.getBytes(StandardCharsets.UTF_8));
    }
}
