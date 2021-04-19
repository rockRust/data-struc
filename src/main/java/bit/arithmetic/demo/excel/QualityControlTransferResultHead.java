package bit.arithmetic.demo.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author jiaosong
 * @desc
 * @date 2021/3/12
 */
@Data
public class QualityControlTransferResultHead {


    /**
     * 任务id
     */
    @ExcelProperty("任务ID")
    private Integer id;


    @ExcelProperty(value = "备注")
    private String remark;

}
