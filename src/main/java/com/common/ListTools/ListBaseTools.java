package com.common.ListTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CommonTools
 * com.common.ListTools
 * 2022/11/20
 **/
public class ListBaseTools {
    public boolean ThasValue(List<Objects> list, Objects value) {
        for (Objects item : list) {
            if (Objects.equals(value, item)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValueString(List<String> contains, String key) {
        for (String item : contains) {
            if (item.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public List DeleteSameItem(List a,List b)
    {   List res=new ArrayList();
        if(a.size()>=b.size()) {
            a.removeAll(b);
            res=a;
        }
        else
        {
            b.removeAll(b);
            res=b;
        }
        return res;
    }
}
