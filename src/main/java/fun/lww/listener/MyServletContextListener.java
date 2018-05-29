package fun.lww.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("---------- start MyServletContextListener ----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("---------- end MyServletContextListener ----------");
    }
}
