package es.codeurjc.test.rest;

import static org.testng.Assert.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemsControllerTestNGTest extends AbstractTestNGSpringContextTests{

    @LocalServerPort
    int port;

    @BeforeClass
    public void setPort(){
        System.setProperty("demo.server.port", port+"");
    }

    @Test
    public void testParallel() throws InterruptedException {
        Results results = Runner.path("classpath:es/codeurjc/test/rest/").parallel(1);
        assertTrue(results.getFailCount() == 0);
    }

}


