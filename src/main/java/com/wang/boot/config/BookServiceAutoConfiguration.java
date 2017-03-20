package com.wang.boot.config;

import com.wang.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BookProperties.class)//指定类的配置
@ConditionalOnClass(BookService.class)//当BookService在类路径中时并且当前容器中没有这个Bean的情况下,自动配置
@ConditionalOnProperty(prefix = "com.wang.boot", value = "enable", matchIfMissing = true)//指定的属性是否有指定的值
public class BookServiceAutoConfiguration {
    @Autowired
    private BookProperties bookProperties;

    @Bean
    @ConditionalOnMissingBean(BookService.class)//当容器中没有指定Bean的情况下
    public BookService bookService() {
        BookService bookService = new BookService(bookProperties);
        return bookService;
    }
}