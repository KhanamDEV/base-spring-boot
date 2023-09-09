package com.tkg.MasterSystem.entities;

import com.tkg.MasterSystem.entities.enums.AuthenticationHistoryEventTypeEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "authentication_history_events")
public class AuthenticationHistoryEvent {
    public AuthenticationHistoryEvent(){}



    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    
    @Column(nullable = false)
    private Long userId;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthenticationHistoryEventTypeEnum type;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private String ipType;

    @Column(nullable = false, length = 2)
    private String continentCode;

    @Column(nullable = false, length = 20)
    private String continentName;

    @Column(nullable = false, length = 2)
    private String countryCode;

    @Column(nullable = false, length = 60)
    private String countryName;

    @Column(nullable = false, length = 2)
    private String regionCode;

    @Column(nullable = false, length = 60)
    private String regionName;

    @Column(nullable = false, length = 60)
    private String city;

    @Column(nullable = false, length = 10)
    private String zipCode;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private String timeZone;

    @Column(nullable = false)
    private String connectionIsp;

    public AuthenticationHistoryEvent(Long userId, AuthenticationHistoryEventTypeEnum type, String ipAddress, String ipType, String continentCode, String continentName, String countryCode, String countryName, String regionCode, String regionName, String city, String zipCode, String latitude, String longitude, String timeZone, String connectionIsp, String platform, String device, String browser) {
        this.userId = userId;
        this.type = type;
        this.ipAddress = ipAddress;
        this.ipType = ipType;
        this.continentCode = continentCode;
        this.continentName = continentName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.city = city;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.connectionIsp = connectionIsp;
        this.platform = platform;
        this.device = device;
        this.browser = browser;
    }

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false)
    private String device;

    @Column(nullable = false)
    private String browser;

    @Column(nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
}
