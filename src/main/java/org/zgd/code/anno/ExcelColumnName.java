package org.zgd.code.anno;

import java.lang.annotation.*;

/**
 * @author thesky
 * @date 2022/8/13 9:02
 */
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumnName {

    String value() default "default";

}
