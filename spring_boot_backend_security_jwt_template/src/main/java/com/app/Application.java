package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.modelmapper.Conditions;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD)
	.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}

}
