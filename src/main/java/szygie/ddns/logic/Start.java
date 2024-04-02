package szygie.ddns.logic;/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  com.logic.Start.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://www.pi4j.com/
 * **********************************************************************
 * %%
 * #L%
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;



public class Start
{


    public static void main(String[] args) throws Exception
    {




        Server server = new Server(8888);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);



        context.addServlet(new ServletHolder(new ControlLevel1()),"/level1");
        context.addServlet(new ServletHolder(new ControlLevel2()), "/level2");
        context.addServlet(new ServletHolder(new ControlLevel3()), "/level3");
        context.addServlet(new ServletHolder(new ControlLevel4()), "/level4");




        context.addServlet(new ServletHolder(new HelloServlet()),"/about");


        server.start();
        System.out.println("<--Pi4J--> Szygie - GPIO Control Jetty server ... started.");
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler= schedulerFactory.getScheduler();



        JobDetail jobDomoticzService=new JobDetail("checkDomoticzService","checkService",DomoticzDeamonStatus.class);
        CronTrigger triggerDomoticzService=new CronTrigger("cronTrigger","checkService","*/30 * * * * ?");



        scheduler.scheduleJob(jobDomoticzService,triggerDomoticzService);
        scheduler.start();
        System.out.println("Scheduler started....");

        server.join();






    }
}
