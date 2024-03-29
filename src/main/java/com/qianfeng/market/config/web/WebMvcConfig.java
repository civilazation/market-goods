package com.qianfeng.market.config.web;

import com.qianfeng.market.consts.GoodsConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * creator：Administrator
 * date:2019/10/17
 */

/**
 * webMVC的配置类
 */
@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 配置跨域请求
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }

    /**
     * 配置项目虚拟路径映射到磁盘真正的路径
     *
     * @param registry
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
        // 你要代理的静态资源路径（虚拟路径），也就是说项目中如果出现此（虚拟路径）路径，那么它会映射指向到真正的磁盘路径
//        /upload/** 这个虚拟路径将会被映射到，
//        默认 肯定是linux磁盘路径
        String docPath = GoodsConsts.getConfigUploadPath();
        logger.info("图片上传路径为：" + docPath);
        registry.addResourceHandler("/upload/**").addResourceLocations(docPath);
    }
}
