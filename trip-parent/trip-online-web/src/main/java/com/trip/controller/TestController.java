package com.trip.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trip.api.TestApi;
import com.trip.resp.ResponseMessage;

@Controller
public class TestController {
	@Reference
	TestApi testApi;
@RequestMapping("/hello")
@ResponseBody
public String hello() {
	return "hello world!";
}
@RequestMapping("/sayhello")
@ResponseBody
public ResponseMessage sayHello() {
	ResponseMessage sayHello = testApi.sayHello();
	return sayHello;
}
}
