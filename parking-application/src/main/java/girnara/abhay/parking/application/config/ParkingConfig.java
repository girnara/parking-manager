package girnara.abhay.parking.application.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

/**
 * Created by abhay on 30/03/19.
 */
@Configuration
@Data
public class ParkingConfig implements Serializable {
    private static final long serialVersionUID = -7367839171438168711L;
    @Value("${service.name}")
    private String serviceName;
}
