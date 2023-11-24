package com.example.pojo;

import lombok.*;

/**
 * ClassName: User
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/6 16:18
 * @Version 1.0
 */
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@AllArgsConstructor//无参构造
@NoArgsConstructor// 全餐构造
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;


    // lombok利用简单的注解可以省略下面这些讨厌的代码
//    public User() {
//    }
//
//    public User(Integer id, String name, Short age, Short gender, String phone) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.phone = phone;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Short getAge() {
//        return age;
//    }
//
//    public Short getGender() {
//        return gender;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Short age) {
//        this.age = age;
//    }
//
//    public void setGender(Short gender) {
//        this.gender = gender;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", phone='" + phone + '\'' +
//                '}';
//    }
}
