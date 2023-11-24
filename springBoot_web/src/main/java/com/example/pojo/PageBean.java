package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageBean
 * Description:
 *
 * @Author snuonuo
 * @Create 2023/11/11 16:04
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long total; //总记录数
    private List rows; //数据列表
}
