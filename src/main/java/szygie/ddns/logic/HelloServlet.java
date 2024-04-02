package szygie.ddns.logic;/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  SZYGIE
 * PROJECT       :  PI4J and JETTY Watering System
 * FILENAME      :  com.logic.HelloServlet.java
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    private String greeting="                                                                                                                                                                                                                                                             \n" +
            "                                                                                                                                                                                                                                                             \n" +
            "   SSSSSSSSSSSSSSS ZZZZZZZZZZZZZZZZZZZYYYYYYY       YYYYYYY       GGGGGGGGGGGGGIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEE     DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEEVVVVVVVV           VVVVVVVV                                                                     \n" +
            " SS:::::::::::::::SZ:::::::::::::::::ZY:::::Y       Y:::::Y    GGG::::::::::::GI::::::::IE::::::::::::::::::::E     D::::::::::::DDD   E::::::::::::::::::::EV::::::V           V::::::V                                                                     \n" +
            "S:::::SSSSSS::::::SZ:::::::::::::::::ZY:::::Y       Y:::::Y  GG:::::::::::::::GI::::::::IE::::::::::::::::::::E     D:::::::::::::::DD E::::::::::::::::::::EV::::::V           V::::::V                                                                     \n" +
            "S:::::S     SSSSSSSZ:::ZZZZZZZZ:::::Z Y::::::Y     Y::::::Y G:::::GGGGGGGG::::GII::::::IIEE::::::EEEEEEEEE::::E     DDD:::::DDDDD:::::DEE::::::EEEEEEEEE::::EV::::::V           V::::::V                                                                     \n" +
            "S:::::S            ZZZZZ     Z:::::Z  YYY:::::Y   Y:::::YYYG:::::G       GGGGGG  I::::I    E:::::E       EEEEEE       D:::::D    D:::::D E:::::E       EEEEEE V:::::V           V:::::V                                                                      \n" +
            "S:::::S                    Z:::::Z       Y:::::Y Y:::::Y  G:::::G                I::::I    E:::::E                    D:::::D     D:::::DE:::::E               V:::::V         V:::::V                                                                       \n" +
            " S::::SSSS                Z:::::Z         Y:::::Y:::::Y   G:::::G                I::::I    E::::::EEEEEEEEEE          D:::::D     D:::::DE::::::EEEEEEEEEE      V:::::V       V:::::V                                                                        \n" +
            "  SS::::::SSSSS          Z:::::Z           Y:::::::::Y    G:::::G    GGGGGGGGGG  I::::I    E:::::::::::::::E          D:::::D     D:::::DE:::::::::::::::E       V:::::V     V:::::V                                                                         \n" +
            "    SSS::::::::SS       Z:::::Z             Y:::::::Y     G:::::G    G::::::::G  I::::I    E:::::::::::::::E          D:::::D     D:::::DE:::::::::::::::E        V:::::V   V:::::V                                                                          \n" +
            "       SSSSSS::::S     Z:::::Z               Y:::::Y      G:::::G    GGGGG::::G  I::::I    E::::::EEEEEEEEEE          D:::::D     D:::::DE::::::EEEEEEEEEE         V:::::V V:::::V                                                                           \n" +
            "            S:::::S   Z:::::Z                Y:::::Y      G:::::G        G::::G  I::::I    E:::::E                    D:::::D     D:::::DE:::::E                    V:::::V:::::V                                                                            \n" +
            "            S:::::SZZZ:::::Z     ZZZZZ       Y:::::Y       G:::::G       G::::G  I::::I    E:::::E       EEEEEE       D:::::D    D:::::D E:::::E       EEEEEE        V:::::::::V                                                                             \n" +
            "SSSSSSS     S:::::SZ::::::ZZZZZZZZ:::Z       Y:::::Y        G:::::GGGGGGGG::::GII::::::IIEE::::::EEEEEEEE:::::E     DDD:::::DDDDD:::::DEE::::::EEEEEEEE:::::E         V:::::::V                                                                              \n" +
            "S::::::SSSSSS:::::SZ:::::::::::::::::Z    YYYY:::::YYYY      GG:::::::::::::::GI::::::::IE::::::::::::::::::::E     D:::::::::::::::DD E::::::::::::::::::::E          V:::::V                                                                               \n" +
            "S:::::::::::::::SS Z:::::::::::::::::Z    Y:::::::::::Y        GGG::::::GGG:::GI::::::::IE::::::::::::::::::::E     D::::::::::::DDD   E::::::::::::::::::::E           V:::V                                                                                \n" +
            " SSSSSSSSSSSSSSS   ZZZZZZZZZZZZZZZZZZZ    YYYYYYYYYYYYY           GGGGGG   GGGGIIIIIIIIIIEEEEEEEEEEEEEEEEEEEEEE     DDDDDDDDDDDDD      EEEEEEEEEEEEEEEEEEEEEE            VVV                                                                                 \n" +
            "                                                                                                                                                                                                                                                             \n" +
            "                                                                                                                                                                                                                                                             \n" +
            "       developed by szygie, JAVA 8 . All rights reserved                                                                                                                                                                                                                                                     \n" +
            "       email: sgiedrojc@gmail.com  " +
            "                                                                                                                                                                                                                                                    \n" ;
    public HelloServlet(){}
    public HelloServlet(String greeting)
    {
        this.greeting=greeting;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(greeting);
    }
}
