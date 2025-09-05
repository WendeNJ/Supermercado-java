package Supermercado.Program.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do Supermercado")
                        .version("1.0")
                        .description("API para gerenciamento de estoque, vendas e relatórios")
                        .contact(new Contact()
                                .name("Wenderson")
                                .email("voce@meusite.com.br")
                                .url("http://www.meusite.com.br"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação adicional")
                        .url("http://www.meusite.com.br/docs"));
    }
}
