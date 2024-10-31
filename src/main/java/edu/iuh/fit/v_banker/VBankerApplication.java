package edu.iuh.fit.v_banker;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "V-Banker",
		version = "1.0",
		description = "Backend APIs for V-Banker",
		contact = @Contact(
				name = "Tran Thi Thuy Vy",
				email = "tranvy.art@gmail.com",
				url = "https://github.com/tranvy57/v-banker"
		),
		license = @License(
				name = "Tran Thi Thuy Vy",
				url = "https://github.com/tranvy57/v-banker"
		)
	),
		externalDocs = @ExternalDocumentation(
				description = "V-Banker Documentation",
				url = "https://github.com/tranvy57/v-banker"
		)
)
public class VBankerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VBankerApplication.class, args);
	}

}
