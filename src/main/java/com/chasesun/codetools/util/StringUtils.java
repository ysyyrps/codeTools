/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.util;

/**
 * @Description: TODO
 * @author peter.Chen
 * @date 2016年2月12日下午10:08:54
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月12日        peter.Chen           new
 * 
 */

public class StringUtils {
   public static boolean isEmpty(String str){
       if(str != null && !str.equals("")){
           return false;
       }
       return true;
   }
}
