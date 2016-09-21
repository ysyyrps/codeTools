/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

/**
 * @Description: entity的属性类型定义
 * @author peter.Chen
 * @date 2015年9月9日下午2:05:02
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2015年9月9日        peter.Chen           new
 * 
 */

public enum SourceType {
   src_main_java,source,src;
   public static SourceType getSourceType(String sourceName) {
       if("无".equals(sourceName)){
           return null;
       }
       sourceName = sourceName.replace("/", "_");
       return valueOf(sourceName);
   }
   public static String getSourceTypeStr(SourceType sourceType){
       if(sourceType==null){
           return "";
       }
       return sourceType.name().replace("_", "/");
   }
}
