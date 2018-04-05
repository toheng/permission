package com.hengo.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Hengo.
 * 2018/4/5 18:09
 */
@Data
public class TestVo {

    @NotBlank
    private String msg;

    @NotNull(message = "id不可以为空")
    @Max(value = 10, message = "id 不能大于10")
    @Min(value = 0, message = "id 至少大于等于0")
    private Integer id;

    // @NotEmpty
    private List<String> str;

}
