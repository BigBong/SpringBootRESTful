package org.community.service;

import org.community.domain.UserPrivilege;
import org.community.domain.UserPrivilegeExample;
import org.community.mapper.UserPrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frodoking on 2017/1/16.
 */
@Service
public class UserPrivilegeService {
    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    public List<UserPrivilege> getPrivilegesById(Integer id) {
        UserPrivilegeExample example = new UserPrivilegeExample();
        UserPrivilegeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userPrivilegeMapper.selectByExample(example);
    }
}
