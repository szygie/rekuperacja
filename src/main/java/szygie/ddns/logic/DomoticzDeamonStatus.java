package szygie.ddns.logic;/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  SZYGIE
 * PROJECT       :  PI4J and JETTY Watering System
 * FILENAME      :  com.logic.DomoticzDeamonStatus.java
 *
 * This is program belongs to Szygie (sgiedrojc@gmail.com)
 * All rights reserved!
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DomoticzDeamonStatus implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            String[] cmd = {"/bin/bash", "-c", "sudo systemctl is-active domoticz"};
            Process pb = null;
            try {
                pb = Runtime.getRuntime().exec(cmd);

                String line;
                BufferedReader input = new BufferedReader(new InputStreamReader(pb.getInputStream()));

                while ((line = input.readLine()) != null) {
                    System.out.println("Domoticz service is " + line);
                    if(line.equals("inactive")){
                        String[] cmdRestart = {"/bin/bash", "-c", "sudo systemctl restart domoticz"};
                        Process pb2 = null;
                        pb2 = Runtime.getRuntime().exec(cmdRestart);
                        System.out.println("Restarting Domoticz service due to inactivity");
                    }
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
