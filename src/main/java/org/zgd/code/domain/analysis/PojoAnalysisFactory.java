package org.zgd.code.domain.analysis;

import org.zgd.code.anno.ExcelColumnName;
import org.zgd.code.anno.ExcelColumnWidth;
import org.zgd.code.anno.FieldId;
import org.zgd.code.anno.TableName;
import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.domain.base.PojoFieldInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author thesky
 * @date 2022/7/14 14:19
 */
public class PojoAnalysisFactory implements AnalysisFactory<Class> {

    /**
     * 将实体类数据转包装对象
     * @param entity 实体类字节对象
     * @return 解析包装对象
     */
    @Override
    public PojoDateInfo analysis(Class entity) {
        PojoDateInfo info = new PojoDateInfo();
        info.setEntityName(entity.getSimpleName());
        if (entity.isAnnotationPresent(TableName.class)){
            TableName annotation =(TableName) entity.getAnnotation(TableName.class);
            info.setActualName(annotation.value());
        }
        analysisClassField(entity,info);
        return info;
    }

    //解析属性
    private void analysisClassField(Class entity,PojoDateInfo info){
        ArrayList<PojoFieldInfo> fieldInfos = new ArrayList<>();
        Field[] fields = entity.getDeclaredFields();
        if (fields.length>0) {
            for (Field field : fields) {
                PojoFieldInfo fieldInfo = new PojoFieldInfo();
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();
                fieldInfo.setFieldName(fieldName);
                fieldInfo.setFieldType(fieldType);
                //处理属性上的注解
                if (field.isAnnotationPresent(FieldId.class)) {
                    info.setMethodGetId("get"+fieldName.replace(fieldName.charAt(0),Character.toUpperCase(fieldName.charAt(0)))+"()");
                }
                if (field.isAnnotationPresent(ExcelColumnWidth.class)){
                    ExcelColumnWidth annotation = field.getAnnotation(ExcelColumnWidth.class);
                    fieldInfo.setColumnWidth(Integer.valueOf(annotation.value()));
                }
                if (field.isAnnotationPresent(ExcelColumnName.class)){
                    ExcelColumnName annotation = field.getAnnotation(ExcelColumnName.class);
                    fieldInfo.setExcelProperty(annotation.value());
                }
                fieldInfos.add(fieldInfo);
            }
            info.setPojoFieldInfos(fieldInfos.toArray(new PojoFieldInfo[]{}));
        }
    }

}
