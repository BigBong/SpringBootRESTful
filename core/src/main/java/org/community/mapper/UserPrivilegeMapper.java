package org.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.community.domain.UserPrivilege;
import org.community.domain.UserPrivilegeExample;

import java.util.List;

@Mapper
public interface UserPrivilegeMapper {
    int countByExample(UserPrivilegeExample example);

    int deleteByExample(UserPrivilegeExample example);

    int insert(UserPrivilege record);

    int insertSelective(UserPrivilege record);

    List<UserPrivilege> selectByExampleWithRowbounds(UserPrivilegeExample example, RowBounds rowBounds);

    List<UserPrivilege> selectByExample(UserPrivilegeExample example);

    int updateByExampleSelective(@Param("record") UserPrivilege record, @Param("example") UserPrivilegeExample example);

    int updateByExample(@Param("record") UserPrivilege record, @Param("example") UserPrivilegeExample example);
}