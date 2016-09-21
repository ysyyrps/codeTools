/**  
 * Copyright © 2016jkzl. All rights reserved. 
 */
package com.chasesun.codetools.entity;

import com.chasesun.codetools.common.log.LogFactory;
import com.chasesun.codetools.entry.CodeEntry;
import com.chasesun.codetools.model.*;
import com.chasesun.codetools.service.TemplateService;
import com.chasesun.codetools.service.impl.TemplateServiceImpl;
import com.chasesun.codetools.util.StringUtils;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @Description: TODO
 * @author peter.Chen
 * @date 2016年2月12日下午1:41:01
 * @version 1.0
 *
 * operation
 * date           operator             content
 * 2016年2月12日        peter.Chen           new
 * 
 */

public class MainBoardFrame extends JFrame {
    private static Logger log = LogFactory.getLogger(CodeEntry.class);

    /**
     * src/main/java
     * src
     * source
     * 
     */
    private static String[] sourceTypeStr = { "src/main/java", "src", "source", "无" };
    private JComboBox<String> sourceTypeBox;

    private JTextField authorText;

    private JTextField projectNameText;

    private JTextField packagePathText;

    private JTextField methodNameText;

    private JTextField todoText;

    private JComboBox<String> reqBox;

    private JPanel reqAndResPanel;
    // req 参数列表
    private ColArgPanel reqNameAndTypePanel1;
    private ColArgPanel reqNameAndTypePanel2;
    // res 参数列表
    private ColArgPanel resNameAndTypePanel1;
    private ColArgPanel resNameAndTypePanel2;

    private JComboBox<String> resBox;
    private JPanel resNamePanel;

    private JTextField resNameBean;

    private JTextArea reqResultArea;

    private JTextArea resResultArea;

    private JTextArea methodResultArea;

    private JTextArea methodServiceArea;

    private JTextArea methodServiceImplArea;

    public MainBoardFrame() {
        super("代码生成工具v1.0 -----by peter.Chen");
    }

    public void create() {
        JPanel mainPanel = new JPanel();
        BoxLayout mainPanelboxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainPanelboxLayout);
        JPanel upPanel = new JPanel();

        BoxLayout upPanelboxLayout = new BoxLayout(upPanel, BoxLayout.Y_AXIS);
        upPanel.setLayout(upPanelboxLayout);
        JPanel projectNamePanel = new JPanel();
        JLabel authorLabel = new JLabel("创建人");
        authorText = new JTextField("zuoci", 20);
        projectNamePanel.add(authorLabel);
        projectNamePanel.add(authorText);
        JLabel projectNameLabel = new JLabel("项目路径");
        projectNameText = new JTextField("C:\\studyWorkspace\\branches\\Monitor\\v1.0\\code\\Server\\Monitor\\", 20);
        projectNamePanel.add(projectNameLabel);
        projectNamePanel.add(projectNameText);

        projectNamePanel.add(new JLabel("source类型"));
        sourceTypeBox = new JComboBox<String>(sourceTypeStr);
        projectNamePanel.add(sourceTypeBox);
        JLabel packagePathLabel = new JLabel("包的路径");
        packagePathText = new JTextField("com.jkzl.nolimit.monitor.pojo", 20);
        projectNamePanel.add(packagePathLabel);
        projectNamePanel.add(packagePathText);
        JLabel methodNameLabel = new JLabel("方法名");
        methodNameText = new JTextField(20);
        projectNamePanel.add(methodNameLabel);
        projectNamePanel.add(methodNameText);
        projectNamePanel.add(new JLabel("方法注释"));
        todoText = new JTextField("todo", 20);
        projectNamePanel.add(todoText);
        upPanel.add(projectNamePanel);

        mainPanel.add(upPanel);

        reqAndResPanel = new JPanel();
        BoxLayout reqAndResBoxLayout = new BoxLayout(reqAndResPanel, BoxLayout.X_AXIS);
        reqAndResPanel.setLayout(reqAndResBoxLayout);

