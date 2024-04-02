package szygie.ddns.logic;

import com.pi4j.io.gpio.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlLevel4 extends HttpServlet {
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput tryb1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "Relay_1", PinState.HIGH);
		final GpioPinDigitalOutput tryb2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "Relay_2", PinState.HIGH);
		final GpioPinDigitalOutput tryb3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "Relay_3", PinState.HIGH);





		tryb1.high();
		tryb2.high();
		tryb3.high();


		tryb3.setShutdownOptions(true, PinState.HIGH);


		gpio.unprovisionPin(tryb1);
		gpio.unprovisionPin(tryb2);
		gpio.unprovisionPin(tryb3);




		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println("<h1>Włączono tryb defaultowy </h1>");

	}

}
