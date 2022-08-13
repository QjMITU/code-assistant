package org.zgd.code.domain.handler;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.SystemProperty;
import org.zgd.code.utils.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author thesky
 * @date 2022/8/13 9:26
 */
public class InitHandler implements CreateHandler<PojoDateInfo>{
    @Override
    public void creat(PojoDateInfo info) {
        String basePath = info.getPackagePath().replace('.',File.separatorChar);
/*        creatDomainPackage(basePath);
        creatServicePackage(basePath);
        creatControllerPackage(basePath);*/
        creatBaseDtoEntity(info);
    }

    private boolean creatDomainPackage(String basePath){
        return FileUtils.createDir(basePath+ File.separator+"domain");
    }

    private boolean creatServicePackage(String basePath){
        return FileUtils.createDir(basePath+File.separator+"service"+File.separator+"impl");
    }

    private boolean creatControllerPackage(String basePath){
        return FileUtils.createDir(basePath+File.separator+"controller");
    }

    private void creatBaseDtoEntity(PojoDateInfo info){
        String path = "template/BaseDto";
        String data = FileUtils.readFile(path);
        data = data.replace("#{packagePath}",info.getPackagePath())
                .replace("#{auth}",info.getComment().getComment());
        String filePath = SystemProperty.javaPath+ File.separator+info.getEntityFullPath().replace(".", File.separator)+File.separator+"base"+File.separator+"BaseDto.java";
        FileUtils.writeFile(filePath,data.getBytes(StandardCharsets.UTF_8));
    }
}
