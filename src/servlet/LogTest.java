package servlet;

import org.apache.log4j.Logger;

public class LogTest {
	
	private final static Logger logger = Logger.getLogger(LogTest.class); 

    public static void main(String[] args) {  
        // ��¼debug�������Ϣ  
        logger.debug("This is debug message.");  
        // ��¼info�������Ϣ  
        logger.info("This is info message.");  
        // ��¼error�������Ϣ  
        logger.error("This is error message.");  
    } 

}
