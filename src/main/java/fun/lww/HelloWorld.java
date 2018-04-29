package fun.lww;

import fun.lww.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

    /*@Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @GetMapping({"/hello","/hi"})
    String say() {
        //return "girlProperties:"+girlProperties.toString();
        return "index";
    }
}
