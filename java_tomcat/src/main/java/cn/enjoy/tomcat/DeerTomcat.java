package cn.enjoy.tomcat;

import cn.enjoy.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * Created by VULCAN on 2018/9/28.
 */
public class DeerTomcat {

    private static int PORT = 8080;
    private static String CONTEX_PATH = "/enjoy";
    private static String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws LifecycleException, InterruptedException {

        // 创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        // 指定端口号
        tomcatServer.setPort(PORT);
        // 是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        // 创建上下文
        StandardContext standardContex = new StandardContext();
        standardContex.setPath(CONTEX_PATH);
        // 监听上下文
        standardContex.addLifecycleListener(new Tomcat.FixContextListener());
        // tomcat容器添加standardContex
        tomcatServer.getHost().addChild(standardContex);

        // 创建Servlet
        tomcatServer.addServlet(CONTEX_PATH, SERVLET_NAME, new IndexServlet());
        // servleturl映射
        standardContex.addServletMappingDecoded("/index", SERVLET_NAME);
        tomcatServer.start();
        System.out.println("tomcat服务器启动成功..");
        // 异步进行接收请求
        tomcatServer.getServer().await();

    }
}
