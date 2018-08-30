package com.example.houserentinfo.service.impl;

import com.example.houserentinfo.entity.TblRole;
import com.example.houserentinfo.entity.TblUser;
import com.example.houserentinfo.repository.TblRoleRepository;
import com.example.houserentinfo.repository.TblUserRepository;
import com.example.houserentinfo.service.TblUserService;
import com.example.houserentinfo.dto.UserDto;
import com.example.jooq.tables.records.TblUserRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.UpdateConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.example.jooq.tables.TblUser.TBL_USER;

@Service("tblUserService")
public class TblUserServiceImpl implements TblUserService {

    private TblUserRepository tblUserRepository;
    private TblRoleRepository tblRoleRepository;
    private DSLContext dslContext;

    @Autowired
    public TblUserServiceImpl(TblUserRepository tblUserRepository,
                              TblRoleRepository tblRoleRepository,
                              DSLContext dslContext) {
        this.tblUserRepository = tblUserRepository;
        this.tblRoleRepository = tblRoleRepository;
        this.dslContext = dslContext;
    }

    @Override
    @Transactional
    public void saveOrUpdate(UserDto userDto) {
        TblUser tblUser = null;
        if (!StringUtils.isEmpty(userDto.getUserId())) {
            tblUser = tblUserRepository.findById(userDto.getUserId()).orElse(null);
        }
        Optional<TblRole> role = tblRoleRepository.findById(userDto.getRoleId());
        if(role.isPresent()) {
            TblUser mapping = TblUser.mapping(userDto, role.get(), tblUser);
            tblUserRepository.save(mapping);
        }
    }


    @Override
    public void changePassword(String username, String password) {
        UpdateConditionStep<TblUserRecord> updatePasswordSql = dslContext.update(TBL_USER).set(TBL_USER.PASS_WORD, password).where(TBL_USER.USER_NAME.equal(username));
        updatePasswordSql.execute();
//        tblUserRepository.executeUpdate(updatePasswordSql);
    }

    @Override
    public UserDto findById(Long userId) {
        Optional<TblUser> userOptional = tblUserRepository.findById(userId);
        if(userOptional.isPresent()) {
            return TblUser.convert(userOptional.get());
        }
        return new UserDto();
    }

    @Override
    public TblUser findByUserName(String userName) {
        return tblUserRepository.findByUserName(userName);
    }

    @Override
    public UserDto findByIdCard(String idCard) {
        SelectConditionStep<Record> query = dslContext.select(TBL_USER.fields())
                .from(TBL_USER)
                .where(TBL_USER.ID_CARD.equal(idCard));
        List<TblUser> tblUsers = tblUserRepository.nativeQuery(query, TblUser.class);
        if(tblUsers != null && tblUsers.size() > 0) {
            return TblUser.convert(tblUsers.get(0));
        }
        return null;
    }

    @Override
    public List<TblUser> pageAndSortUserList(UserDto userDto) {
        return null;
    }

}
