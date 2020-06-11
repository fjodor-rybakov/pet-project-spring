package com.example.petproject

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


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

	@Bean
	fun exceptionTranslation(): PersistenceExceptionTranslationPostProcessor {
		return PersistenceExceptionTranslationPostProcessor()
	}

	@Bean
	fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
		return BCryptPasswordEncoder()
	}
}

fun main(args: Array<String>) {
	runApplication<PetProjectApplication>(*args)
}
