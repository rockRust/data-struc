package bit.arithmetic.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jiaosong
 * @desc
 * @date 2021/3/12
 */
@Data
public class QualityControlResultVO {
    /**
     * 任务id
     */
    @ExcelProperty("任务ID")
    private Integer id;

    @ExcelProperty("红线")
    private String red;

    @ExcelProperty("备注")
    private String remark;
}
