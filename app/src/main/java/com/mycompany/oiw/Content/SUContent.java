package com.mycompany.oiw.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SUContent {



    public static List<SUItem> SU_ITEMS = new ArrayList<SUItem>();
    public static Map<Integer, SUItem> SU_ITEM_MAP = new HashMap<>();
    static {
        addItem(new SUItem(10, ""));
        addItem(new SUItem(11, ""));
    }

    private static void addItem(SUItem item) {
        SU_ITEMS.add(item);
        SU_ITEM_MAP.put(item.id, item);
    }

    public static class SUItem {
        public int id;
        public String content;

        public SUItem(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

}
