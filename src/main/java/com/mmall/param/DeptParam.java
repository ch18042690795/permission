package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-04 09:23
 **/
@Getter
@Setter
@ToString
public class DeptParam {
    private Integer id;
    @NotBlank(message = "部门名称不能为空")
    @Length(max=15,min=2,message = "部门名称长度需要在2-15之间")
    private String name;
    private Integer parentId;
    @NotNull(message = "展示的顺序不可以为空")
    private Integer seq;
    @Length(max=150,message = "备注长度需要在150个字之内")
    private String remark;
}
