package me.wonwoo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by wonwoo on 2016. 10. 25..
 */
public class MockServiceTest {

  @Mock
  private MockRepository mockRepository;

  private MockService mockService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockService = new MockService(mockRepository);
  }

  @Test
  public void findBynameTest() {
    //given
    given(mockRepository.findByname("wonwoo")).willReturn(new Account(1L, "wonwoo", "wonwoo@test.com"));
    //when
    final Account account = mockService.findByname("wonwoo");
    //then
    verify(mockRepository, atLeastOnce()).findByname(anyString());
    assertThat(account.getId(), is(1L));
    assertThat(account.getName(), is("wonwoo"));
    assertThat(account.getEmail(), is("wonwoo@test.com"));
  }

  @Test
  public void findAllTest() {
    //given
    given(mockRepository.findAll()).willReturn(Arrays.asList(
      new Account(1L, "wonwoo", "wonwoo@test.com"),
      new Account(2L, "test", "test@test.com")
    ));
    //when
    final List<Account> accounts = mockService.findAll();
    //then
    assertThat(accounts, hasItems(hasProperty("name", is("wonwoo")),hasProperty("name", is("test"))));
    assertThat(accounts, hasItems(hasProperty("email", is("wonwoo@test.com")),hasProperty("email", is("test@test.com"))));
  }
}
