package com.example.houserentinfo.entity;

import com.example.houserentinfo.dto.UserDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TblUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String password;

    @Column(name = "USER_AGE")
    private Integer userAge;

    @Column(name = "USER_SEX")
    private String userSex;

    @Column(name = "ID_CARD")
    private String idCard;

    @Column(name = "ID_CARD_IMAGE")
    private String idCardImage;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "IM_PHONE_NUMBER")
    private String imPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ROLE_ID")
    private TblRole tblRole;


    public static TblUser mapping(UserDto userDto, TblRole tblRole, TblUser savedUser) {
        if (savedUser == null) {
            return builder().build().mappingCreation(userDto,tblRole);
        } else {
            return savedUser.mappingUpdate(userDto,tblRole);
        }
    }

    private TblUser mappingCreation(UserDto userDto, TblRole tblRole) {
        return builder()
                .userName(userDto.getUsername())
                .password(userDto.getPassword())
                .userAge(userDto.getUserAge())
                .userSex(userDto.getUserSex())
                .idCard(userDto.getIdCard())
                .idCardImage(userDto.getIdCardImage())
                .phoneNumber(userDto.getPhoneNumber())
                .imPhoneNumber(userDto.getImPhoneNumber())
                .tblRole(tblRole)
                .build();
    }

    private TblUser mappingUpdate(UserDto userDto, TblRole tblRole) {
        this.userName = userDto.getUsername();
        this.password = userDto.getPassword();
        this.userAge = userDto.getUserAge();
        this.userSex = userDto.getUserSex();
        this.idCard = userDto.getIdCard();
        this.idCardImage = userDto.getIdCardImage();
        this.phoneNumber = userDto.getPhoneNumber();
        this.imPhoneNumber = userDto.getImPhoneNumber();
        this.tblRole = tblRole;
        return this;
    }


    public static UserDto convert(TblUser tblUser) {
        return UserDto.builder()
                .userId(tblUser.getUserId())
                .username(tblUser.getUserName())
                .password(tblUser.getPassword())
                .userAge(tblUser.getUserAge())
                .userSex(tblUser.getUserSex())
                .idCard(tblUser.getIdCard())
                .idCardImage(tblUser.getIdCardImage())
                .phoneNumber(tblUser.getPhoneNumber())
                .imPhoneNumber(tblUser.getImPhoneNumber())
                .roleId(tblUser.getTblRole().getRoleId())
                .build();
    }

}
