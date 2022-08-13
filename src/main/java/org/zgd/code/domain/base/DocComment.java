package org.zgd.code.domain.base;

import java.util.function.Supplier;

/**
 * @author thesky
 * @date 2022/7/14 15:30
 */
public class DocComment {

    private String comment;

    private DocComment(){

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static class Builder{
        //作者
        private String author;
        //其他信息
        private String doc;
        //创建时间方法
        private Supplier<String> date;

        public DocComment build(){
            StringBuilder builder = new StringBuilder();
            builder.append("/**\n" +
                    " * author "+author+"\n" +
                    " * date "+date.get()+"\n");
            int start = 0;
            while (doc !=null && start<=doc.length()){
                int end = start+40;
                if (end>doc.length()){
                    end = doc.length();
                }
                builder.append(" * "+doc.substring(start,end)+"\n");
                start = end;
            }
            builder.append(" */");
            DocComment docComment = new DocComment();
            docComment.setComment(builder.toString());
            return docComment;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder doc(String doc){
            this.doc = doc;
            return this;
        }

        public Builder date(Supplier<String> date){
            this.date = date;
            return this;
        }


    }

}
