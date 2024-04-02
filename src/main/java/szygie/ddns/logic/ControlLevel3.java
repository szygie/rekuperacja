package szygie.ddns.logic;/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  SZYGIE
 * PROJECT       :  PI4J and JETTY Watering System
 * FILENAME      :  ControlPin3.java
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
import com.pi4j.io.gpio.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlLevel3 extends HttpServlet {


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput tryb1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "Relay_1", PinState.HIGH);
        final GpioPinDigitalOutput tryb2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "Relay_2", PinState.HIGH);
        final GpioPinDigitalOutput tryb3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "Relay_3", PinState.HIGH);





        tryb1.high();
        tryb2.high();
        tryb3.low();


        tryb3.setShutdownOptions(true, PinState.HIGH);


        gpio.unprovisionPin(tryb1);
        gpio.unprovisionPin(tryb2);
        gpio.unprovisionPin(tryb3);




        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("<h1>Włączono PIN 21 </h1>");

    }
}
