package com.mycompany.oiw.Content;

import android.media.Image;
import android.widget.ImageView;
import android.widget.ListView;

import com.mycompany.oiw.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechContent {

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;


    public static List <TechItem> T_ITEMS = new ArrayList<TechItem>();
    public static Map<Integer, TechItem> T_ITEM_MAP = new HashMap<>();
    static {
        addItem(new TechItem(1, "", 4));
        addItem(new TechItem(2, "", 5));
        addItem(new TechItem(3, "", 6));
        addItem(new TechItem(4, "", 7));
        addItem(new TechItem(5, "", 8));
        addItem(new TechItem(6, "", 9));
    }

    private static void addItem(TechItem item) {
        T_ITEMS.add(item);
        T_ITEM_MAP.put(item.id, item);
    }

    public static class TechItem {
        public int id;
        public String content;
        public int image;


        public TechItem(int id, String content, int image) {
            this.id = id;
            this.content = content;
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
