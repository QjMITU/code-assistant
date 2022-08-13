package org.zgd.code.domain.builder;

import org.zgd.code.domain.analysis.PojoAnalysisFactory;
import org.zgd.code.domain.pipeline.TemplateHandlerPipeline;
import org.zgd.code.domain.base.DocComment;
import org.zgd.code.domain.base.PojoDateInfo;
import org.zgd.code.enums.PatternEnum;
import org.zgd.code.utils.ClassUtils;

import java.util.Iterator;
import java.util.Set;


/**
 * @author thesky
 * @date 2022/7/15 11:05
 */
public class EsCodeBuilder extends AbstractCodeBuilder {
    private EsCodeBuilder(){}

    public String entityFullPath;

    @Override
    public void building() {

        Set<Class<?>> classSet = ClassUtils.addClassToSet(entityFullPath);      //获得所有实体类字节对象
        //解析对象
        if (classSet.size()!=0){
            Iterator<Class<?>> classIterator = classSet.iterator();
            while (classIterator.hasNext()){
                //获取解析对象
                PojoDateInfo info = analysis(classIterator.next());
                intoPipline(info);
            }
        }
    }

    public static class CodeBuilder{

        public static EsCodeBuilder esCodeBuilder = new EsCodeBuilder();

        public CodeBuilder packagePath(String packagePath){
            esCodeBuilder.packagePath = packagePath;
            return this;
        }

        public CodeBuilder comment(DocComment comment){
            esCodeBuilder.comment = comment;
            return this;
        }

        public CodeBuilder pattern(PatternEnum pattern){
            esCodeBuilder.pattern = pattern;
            return this;
        }

        public CodeBuilder entityFullPath(String entityFullPath){
            esCodeBuilder.entityFullPath = entityFullPath;
            return this;
        }


        public EsCodeBuilder build(){
            if (esCodeBuilder.packagePath!=null
            && esCodeBuilder.comment!=null
            && esCodeBuilder.pattern!=null) {
                return esCodeBuilder;
            }else{
                return null;
            }
        }

    }

    private PojoDateInfo analysis(Class<?> pojoClass){
        PojoAnalysisFactory analysisBox = new PojoAnalysisFactory();
        PojoDateInfo info = analysisBox.analysis(pojoClass);
        info.setComment(comment);
        info.setEntityFullPath(entityFullPath);
        info.setPackagePath(packagePath);
        return info;
    }
    private void intoPipline(PojoDateInfo info){
        if (pattern.equals(PatternEnum.TEMPLATEFILE)){
            //如果是模板生成，则进入模板处理链
            TemplateHandlerPipeline pipline = new TemplateHandlerPipeline();
            pipline.doHandler(info);
        }

    }

}