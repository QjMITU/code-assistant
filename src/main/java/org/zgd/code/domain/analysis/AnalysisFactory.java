package org.zgd.code.domain.analysis;

import org.zgd.code.domain.base.PojoDateInfo;

/**
 * @author thesky
 * @date 2022/7/14 14:16
 */
public interface AnalysisFactory<T> {

    PojoDateInfo analysis(T t);

}
