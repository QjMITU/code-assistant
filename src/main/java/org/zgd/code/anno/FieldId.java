package org.zgd.code.anno;

import org.zgd.code.enums.EncodeTypeEnum;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FieldId {

    EncodeTypeEnum type() default EncodeTypeEnum.STRING;

}
