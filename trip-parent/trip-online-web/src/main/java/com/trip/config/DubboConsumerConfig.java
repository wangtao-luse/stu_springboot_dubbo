package com.trip.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import com.trip.api.TestApi;

public class DubboConsumerConfig {
public static void main(String[] args) {
	ApplicationConfig applicationConfig = new ApplicationConfig();
	applicationConfig.setName("trip-online-consumer");
	
	// 连接注册中心配置
	RegistryConfig registryConfig = new RegistryConfig();
	registryConfig.setAddress("zookeeper://localhost:2181");
	// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
	 
	// 引用远程服务
	ReferenceConfig<TestApi> referenceConfig = new ReferenceConfig<TestApi>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
	referenceConfig.setApplication(applicationConfig);
	referenceConfig.setRegistry(registryConfig);
	// 和本地bean一样使用xxxService
	 TestApi object = referenceConfig.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
}
}
