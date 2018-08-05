package pers.xiaoming.elasticsearch_springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pers.xiaoming.elasticsearch_springboot.Main;
import pers.xiaoming.elasticsearch_springboot.dao.IBlogDao;
import pers.xiaoming.elasticsearch_springboot.dao.InitDB;
import pers.xiaoming.elasticsearch_springboot.model.Blog;

import java.util.List;

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
    public void testSearchByTitle() {
        String[] titlePrefixes = InitDB.getTITLE_PREFIXES();
        for (String title : titlePrefixes) {
            Blog blog = service.searchByTitle(title);
            log.info("Search by Title from ES : search {}, \nresult {}", title, blog);
            Assert.assertEquals(dbInit.getTitleToBlogMap().get(title), blog);
        }
    }

    @Test
    public void testSearchByAuthor() {
        String[] authors = InitDB.getAUTHORS();
        for (String author : authors) {
            List<Blog> blogs = service.searchByAuthor(author);
            log.info("Search by Authors from ES : search {}, \nresult {}", author, blogs);
            Assert.assertSame(dbInit.getAuthorToBlogMap().get(author).size(), blogs.size());
        }
    }

    @Test
    public void testSearchByAuthorWithPage() {
        String[] authors = InitDB.getAUTHORS();
        for (String author : authors) {
            Page<Blog> blogs = service.searchByAuthor(author, PageRequest.of(0, 10));
            log.info("Search by Author with page from ES : search {}, \nresult {}", author, blogs);
            Assert.assertSame((long) dbInit.getAuthorToBlogMap().get(author).size(), blogs.getTotalElements());
        }
    }

    @Test
    public void testSearchByAuthorNot() {
        String[] authors = InitDB.getAUTHORS();
        for (String author : authors) {
            List<Blog> blogs = service.searchByAuthorNot(author);
            log.info("Search by NOT Authors from ES : search {}, \nresult {}", author, blogs);
            Assert.assertSame(InitDB.getNumOfDataGenerate() - dbInit.getAuthorToBlogMap().get(author).size(), blogs.size());
        }
    }

    @Test
    public void testSearchByContent() {
        String[] authors = InitDB.getAUTHORS();
        for (String contentQuery : authors) {
            List<Blog> blogs = service.searchByContent(contentQuery);
            log.info("Search by Content from ES : search {}, \nresult {}", contentQuery, blogs);
        }
    }
}
