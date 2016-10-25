package me.wonwoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

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
    given(mockRepository.findByname(anyObject())).willReturn(new Account(1L, "wonwoo", "wonwoo@test.com"));
    //when
    final Account account = mockService.findByname("123123");
    //then
    assertThat(account.getId(), is(1L));
    assertThat(account.getName(), is("wonwoo"));
    assertThat(account.getEmail(), is("wonwoo@test.com"));
  }
}
