package com.tkg.MasterSystem.dto;

import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Continent;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;
import lombok.Data;

@Data
public class GeoLiteDto {

    private String ipAddress;

    private String countryCode;

    private String country;

    private String continentCode;

    private String continentName;

    private String regionCode;

    private String regionName;

    private String city;

    private String zipCode;

    private Double latitude;

    private Double longitude;

    private String timeZone;

    public GeoLiteDto(){}

    public GeoLiteDto( CityResponse cityResponse){
        Country countryRecord = cityResponse.getCountry();
        Continent continentRecord = cityResponse.getContinent();
        Subdivision subdivisionRecord = cityResponse.getSubdivisions().get(0);
        City cityRecord = cityResponse.getCity();
        this.ipAddress = cityResponse.getTraits().getIpAddress();
        this.countryCode = countryRecord.getIsoCode();
        this.country = countryRecord.getName();
        this.continentCode = continentRecord.getCode();
        this.continentName = continentRecord.getName();
        this.regionCode = subdivisionRecord.getIsoCode();
        this.regionName = subdivisionRecord.getName();
        this.city = cityRecord.getName();
        this.latitude = cityResponse.getLocation().getLatitude();
        this.longitude = cityResponse.getLocation().getLongitude();
        this.timeZone = cityResponse.getLocation().getTimeZone();
    }


}