        JPanel reqNamePanel = new JPanel();
        JLabel reqNameLabel = new JLabel("req类型");
        reqNamePanel.add(reqNameLabel);
        String[] reqStrArray = { "CommonReqPoJo", "CommonPageReqPoJo" };
        reqBox = new JComboBox<String>(reqStrArray);
        reqNamePanel.add(reqBox);
        resNamePanel = new JPanel();
        JLabel resNameLabel = new JLabel("res类型");
        resNamePanel.add(resNameLabel);
        String[] resStrArray = { "normal", "list", "page" };
        resBox = new JComboBox<String>(resStrArray);
        resNamePanel.add(resBox);
        resNameBean = new JTextField(12);
        resNameBean.setVisible(false);
        resNamePanel.add(resNameBean);
        resBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedStr = (String) resBox.getSelectedItem();
                    if ("list".equals(selectedStr) || "page".equals(selectedStr)) {
                        resNameBean.setVisible(true);
                        reqAndResPanel.updateUI();
                    } else if ("normal".equals(selectedStr)) {
                        resNameBean.setVisible(false);
                        resNamePanel.updateUI();
                    }

                }

            }
        });

        reqAndResPanel.add(reqNamePanel);
        reqAndResPanel.add(Box.createHorizontalStrut(1));
        reqAndResPanel.add(resNamePanel);

        JPanel midPanel = new JPanel();
        BoxLayout midPanelLayout = new BoxLayout(midPanel, BoxLayout.Y_AXIS);
        midPanel.setLayout(midPanelLayout);
        midPanel.add(reqAndResPanel);
        JPanel reqAndResAreaPanel = new JPanel();
        BoxLayout reqAndResAreaBoxLayout = new BoxLayout(reqAndResAreaPanel, BoxLayout.X_AXIS);
        reqAndResAreaPanel.setLayout(reqAndResAreaBoxLayout);
        JPanel reqAreaPanel = new JPanel();
        BoxLayout reqAreaBoxLayout = new BoxLayout(reqAreaPanel, BoxLayout.X_AXIS);
        reqAreaPanel.setLayout(reqAreaBoxLayout);
        JLabel reqArgLabel = new JLabel("req参数");
        reqAreaPanel.add(reqArgLabel);
        // 创建req 参数列表面板
        reqNameAndTypePanel1 = new ColArgPanel(5, 8);
        reqNameAndTypePanel2 = new ColArgPanel(5, 8);

        reqAreaPanel.add(reqNameAndTypePanel1);
        reqAreaPanel.add(Box.createHorizontalStrut(10));
        reqAreaPanel.add(reqNameAndTypePanel2);
        reqAndResAreaPanel.add(reqAreaPanel);
        // req 和res area间距
        reqAndResAreaPanel.add(Box.createHorizontalStrut(40));

        JButton createButton = new JButton("生成");
        addCreateButtonEvent(createButton, this);
        reqAndResAreaPanel.add(createButton);

        reqAndResAreaPanel.add(Box.createHorizontalStrut(40));

        JPanel resAreaPanel = new JPanel();
        BoxLayout resAreaBoxLayout = new BoxLayout(resAreaPanel, BoxLayout.X_AXIS);
        resAreaPanel.setLayout(resAreaBoxLayout);
        resNameAndTypePanel1 = new ColArgPanel(5, 8);
        resNameAndTypePanel2 = new ColArgPanel(5, 8);
        resAreaPanel.add(resNameAndTypePanel1);
        resAreaPanel.add(Box.createHorizontalStrut(10));
        resAreaPanel.add(resNameAndTypePanel2);
        reqAndResAreaPanel.add(resAreaPanel);
        JLabel resArgLabel = new JLabel("res参数");
        resAreaPanel.add(resArgLabel);

        midPanel.add(reqAndResAreaPanel);
        mainPanel.add(midPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        JPanel downPanel = new JPanel();
        BoxLayout downPanelLayout = new BoxLayout(downPanel, BoxLayout.X_AXIS);
        downPanel.setLayout(downPanelLayout);
        // JPanel resultPanel = new JPanel();
        // BoxLayout resultPanelBoxLayout = new BoxLayout(resultPanel,
        // BoxLayout.X_AXIS);
        // resultPanel.setLayout(resultPanelBoxLayout);
        JPanel reqResultAreaPanel = new JPanel();
        BoxLayout reqResultAreaPanelLayout = new BoxLayout(reqResultAreaPanel, BoxLayout.Y_AXIS);
        reqResultAreaPanel.setLayout(reqResultAreaPanelLayout);
        reqResultArea = new JTextArea(20, 10);
        reqResultAreaPanel.add(new JLabel("req"));
        reqResultAreaPanel.add(new JScrollPane(reqResultArea));
        downPanel.add(reqResultAreaPanel);

        downPanel.add(Box.createHorizontalStrut(20));

        JPanel resResultAreaPanel = new JPanel();
        BoxLayout resResultAreaPanelLayout = new BoxLayout(resResultAreaPanel, BoxLayout.Y_AXIS);
        resResultAreaPanel.setLayout(resResultAreaPanelLayout);
        resResultArea = new JTextArea(20, 10);
        resResultAreaPanel.add(new JLabel("res"));
        resResultAreaPanel.add(new JScrollPane(resResultArea));
        downPanel.add(resResultAreaPanel);

        // downPanel.add(new JLabel("controllMethod"));
        JPanel methodPanel = new JPanel();
        BoxLayout methodPanelLayout = new BoxLayout(methodPanel, BoxLayout.Y_AXIS);
        methodPanel.setLayout(methodPanelLayout);

        methodResultArea = new JTextArea(15, 5);
        methodResultArea.setAutoscrolls(true);
        methodPanel.add(new JLabel("controllMethod"));
        methodPanel.add(new JScrollPane(methodResultArea));

        methodPanel.add(new JLabel("service"));
        methodServiceArea = new JTextArea(12, 5);
        methodPanel.add(new JScrollPane(methodServiceArea));

        methodPanel.add(new JLabel("serviceImpl"));
        methodServiceImplArea = new JTextArea(10, 5);
        methodPanel.add(new JScrollPane(methodServiceImplArea));
        downPanel.add(Box.createHorizontalStrut(20));
        downPanel.add(methodPanel);

        mainPanel.add(downPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        super.add(mainPanel);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(-1);
            }
        });
        super.setVisible(true);
        super.pack();
        super.setLocation(80, 80);
    }

    public void addCreateButtonEvent(JButton button, final JFrame frame) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.repaint();
                // JOptionPane.showMessageDialog(frame, "生成成功!");
                try {
                    String projectPath = projectNameText.getText().trim();
                    String lastChar = projectPath.substring(projectPath.length() - 1);
                    if (!"\\".equals(lastChar)) {
                        projectPath += "\\";
                    }
                    String authorName = authorText.getText().trim();
                    String sourceTypeStr = sourceTypeBox.getSelectedItem().toString();
                    SourceType sourceType = SourceType.getSourceType(sourceTypeStr);
                    String templatePath=this.getClass().getResource("/template").getPath();
                    log.info(templatePath);
//                    templatePath = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 1) + "template";

//                    log.error(f.getAbsolutePath());
                    TemplateProperties properties = new TemplateProperties(templatePath, projectPath, authorName,
                            sourceType, true);
                    TemplateService tmplateService = new TemplateServiceImpl(properties);
                    createReqTemplate(tmplateService, projectPath);
                    createResTemplate(tmplateService, projectPath);
                    createMethodTemplate(tmplateService, projectPath);
                    createServiceMethodTemplate(tmplateService, projectPath);
                    createServiceImplMethodTemplate(tmplateService, projectPath);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    // log.error(e1);
                    log.error(e1.getStackTrace());
                }
            }
        });
    }

    private ReqTemplate setReqTemplate() {
        ReqTemplate req = new ReqTemplate();
        String methodName = methodNameText.getText().trim();
        req.setClassName(methodName);
        String packageName = packagePathText.getText().trim();
        String superClassName = reqBox.getSelectedItem().toString();
        req.setSuperClass(superClassName);
        // 判断空
        req.setJavaPackage(packageName);
        req.setTodo(todoText.getText().trim() + "请求");
        List<Property> reqProperties = reqNameAndTypePanel1.getProperties();
        reqProperties.addAll(reqNameAndTypePanel2.getProperties());
        req.setProperties(reqProperties);
        return req;

    }

    private ControllerMethodTemplate setControlMethodTemplate() {
        ControllerMethodTemplate temp = new ControllerMethodTemplate();
        String resTypeStr = resBox.getSelectedItem().toString();
        temp.setResType(ResType.valueOf(resTypeStr));
        String methodName = methodNameText.getText().trim();
        temp.setClassName(Long.toString(System.currentTimeMillis()));
        String resName = resNameBean.getText().trim();
        temp.setMethodNameAndResName(methodName, resName, ResType.valueOf(resTypeStr));
        String packageName = packagePathText.getText().trim();
        // 判断空
        temp.setJavaPackage(packageName);
        temp.setTodo(todoText.getText().trim());
        return temp;

    }

    private ServiceMethodTemplate setServiceMethodTemplate() {
        ServiceMethodTemplate temp = new ServiceMethodTemplate();
        String resTypeStr = resBox.getSelectedItem().toString();
        temp.setResType(ResType.valueOf(resTypeStr));
        String methodName = methodNameText.getText().trim();
        temp.setClassName(Long.toString(System.currentTimeMillis()));
        String resName = resNameBean.getText().trim();
        temp.setMethodNameAndResName(methodName, resName, ResType.valueOf(resTypeStr));
        String packageName = packagePathText.getText().trim();
        // 判断空
        temp.setJavaPackage(packageName);
        temp.setTodo(todoText.getText().trim());
        return temp;

    }

    private ServiceImplMethodTemplate setServiceImplMethodTemplate() {
        ServiceImplMethodTemplate temp = new ServiceImplMethodTemplate();
        String resTypeStr = resBox.getSelectedItem().toString();
        temp.setResType(ResType.valueOf(resTypeStr));
        String methodName = methodNameText.getText().trim();
        temp.setClassName(Long.toString(System.currentTimeMillis()));
        String resName = resNameBean.getText().trim();
        temp.setMethodNameAndResName(methodName, resName, ResType.valueOf(resTypeStr));
        String packageName = packagePathText.getText().trim();
        // 判断空
        temp.setJavaPackage(packageName);
        temp.setTodo(todoText.getText().trim());
        return temp;

    }

    private ResTemplate setResTemplate() {
        ResTemplate res = new ResTemplate();
        String methodName = methodNameText.getText().trim();
        String resSelectedStr = resBox.getSelectedItem().toString();
        boolean isNormal = true;
        if (!"normal".equals(resSelectedStr)) {
            isNormal = false;
            methodName = resNameBean.getText().trim();
            if (StringUtils.isEmpty(methodName)) {
                methodName = methodNameText.getText().trim();
            }
        }
        res.setResClassName(methodName, isNormal);
        String packageName = packagePathText.getText().trim();
        // 判断空
        res.setJavaPackage(packageName);
        res.setTodo(todoText.getText().trim() + "响应");
        List<Property> resProperties = resNameAndTypePanel1.getProperties();
        resProperties.addAll(resNameAndTypePanel2.getProperties());
        res.setProperties(resProperties);
        return res;

    }

    public String createReqTemplate(TemplateService templateService, String projectNamePath) throws Exception {
        ReqTemplate reqTemplate = setReqTemplate();
        String filePath = templateService.createReqTemplate(reqTemplate);
        reqResultArea.setText(getStringByFilePath(filePath));
        return filePath;
    }

    public String createResTemplate(TemplateService templateService, String projectNamePath) throws Exception {
        ResTemplate resTemplate = setResTemplate();
        String filePath = templateService.createResTemplate(resTemplate);
        resResultArea.setText(getStringByFilePath(filePath));
        return filePath;
    }

    public String createMethodTemplate(TemplateService templateService, String projectNamePath) throws Exception {
        ControllerMethodTemplate template = setControlMethodTemplate();
        String filePath = templateService.createControllMethodTemplate(template);
        String content = getStringByFilePath(filePath);
        methodResultArea.setText(content);
        String controllerName = getControllerName(filePath);
        controllerName = getFirstCharUp(controllerName);
        String mainPath = getMainPath(filePath);
        String controllerPath = mainPath + "controller\\" + controllerName + "Controller.java";
        System.out.println(controllerPath);
        addStringToFile(content, controllerPath);
        File file = new File(filePath);
        file.delete();
        return filePath;
    }

    public String createServiceMethodTemplate(TemplateService templateService, String projectNamePath) throws Exception {
        ServiceMethodTemplate template = setServiceMethodTemplate();
        String filePath = templateService.createServiceMethodTemplate(template);

        String content = getStringByFilePath(filePath);
        methodServiceArea.setText(content);
        String controllerName = getControllerName(filePath);
        controllerName = getFirstCharUp(controllerName);
        String mainPath = getMainPath(filePath);
        String controllerPath = mainPath + "service\\" + controllerName + "Service.java";
        System.out.println(controllerPath);
        addStringToFile(content, controllerPath);

        File file = new File(filePath);
        file.delete();
        return filePath;
    }

    public String createServiceImplMethodTemplate(TemplateService templateService, String projectNamePath)
            throws Exception {
        ServiceImplMethodTemplate template = setServiceImplMethodTemplate();
        String filePath = templateService.createServiceImplMethodTemplate(template);
        String content = getStringByFilePath(filePath);
        methodServiceImplArea.setText(content);
        String controllerName = getControllerName(filePath);
        controllerName = getFirstCharUp(controllerName);
        String mainPath = getMainPath(filePath);
        String controllerPath = mainPath + "service\\impl\\" + controllerName + "ServiceImpl.java";
        System.out.println(controllerPath);
        addStringToFile(content, controllerPath);

        File file = new File(filePath);
        file.delete();
        return filePath;
    }

    private String getControllerName(String filePath) throws Exception {
        int pojoIndex = filePath.lastIndexOf("pojo");
        int lastganIndex = filePath.lastIndexOf("\\");
        String controllerName = filePath.substring(pojoIndex + 5, lastganIndex);
        String controllerPath = filePath.substring(0, pojoIndex);
        return controllerName;
    }

    private String getMainPath(String filePath) throws Exception {
        int pojoIndex = filePath.lastIndexOf("pojo");
        int lastganIndex = filePath.lastIndexOf("\\");
        String controllerName = filePath.substring(pojoIndex + 5, lastganIndex);
        String controllerPath = filePath.substring(0, pojoIndex);
        return controllerPath;
    }

    public String getFirstCharUp(String className) {
        String firstChar = className.substring(0, 1);
        String endStr = className.substring(1);
        className = firstChar.toUpperCase() + endStr;
        return className;
    }

    public void addStringToFile(String content, String filePath) throws Exception {
        String oriContent = getStringByFilePath(filePath);
        oriContent = oriContent.substring(0, oriContent.lastIndexOf("}"));
        oriContent += content;
        oriContent += "\r\n}";
        System.out.println(oriContent);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), Charset.forName("utf-8"));
        writer.write(oriContent);
        writer.flush();
        writer.close();

    }

    private String getStringByFilePath(String filePath) throws Exception {
        StringBuffer strBuffer = new StringBuffer();
        // FileReader reader = new FileReader(new File(filePath));
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), Charset.forName("utf-8"));
        int c = 0;
        while ((c = reader.read()) != -1) {
            strBuffer.append((char) c);
        }
        reader.close();
        return strBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(MainBoardFrame.class.getResource("/template").getPath());
    }
}
