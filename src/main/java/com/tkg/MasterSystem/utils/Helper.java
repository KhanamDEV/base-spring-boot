package com.tkg.MasterSystem.utils;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.tkg.MasterSystem.dto.GeoLiteDto;
import com.tkg.MasterSystem.entities.AuthenticationHistoryEvent;
import com.tkg.MasterSystem.entities.enums.AuthenticationHistoryEventTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class Helper {

    @Autowired
    Environment environment;

    public static String makeModelAuthEvent(AuthenticationHistoryEventTypeEnum typeEnum, Long userId, String ipAddress) {
        return "";
    }

    public GeoLiteDto getGeoLocation(String ip) {
        try {
            WebServiceClient client = new WebServiceClient
                    .Builder(Integer.parseInt(environment.getProperty("GEOLITE_ACCOUNT_ID")), environment.getProperty("GEOLITE_LICENSE_KEY"))
                    .host("geolite.info")
                    .build();
            InetAddress ipAddress = InetAddress.getByName("1.55.69.156");
            CityResponse cityResponse = client.city(ipAddress);
            return new GeoLiteDto(cityResponse);
        } catch (Exception e) {
            return new GeoLiteDto();
        }
    }
}
