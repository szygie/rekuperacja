package szygie.ddns.logic;/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  SZYGIE
 * PROJECT       :  PI4J and JETTY Watering System
 * FILENAME      :  com.logic.DomoticzAPICaller.java
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DomoticzAPICaller {


    public void callDomoticz(String idx, String operation) throws IOException {

        try {



            HttpURLConnection con = null;
            URL url = new URL("http://raspberrypi:80/json.htm?type=command&param=switchlight&idx=" + idx + "&switchcmd=" + operation );

            System.out.println("url = " + url);


            con = (HttpURLConnection) url.openConnection();
            String auth = "admin:Welcome@123";
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeaderValue = "Basic " + new String(encodedAuth);
            con.setRequestProperty("Authorization", authHeaderValue);
            con.setRequestMethod("GET");

            System.out.println("changed state of IDX " + idx + " set operation to " + operation + " Got response code: " + con.getResponseCode());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            System.out.println();
            con.disconnect();

        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }

    }


}
