package bit.arithmetic.demo.excel.bug;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jiaosong
 * @desc
 * @date 2021/4/6
 */
@Data
public class HeadType {


    /**
     * 任务id
     */
    @ExcelProperty("任务ID")
    private Integer id;


    @ExcelProperty(value = "备注1")
    private String firstRemark;

    @ExcelProperty(value = "备注2")
    private String secRemark;

}
