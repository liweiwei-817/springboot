package fun.lww.controller;

import fun.lww.entity.Girl;
import fun.lww.repository.GirlRepository;
import fun.lww.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/girl")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/list")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /*@PostMapping("/add")
    public Girl girlAdd(@RequestParam(value = "cupSize", required = false) String cupSize,
                   @RequestParam(value = "age", required = false) Integer age) {
        Girl girl = new Girl(cupSize, age);
        return girlRepository.save(girl);
    }*/
    @PostMapping("/add")
    public Girl girlAdd(@Valid Girl g,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Girl girl = new Girl(g.getCupSize(), g.getAge());
        return girlRepository.save(girl);
    }

    @GetMapping("/sel/{id}")
    public Girl girlSel(@PathVariable("id") Integer id) {
        return girlRepository.getOne(id);
    }

    @PostMapping("/up")
    public Girl girlUpdate(@RequestParam(name = "id", required = true) Integer id,
                    @RequestParam(name = "cupSize", required = false) String cupSize,
                    @RequestParam(name = "age", required = false) Integer age) {
        Girl girl = new Girl(cupSize, age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    @DeleteMapping("/del/{id}")
    public String girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
        return "删除成功";
    }

    @PostMapping("/addTwo")
    public void girlInsertTwo() {
        girlService.insertGirl();
    }
}
