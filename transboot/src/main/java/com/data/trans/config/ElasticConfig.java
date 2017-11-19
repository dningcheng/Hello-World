package com.data.trans.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.data.trans.util.ElasticDataSource;

@Configuration
public class ElasticConfig {
	
	private Logger logger = LoggerFactory.getLogger(ElasticConfig.class);  
    
    @Value("${elastic.server.host}")  
    private String host;  
      
    @Value("${elastic.server.port}")  
    private Integer port;  
      
    @Value("${elastic.server.clusterName}")  
    private String clusterName;
    
    @Value("${elastic.client.pool.initialSize}")  
    private Integer initialSize;  
      
    @Value("${elastic.client.pool.maxSize}")  
    private Integer maxSize;  
      
    @Value("${elastic.client.pool.minSize}")  
    private Integer minSize;
    
    @Value("${elastic.client.pool.maxWait}")  
    private Integer maxWait;
    
	@Bean     //声明其为Bean实例  
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource  
    public ElasticDataSource EsDataSource(){  
    	
		ElasticDataSource dataSource = new ElasticDataSource();
		
    	dataSource.setHost(host);
    	dataSource.setClusterName(clusterName);
    	dataSource.setPort(port);
    	dataSource.setInitialSize(initialSize);
    	dataSource.setMaxSize(maxSize);
    	dataSource.setMinSize(minSize);
    	dataSource.setMaxWait(maxWait);
    	logger.info("开始初始化es连接池...");
    	dataSource.initDataSource();
    	
		return dataSource;
    }
    
}