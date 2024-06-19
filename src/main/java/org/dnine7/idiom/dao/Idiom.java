package org.dnine7.idiom.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@TableName("Idiom")
public class Idiom {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String mean;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long typeId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long groupId;

    @TableField(exist = false)
    private String group;
    @TableField(exist = false)
    private String type;
    @TableField(exist = false)
    private String typeColor;
    @TableField(exist = false)
    private String groupColor;
}
