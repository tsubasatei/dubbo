package com.xt.gmall.config;

import com.alibaba.dubbo.config.*;
import com.xt.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    // <dubbo:application name="boot-user-service-provider"/>
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("boot-user-service-provider");
        return config;
    }

    // <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("127.0.0.1:2181");
//        config.setPort(2181);
        return config;
    }

    // <dubbo:protocol name="dubbo" port="20880"/>
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20880);
        return config;
    }

//    <dubbo:service interface="com.xt.gmall.service.UserService" ref="userService"
//            *                    timeout="1000" version="1.0.0">
//            *         <dubbo:method name="getUserAddressList" timeout="1000"/>
//            *     </dubbo:service>
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
        ServiceConfig<UserService> config = new ServiceConfig<>();
        config.setInterface(UserService.class);
        config.setRef(userService);
        config.setVersion("1.0.0");

        // 配置每一个 method 的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        // 将 method 的设置关联到 service 配置中
        List<MethodConfig> methodConfigs = new ArrayList<>();
        methodConfigs.add(methodConfig);
        config.setMethods(methodConfigs);

        return config;

    }

    // <dubbo:monitor protocol="registry"/>
    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig config = new MonitorConfig();
        config.setProtocol("registry");
        return config;
    }

    //ProviderConfig
}
