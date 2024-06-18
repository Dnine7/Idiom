package org.dnine7.idiom.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Idiom")
public class Idiom {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String mean;
    private Long typeId;
    private Long groupId;

    @TableField(exist = false)
    private String group;
    @TableField(exist = false)
    private String type;
}
