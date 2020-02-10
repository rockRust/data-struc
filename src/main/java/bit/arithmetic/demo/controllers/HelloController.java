package bit.arithmetic.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaosong
 * @desc
 * @date 2020/1/8
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/index")
    public String hello() {
        return "hello";
    }
}
