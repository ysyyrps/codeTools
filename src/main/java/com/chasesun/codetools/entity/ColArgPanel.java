/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.entity;

import com.chasesun.codetools.model.Property;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:一列参数
 * @author peter.Chen
 * @date 2016年2月14日下午4:45:28
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月14日        peter.Chen           new
 * 
 */

public class ColArgPanel extends JPanel {
    private List<Property> properties = new ArrayList<Property>();
    private List<RowArgPanel> rowArgPanelList = new ArrayList<RowArgPanel>();

    public ColArgPanel(int colunmNum, int rowLength) {
        super();
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        if (colunmNum <= 0) {
            return;
        }
        for (int i = 0; i < colunmNum; i++) {
            RowArgPanel rowPanel = new RowArgPanel(rowLength);
            add(rowPanel);
            rowArgPanelList.add(rowPanel);
            add(Box.createVerticalStrut(1));
        }

    }

    /**
     * @return the properties
     */
    public List<Property> getProperties() {
        properties = new ArrayList<Property>();
        if (rowArgPanelList != null && !rowArgPanelList.isEmpty()) {
            for (RowArgPanel panel : rowArgPanelList) {
                if (panel.getProperty() != null) {
                    properties.add(panel.getProperty());
                }
            }
        }
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

}
