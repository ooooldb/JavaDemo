package com.xiayu.online.core.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = -4990810027542971546L;
    private String id;
    private String name;
    private String code;
    private String description;

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt() % 8 + 1);
    }
}