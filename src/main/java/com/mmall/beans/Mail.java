package com.mmall.beans;

import lombok.*;

import java.util.Set;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-06 10:05
 **/
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private String subject;
    private String message;
    private Set<String> receivers;

}
