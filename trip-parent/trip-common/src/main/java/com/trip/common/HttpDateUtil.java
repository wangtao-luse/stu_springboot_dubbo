package com.trip.common;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.trip.req.RequestBody;
import com.trip.req.RequestHead;
import com.trip.req.RequestMessage;

public class HttpDateUtil {

public static RequestMessage postData(String functionMethod,JSONObject content,HttpServletRequest request) {
	RequestMessage requestMessage = new RequestMessage();
	RequestHead header = new RequestHead();
	header.setFunctionMethod(functionMethod);
	requestMessage.setHead(header);
	
	RequestBody body = new RequestBody();
	body.setContent(content);
	requestMessage.setBody(body);
	return requestMessage;
}
}
