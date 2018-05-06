package fun.lww.service;

import fun.lww.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void insertGirl() {
        girlService.insertGirl();
    }

    @Test
    public void getAge() {
        Integer id = 8;
        girlService.findAge(id);
    }

    @Test
    public void getGirl() {
        Integer id = 1;
        Girl girl = girlService.findGirl(id);
        System.out.println(girl.toString());
        //Assert.assertEquals(new Integer(13), girl.getAge());
    }
}