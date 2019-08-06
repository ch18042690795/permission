package com.mmall.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mmall.dao.SysDeptMapper;
import com.mmall.dto.DeptLevelDto;
import com.mmall.model.SysDept;
import com.mmall.utils.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-04 11:13
 **/
@Service
public class SysTreeService {
    @Resource
    private SysDeptMapper sysDeptMapper;
    public List<DeptLevelDto> deptTree(){
          List<SysDept> deptList = sysDeptMapper.getAllDept();
          List<DeptLevelDto> dtoList= Lists.newArrayList();
          for(SysDept dept:deptList){
              DeptLevelDto dto=DeptLevelDto.adapt(dept);
              dtoList.add(dto);
          }
          return deptLevelDtoTree(dtoList);
    }
    public List<DeptLevelDto> deptLevelDtoTree(List<DeptLevelDto> dtoList){
        if(CollectionUtils.isEmpty(dtoList)){
             return Lists.newArrayList();
        }
        //multimap一个键可以对应多个值
        Multimap<String,DeptLevelDto> levelDeptMap= ArrayListMultimap.create();
        List<DeptLevelDto> rootList = Lists.newArrayList();
        for(DeptLevelDto dto:dtoList){
            levelDeptMap.put(dto.getLevel(),dto);
            if(LevelUtil.ROOT.equals(dto.getLevel())){
               rootList.add(dto);
            }
        }
   //按照seq从小到大进行排序
        Collections.sort(rootList,new Comparator<DeptLevelDto>(){

            public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                return o1.getSeq()-o2.getSeq();
            }
        });
        transformdeptTree(rootList,LevelUtil.ROOT,levelDeptMap);
        return rootList;
    }
    public void transformdeptTree(List<DeptLevelDto> deptLevelDtoList, String level, Multimap<String, DeptLevelDto> levelDeptMap){
            for(int i=0;i<deptLevelDtoList.size();i++){
               //遍历该层的每个元素
                DeptLevelDto deptLevelDto=deptLevelDtoList.get(i);
                //处理当前层级的数据
                String nextLevel = LevelUtil.calculateLevel(level,deptLevelDto.getId());
                //处理下一层
                List<DeptLevelDto> tempDeptList = (List<DeptLevelDto>) levelDeptMap.get(nextLevel);
                if(CollectionUtils.isNotEmpty(tempDeptList)){
                   //排序
                     Collections.sort(tempDeptList,deptLevelDtoComparator);
                    //设置下一层部门
                      deptLevelDto.setDeptList(tempDeptList);
                    //进入到下一层处理
                    transformdeptTree(tempDeptList,nextLevel,levelDeptMap);
                }
            }
    }
    public Comparator<DeptLevelDto> deptLevelDtoComparator=new Comparator<DeptLevelDto>() {
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return o1.getSeq()-o2.getSeq();
        }
    };
}
