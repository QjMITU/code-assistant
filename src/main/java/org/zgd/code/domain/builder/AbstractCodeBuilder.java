package org.zgd.code.domain.builder;

import org.zgd.code.domain.base.DocComment;
import org.zgd.code.enums.PatternEnum;


/**
 * @author thesky
 * @date 2022/7/15 11:02
 */
public abstract class AbstractCodeBuilder {
    public AbstractCodeBuilder(){}

    public String packagePath;

    public DocComment comment;

    public PatternEnum pattern;

    public abstract void building();

}
