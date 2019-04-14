package cloud.simple.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.core.utils.IPUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SimpleServiceCotroller {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello(final HttpServletRequest request){
		String ip = IPUtils.getIpAddr(request);
		return String.format("hello, %s", ip);
	}

}
