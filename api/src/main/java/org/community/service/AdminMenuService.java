package org.community.service;

import org.community.domain.*;
import org.community.mapper.AdminMenuGroupMapper;
import org.community.mapper.AdminMenuItemMapper;
import org.community.mapper.AdminMenuSubGroupMapper;
import org.community.service.vo.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frodoking on 2017/7/21.
 */
@Service
public class AdminMenuService {

    @Autowired
    private AdminMenuGroupMapper adminMenuGroupMapper;
    @Autowired
    private AdminMenuSubGroupMapper adminMenuSubGroupMapper;
    @Autowired
    private AdminMenuItemMapper adminMenuItemMapper;

    public AdminMenu adminMenuGroupList() {
        AdminMenu adminMenu = new AdminMenu();

        AdminMenuGroupExample example = new AdminMenuGroupExample();
        List<AdminMenuGroup> list = adminMenuGroupMapper.selectByExample(example);
        adminMenu.groups = new ArrayList<>(list.size());
        for (AdminMenuGroup group: list) {
            AdminMenu.Group g = new AdminMenu.Group();
            adminMenu.groups.add(g);
            g.name = group.getTitle();

            AdminMenuSubGroupExample subGroupExample = new AdminMenuSubGroupExample();
            AdminMenuSubGroupExample.Criteria criteria = subGroupExample.createCriteria();
            criteria.andParentGroupIdEqualTo(group.getId());
            List<AdminMenuSubGroup> subGroupList = adminMenuSubGroupMapper.selectByExample(subGroupExample);

            g.groupItems = new ArrayList<>(subGroupList.size());
            for (AdminMenuSubGroup subGroup: subGroupList) {
                AdminMenu.GroupItem gi = new AdminMenu.GroupItem();
                g.groupItems.add(gi);
                gi.icon = subGroup.getIconClass();
                gi.name = subGroup.getTitle();

                AdminMenuItemExample itemExample = new AdminMenuItemExample();
                AdminMenuItemExample.Criteria itemCriteria= itemExample.createCriteria();
                itemCriteria.andParentGroupIdEqualTo(subGroup.getId());
                List<AdminMenuItem> itemList = adminMenuItemMapper.selectByExample(itemExample);

                gi.items = new ArrayList<>(itemList.size());

                for (AdminMenuItem item: itemList) {
                    AdminMenu.Item i = new AdminMenu.Item();
                    gi.items.add(i);
                    i.name = item.getTitle();
                    i.url = item.getHref();
                }
            }
        }

        return adminMenu;
    }
}
