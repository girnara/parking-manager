package girnara.abhay.parking.application.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import girnara.abhay.parking.application.config.ParkingConfig;
/**
 * Created by abhay on 30/03/19.
 */
@Configuration
public class BeanInstantiation {
    private static Logger LOGGER = LoggerFactory.getLogger(BeanInstantiation.class);
    public static final String SERVICE_NAME = "Parking";

    @Autowired
    private ParkingConfig parkingConfig;
    @Bean(name = "serviceName")
    public String getServiceName() {
        return parkingConfig.getServiceName();
    }
}
