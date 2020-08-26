package com.legenda.lee.studyurule;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

/**
 * @author: Legenda-Lee(lee.legenda@gmail.com)
 * @date: 2020-08-14 6:02 下午
 * @description:
 * 因为urule-console-pro模块架构在Spring之上的，所以需要加载urule-console-pro模块中提供的Spring配置文件，
 * 这个配置文件位于urule-console-pro对应的jar的classpath根下，名为urule-console-context.xml，
 * 所以如果我们的项目也是基于Spring的，那么可以打开一个项目中的Spring配置文件，
 * 在其中通过下面的代码导入urule-console-context.xml文件
 */
@Configuration
public class DBConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }


}
