package com.trip.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.trip.api.TestApi;
import com.trip.model.Contract;
import com.trip.persist.mapper.ContractMapper;
import com.trip.resp.ResponseMessage;
@Service
public class TestServiceImpl implements TestApi{
	@Autowired
   ContractMapper contractMapper;
	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "hello world!";
	}

	@Override
	public ResponseMessage sayHello() {
		ResponseMessage resp = ResponseMessage.getSucess();
		long id = new Long("178");
		Contract queryById = contractMapper.queryById(id);
		resp.setReturnResult(queryById);
		return resp;
	}

}
