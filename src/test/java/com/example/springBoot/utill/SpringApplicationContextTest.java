package com.example.springBoot.utill;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"com.example.springBoot.dao",
		"com.example.springBoot.service"})
public class SpringApplicationContextTest {

}
