package main;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(value = "main.dao")
@SpringBootApplication(scanBasePackages = "main")
@EnableSwagger2
public class MybatisSpringbootApplication {
	public static void main(String[] args)
	{
        SpringApplication.run(MybatisSpringbootApplication.class, args);
	}

}

