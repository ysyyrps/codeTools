/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.entity;

import com.chasesun.codetools.model.Property;
import com.chasesun.codetools.model.PropertyType;
import com.chasesun.codetools.util.StringUtils;

import javax.swing.*;


/**
 * @Description:参数列表每一行 
 * @author peter.Chen
 * @date 2016年2月13日下午5:17:01
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月13日        peter.Chen           new
 * 
 */

public class RowArgPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 5648029897394228215L;

    private JTextField nameText;

    private JComboBox<String> box;

    private JTextField cnNameText;

    private static String[] typeStrArray = { "String", "Boolean", "boolean", "Integer", "int", "Date", "Double",
            "double", "Long", "long", "Short", "short", "Float", "float" };

    public RowArgPanel(int rowLength) {
        super();
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);
        nameText = new JTextField(rowLength);
        box = new JComboBox<String>(typeStrArray);
        cnNameText = new JTextField(rowLength);
        add(nameText);
        add(box);
        add(cnNameText);
    }

    public Property getProperty() {
        Property pro = new Property();
        String name = nameText.getText().trim();
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        pro.setPropertyName(name);
        
        String typeName = box.getSelectedItem().toString();
        pro.setPropertyType(PropertyType.getPropertyType(typeName));
        String cnName = cnNameText.getText().trim();
        if (!StringUtils.isEmpty(cnName)) {
            pro.setCnName(cnName);
        } else {
            pro.setCnName(name);
        }
        return pro;
    }
}
