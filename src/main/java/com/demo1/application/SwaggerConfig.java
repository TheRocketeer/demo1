package com.demo1.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @since 07-11-2020
 * @author Angel Lara
 *
 */
 @Configuration
 @EnableSwagger2
 @ComponentScan(basePackages = {"com.demo1.controller", "com.demo1.service"})
public class SwaggerConfig {

}