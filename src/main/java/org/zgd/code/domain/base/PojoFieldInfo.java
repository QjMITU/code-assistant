package org.zgd.code.domain.base;

import lombok.Data;


/**
 * @author thesky
 * @date 2022/7/15 16:43
 */
@Data
public class PojoFieldInfo {

    private String fieldName;
    private Class<?> fieldType;
    private Integer columnWidth;
    private String excelProperty;


}
