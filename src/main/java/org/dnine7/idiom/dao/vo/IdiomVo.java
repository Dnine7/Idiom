package org.dnine7.idiom.dao.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dnine7.idiom.dao.Idiom;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdiomVo extends Idiom {
    private String group;
    private String type;
    private String typeColor;
    private String groupColor;
}
