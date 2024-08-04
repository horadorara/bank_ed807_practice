package com.example.bank.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "ED807 API",
                description = "API для ведения (добавление/редактирование/удаление " +
                        "записей) справочника кредитно-финансовых учреждений ED807", version = "0.0.1"
        ),
        security = @SecurityRequirement(name = "basicAuth")
)
@Configuration
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "basicAuth",
        scheme = "basic")

public class OpenApiConfig {
}
