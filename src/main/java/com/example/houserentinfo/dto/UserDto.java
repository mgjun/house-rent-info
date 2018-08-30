package com.example.houserentinfo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {
    private Long userId;
    private String username;
    private String password;
    private Integer userAge;
    private String userSex;
    private String idCard;
    private String idCardImage;
    private String phoneNumber;
    private String imPhoneNumber;
    private Long roleId;
}
