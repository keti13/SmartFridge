package ge.gtu.smartfridgewebapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RepositoryTest {
    @Autowired private Repository repo;

    @Test
    public void testListAll(){
        Iterable<Food> foods = repo.findAll();
        Assertions.assertThat(foods).hasSizeGreaterThan(0);
        for(Food food : foods){
            System.out.println(food);
        }
    }

}
