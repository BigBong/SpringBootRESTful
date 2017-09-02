package org.community.service.vo;

import java.util.List;

/**
 * Created by frodoking on 2017/7/15.
 */
public class AdminMenu {
    public List<Group> groups;

    public static class Group {
        public String name;
        public List<GroupItem> groupItems;
    }

    public static class GroupItem {
        public String icon;
        public String name;
        public List<Item> items;
    }

    public static class Item {
        public String name;
        public String url;
    }
}
