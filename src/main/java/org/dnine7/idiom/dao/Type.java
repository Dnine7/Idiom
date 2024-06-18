package org.dnine7.idiom.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("type")
public class Type {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
}