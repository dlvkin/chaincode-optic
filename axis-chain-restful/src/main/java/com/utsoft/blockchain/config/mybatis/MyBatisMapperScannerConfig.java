package com.utsoft.blockchain.config.mybatis;
import java.util.Properties;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utsoft.blockchain.support.dao.MySqlBaseMapper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;
/**
 * @author <a href="flyskyhunter@gmail.com">hunterfox</a>
 * @version 1.0
 * @date 2017年07月11日
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MyBatisMapperScannerConfig {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.utsoft.blockchain.support.dao.mapper");
		Properties properties = new Properties();
		properties.setProperty("mappers", MySqlBaseMapper.class.getName());
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}
}