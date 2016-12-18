package me.wonwoo;

import me.wonwoo.runner.MockitoJsonJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


/**
 * Created by wonwoo on 2016. 12. 18..
 */
@RunWith(MockitoJsonJUnitRunner.class)
public class SpringJsonTest {

  private JacksonTester<JsonTestObject> json;

  @Test
  public void jsonTest() throws IOException {
    assertThat(json, is(notNullValue()));

    final JsonTestObject jsonTestObject = json.readObject("/mapper.json");
    assertThat(jsonTestObject.getId(), is(1L));
    assertThat(jsonTestObject.getName(), is("wonwoo"));
  }


  private static class JsonTestObject {
    private Long id;
    private String name;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
