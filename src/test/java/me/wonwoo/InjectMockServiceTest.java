package me.wonwoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by wonwoo on 2016. 10. 25..
 */
@RunWith(MockitoJUnitRunner.class)
public class InjectMockServiceTest {

  @Mock
  private MockRepository mockRepository;

  @InjectMocks
  private MockService mockService;

  @Test
  public void findBynameTest() {
    //given
    given(mockRepository.findByname("wonwoo")).willReturn(new Account(1L, "wonwoo", "wonwoo@test.com"));
    //when
    final Account account = mockService.findByname("wonwoo");
    //then
    assertThat(account.getId(), is(1L));
    assertThat(account.getName(), is("wonwoo"));
    assertThat(account.getEmail(), is("wonwoo@test.com"));
  }
}
