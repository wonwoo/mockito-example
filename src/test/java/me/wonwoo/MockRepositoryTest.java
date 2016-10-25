package me.wonwoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.*;
/**
 * Created by wonwoo on 2016. 10. 25..
 */
@RunWith(MockitoJUnitRunner.class)
public class MockRepositoryTest {

  @Mock
  private MockRepository mockRepository;

  @Test
  public void findBynameTest() {
    //given
    given(mockRepository.findByname("wonwoo")).willReturn(new Account(1L, "wonwoo", "wonwoo@test.com"));
    //when
    final Account account = mockRepository.findByname("wonwoo");
//    final Account account1 = mockRepository.findByname("wonwoo");
    //then
    verify(mockRepository, times(1)).findByname("wonwoo");
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
    final List<Account> accounts = mockRepository.findAll();
    //then
    assertThat(accounts, hasItems(hasProperty("name", is("wonwoo")),hasProperty("name", is("test"))));
    assertThat(accounts, hasItems(hasProperty("email", is("wonwoo@test.com")),hasProperty("email", is("test@test.com"))));
  }

}
