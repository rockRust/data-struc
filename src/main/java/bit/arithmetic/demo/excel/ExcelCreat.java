package bit.arithmetic.demo.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.collect.Lists;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author jiaosong
 * @desc
 * @date 2020/4/6
 */
public class ExcelCreat {


    public static void main(String[] args) throws FileNotFoundException {
        List<QualityControlResultVO> data = getData();
        ExcelWriter excelWriter = null;
        excelWriter = EasyExcel.write(new FileOutputStream("all.xlsx")).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(1, "test")
                .head(QualityControlTransferResultHead.class)
                .build();
        excelWriter.write(data, writeSheet);
        excelWriter.finish();
    }

    private static List<QualityControlResultVO> getData() {
        QualityControlResultVO vo = new QualityControlResultVO();
        vo.setId(738);
        vo.setRemark("1222");
        return Lists.newArrayList(vo);
    }
}
