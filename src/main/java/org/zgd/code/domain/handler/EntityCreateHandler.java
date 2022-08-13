package org.zgd.code.domain.handler;

import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.PojoFieldInfo;
import org.zgd.code.domain.base.SystemProperty;
import org.zgd.code.utils.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author thesky
 * @date 2022/7/18 11:37
 */
public class EntityCreateHandler implements CreateHandler<PojoDateInfo>{
    @Override
    public void creat(PojoDateInfo info) {
        PojoFieldInfo[] fieldInfos = info.getPojoFieldInfos();
        String path = "template/Entity";
        String data = FileUtils.readFile(path);
        StringBuilder builder = new StringBuilder();
        if (fieldInfos.length>0) {
            for (PojoFieldInfo fieldInfo : fieldInfos) {
                if (fieldInfo.getColumnWidth()!=null&&fieldInfo.getExcelProperty()!=null){
                    builder.append("\t@ColumnWidth(value = ").append(fieldInfo.getColumnWidth()).append(")\n")
                            .append("\t@ExcelProperty(\""+fieldInfo.getExcelProperty()+"\")\n");
                }
                builder.append("\tprivate "+fieldInfo.getFieldType().getSimpleName()+" "+fieldInfo.getFieldName()+";\n");
            }
        }
        data = data.replace("#{body}",builder.toString())
                .replace("#{auth}",info.getComment().getComment())
                .replace("#{packagePath}",info.getPackagePath())
                .replace("#{entityName}",info.getEntityName());
        String filePath = SystemProperty.javaPath+ File.separator+info.getEntityFullPath().replace('.',File.separatorChar)+File.separator+info.getEntityName()+"EntityDto.java";
        FileUtils.writeFile(filePath,data.getBytes(StandardCharsets.UTF_8));

    }


}
