package me.wonwoo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;

/**
 * Created by wonwoo on 2016. 11. 30..
 */
@RunWith(MockitoJUnitRunner.class)
public class ErrorCollectorTest {

  @Rule
  public ErrorCollector collector = new ErrorCollector();

  @Mock
  private MockRepository mockRepository;

  @InjectMocks
  private MockService mockService;

  @Test
  public void findByemailTest() {
    collector.addError(new Throwable("first error"));
    collector.addError(new Throwable("second error"));
    given(mockRepository.findByEmail(anyObject())).willReturn(new Account(1L,"wonwoo", "wonwoo@test.com"));
    final Account account = mockService.findByEmail("123123");
    collector.checkThat(account.getEmail(), is("wonwoo"));
    collector.checkThat(account.getId(), is(2L));
  }
}
