/**  
 * Copyright  2016jkzl. All rights reserved. 
 */
package ${req.javaPackage};

import com.jkzl.nolimit.commons.pojo.${req.superClass}; 
/**
 * @Description: ${req.todo}
 * @author ${user}
 * @date ${createdTime}
 * @version 1.0
 *
 * operation
 * date                                      operator             content
 * ${createdTime}                       ${user}           new
 * 
 */
public class ${req.className} extends ${req.superClass}{ 
    
    <#list req.properties as property>
    /**
     * ${property.cnName}
     */
    private ${property.propertyType} ${property.propertyName};
    </#list>
    
    <#list req.properties as property>
     /**
     * @return the ${property.propertyName}
     */
    public ${property.propertyType} get${property.firstCapitalName}() {
        return ${property.propertyName};
    }

    /**
     * @param ${property.propertyName} the ${property.propertyName} to set
     */
    public void set${property.firstCapitalName}(${property.propertyType} ${property.propertyName}) {
        this.${property.propertyName} = ${property.propertyName};
    }
    </#list>
    
    
}