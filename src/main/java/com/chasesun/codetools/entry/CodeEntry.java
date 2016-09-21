package com.chasesun.codetools.entry;

import com.chasesun.codetools.common.log.LogFactory;
import com.chasesun.codetools.entity.MainBoardFrame;
import org.apache.log4j.Logger;

public class CodeEntry {
    private static Logger log = LogFactory.getLogger(CodeEntry.class);

    public static void main(String[] args) {
        try {
            if (log.isInfoEnabled()) {
                log.info("开始");
            }

            MainBoardFrame frame = new MainBoardFrame();
            frame.create();

        } catch (Exception ex) {
            log.error("异常:", ex);
        } finally {
            if (log.isInfoEnabled()) {
                log.info("结束");
            }
        }

    }
}
