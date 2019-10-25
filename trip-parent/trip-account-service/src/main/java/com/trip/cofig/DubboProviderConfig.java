package com.trip.cofig;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.trip.api.TestApi;
import com.trip.service.TestServiceImpl;



public class DubboProviderConfig {
public static void main(String[] args) {
	TestServiceImpl testServiceImpl = new TestServiceImpl();
	//当前应用配置
	ApplicationConfig applicationConfig = new ApplicationConfig();
	//相当于dubbo.application.name=trip-account-provider
	applicationConfig.setName("trip-account-provider");
	
	//连接注册中心配置
	RegistryConfig registryConfig = new RegistryConfig();
	registryConfig.setAddress("zookeeper://localhost:2181");
	
	//// 服务提供者协议配置
	ProtocolConfig  protocolConfig = new ProtocolConfig();
	protocolConfig.setName("dubbo");
	protocolConfig.setPort(20880);
	//服务提供者暴露服务配置
	// 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
	ServiceConfig serviceCofig = new ServiceConfig();
	serviceCofig.setApplication(applicationConfig);
	//多个注册中心可以用setRegistries()
	serviceCofig.setRegistry(registryConfig);
	// 多个协议可以用setProtocols()
	serviceCofig.setProtocol(protocolConfig);
	serviceCofig.setInterface(TestApi.class);
	serviceCofig.setRef(testServiceImpl);
	serviceCofig.export();//暴露及注册服务
}
}
