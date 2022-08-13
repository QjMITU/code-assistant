package org.zgd.code;

import org.zgd.code.domain.base.DocComment;
import org.zgd.code.enums.PatternEnum;
import org.zgd.code.domain.builder.EsCodeBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author thesky
 * @date 2022/7/14 10:37
 */
public class Test {

    public static void main(String[] args){
        new EsCodeBuilder.CodeBuilder()
                .packagePath("org.zgd.code")
                .comment(new DocComment.Builder().author("thsky").date(() -> {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    return format.format(new Date());
                }).build())      //类文档注释
                .pattern(PatternEnum.TEMPLATEFILE)      //约定模板放在resources目录template中
                .entityFullPath("org.zgd.code.domain")      //实体类所在包
                .build().building();       //启动代码生成步骤
    }
}
