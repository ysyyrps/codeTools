/**  
 * Copyright © 2015jkzl. All rights reserved. 
 */
package com.chasesun.codetools.model;

import org.omg.CORBA.portable.ValueOutputStream;

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

public enum PropertyType {
    Byte_Type, short_Type, Short_Type, int_Type, Integer_Type, long_Type, Long_Type, boolean_Type, Boolean_Type, float_Type, Float_Type, double_Type, Double_Type, String_Type, ByteArray_Type, Date_Type;

    private PropertyType() {
    }

    @Override
    public String toString() {
        String result = name();
        result = result.substring(0, result.lastIndexOf("_"));
        return result;
    }

    public static PropertyType getPropertyType(String typeName) {
        typeName = typeName + "_Type";

        return valueOf(typeName);
    }

}
