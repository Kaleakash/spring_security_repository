package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController    // @Controller + @ResponseBody
public class SampleController {

//	@RequestMapping(value = "sayHello",produces = MediaType.TEXT_PLAIN_VALUE,
//			method = RequestMethod.GET)
	@GetMapping(value = "sayHello",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayHello() {
		return "Welcome to Spring boot with simple text message";
	}
	
	
//	@RequestMapping(value = "sayHello",produces = MediaType.TEXT_PLAIN_VALUE,
//	method = RequestMethod.GET)
	@GetMapping(value = "sayHtml",produces = MediaType.TEXT_HTML_VALUE)
	public String sayHTML() {
		return "<h2>Welcome to Spring boot with simple text message</h2>";
	}
	
	
	//@RequestMapping(value = "sayPlain",produces = MediaType.TEXT_PLAIN_VALUE,
	//			method = RequestMethod.GET)
			@GetMapping(value = "sayPlain",produces = MediaType.TEXT_PLAIN_VALUE)
			public String sayPlain() {
				return "<h2>Welcome to Spring boot with simple text messageh2>";
			}
			
			//@RequestMapping(value = "sayPlain",produces = MediaType.TEXT_PLAIN_VALUE,
			//			method = RequestMethod.GET)
					@GetMapping(value = "sayXml",produces = MediaType.TEXT_XML_VALUE)
					public String sayXML() {
						return "<abc>Welcome to Spring boot with simple text message</abc>";
					}
}
