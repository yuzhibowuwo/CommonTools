package com.common.tools;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Set;

public class RandomTools {
    //随机生成key值
    public Object RandomMapKey(Map<Object,Object> input)
    {
        Set<Object> temp=input.keySet();
        Object resObj=null;
        int seed=temp.size();
        SecureRandom rd=new SecureRandom();
        int res=0;
        res=rd.nextInt(seed);
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Object,Object> entry : input.entrySet()) {
            if(res==0)
            {resObj= entry.getKey();break;}
            else
                res--;
        }
        return resObj;
    }
    //随机生成value值
    public Object RandomMapValue(Map<Object,Object> input)
    {
        Set<Object> temp=input.keySet();
        Object resObj=null;
        int seed=temp.size();
        SecureRandom rd=new SecureRandom();
        int res=0;
        res=rd.nextInt(seed);
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<Object,Object> entry : input.entrySet()) {
            if(res==0)
            {resObj=  entry.getValue();break;}
            else
                res--;
        }
        return resObj;
    }

}
