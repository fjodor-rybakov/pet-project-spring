package com.example.petproject

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
class PetProjectApplication {
	@Bean
	fun modelMapper(): ModelMapper {
		val modelMapper = ModelMapper()
		modelMapper.configuration
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.fieldAccessLevel = org.modelmapper.config.Configuration.AccessLevel.PRIVATE
		return modelMapper
	}
}

fun main(args: Array<String>) {
	runApplication<PetProjectApplication>(*args)
}
