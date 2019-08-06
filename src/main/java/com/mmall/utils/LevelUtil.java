package com.mmall.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-04 09:55
 **/
public class LevelUtil {
    public final static String SEPARATOR=".";
    public final static String ROOT = "0";
    public static String calculateLevel(String parentLevel, Integer parentId){
        if(StringUtils.isBlank(parentLevel)){
                  return ROOT;
        }else{
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }
}
