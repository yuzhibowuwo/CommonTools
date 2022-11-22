package com.util.compare;


import com.alibaba.fastjson2.JSONObject;
import com.common.ListTools.ListBaseTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class JsonContain {
    //输入参数接口文档中所有字符，后台截取的请求 返回结果Map<List>Y List N list
    ListBaseTools listbase=new ListBaseTools();
    static List<String>contains=new ArrayList<String>();//接口请求一致
    static List<String>notContain=new ArrayList<String>();//接口有，请求没有
    static List<String>JsonHasInternoContain=new ArrayList<String>();//接口没有，请求有
    public JsonContain() {
        contains=new ArrayList<String>();
        notContain=new ArrayList<String>();
        JsonHasInternoContain=new ArrayList<String>();
    }
//get all keys
    public static void getAllKeys(JSONObject jsobj)
    {
        for(String key :jsobj.keySet())
        {
            JsonHasInternoContain.add(key);
            Object temp = jsobj.get(key);
            if (temp instanceof JSONObject) {
                JSONObject new_name = (JSONObject) temp;
                 getAllKeys(new_name);
            }
        }
    }


    //juedege mulitLevel contains keyword
    public static boolean mulitLevelJson(JSONObject jsobj,String target,boolean result)
    {
        if(!result) {
            for(String key :jsobj.keySet()) {
                if(target.equals(key)) {
                    contains.add(key);
                    return true;
                }
                Object temp = jsobj.get(key);
                if (temp instanceof JSONObject) {
                    JSONObject new_name = (JSONObject) temp;
                    result = mulitLevelJson(new_name,target, false);
                }
                if(result)
                {
                    return result;
                }
            }
        }
        return result ;
    }


    public Map<String, List<String>> JsonJudge(String list[],String js)
    {
        Map<String, List<String>> res=new HashMap<>();
        JSONObject jsobj=JSONObject.parseObject(js);
        getAllKeys(jsobj);
        //区分两种情况，一种list.size>json的key值的，还有一种list.size<json.key
        for(int i=0;i<list.length;i++)
        {
            if(mulitLevelJson(jsobj,list[i],false)==false)
                notContain.add(list[i]);
        }
        JsonHasInternoContain.removeAll(contains);
        res.put("exist",contains );
        res.put("nothingness",notContain);
        res.put("jsonmaore",JsonHasInternoContain);
        return res;
    }

}
