package pers.xiaoming.elasticsearch_springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pers.xiaoming.elasticsearch_springboot.Main;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.dao.InitDB;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.Optional;

@SpringBootTest(classes = Main.class)
@Slf4j
public class ElasticSearchServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SearchService service;

    @Autowired
    private IBlogDao dao;

    private static InitDB dbInit;

    @BeforeClass
    public void setup() {
        dbInit = new InitDB(dao);
        dbInit.initDB();
        service.refreshRepository();
    }

    @Test
    public void testFindByAuthor() {
        String[] titlePrefixes = InitDB.getTITLE_PREFIXES();
        for (String title : titlePrefixes) {
            Blog blog = service.searchByTitle(title);
            log.info("Find by Author ES: " + blog);
            Assert.assertEquals(dbInit.getTitleToBlogMap().get(title), blog);
        }
    }
}
