package com.mycompany.oiw.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sony on 3/30/2015.
 */
public class BusContent {



    public static List<BusItem> B_ITEMS = new ArrayList<BusItem>();
    public static Map<Integer, BusItem> B_ITEM_MAP = new HashMap<>();
    static {
        addItem(new BusItem(7, ""));
        addItem(new BusItem(8, ""));
        addItem(new BusItem(9, ""));
    }

    private static void addItem(BusItem item) {
        B_ITEMS.add(item);
        B_ITEM_MAP.put(item.id, item);
    }

    public static class BusItem {
        public int id;
        public String content;

        public BusItem(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
