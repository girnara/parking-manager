package girnara.abhay.parking.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhay on 30/03/19.
 */
@SpringBootApplication
@ComponentScan("girnara.abhay.parking")
@EnableSwagger2
@EnableAutoConfiguration
public class ParkingCoreApplication {

    /**
     * Detail Project documentations can be found at confluence :
     * https://github.com/girnara/parking-manager
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception{

        SpringApplication.run(ParkingCoreApplication.class, args);

    }


    /**
     * Swagger settings docket.
     *
     * @return the docket
     */
    @Bean
    public Docket swaggerSettings() {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("X-ACCESS-TOKEN").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo()).pathMapping("/").globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Parking Service REST API",
            "Parking Service REST API",
            "1.0",
            "Terms of service",
            new Contact("Abhay Girnara", "https://abhay.girnara", "girnara.abhay@gmail.com"),
            "© 2019 abhay.girnara",
            "https://abhay.girnara");
        return apiInfo;
    }
}
