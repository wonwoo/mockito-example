package me.wonwoo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;

/**
 * Created by wonwoo on 2016. 11. 30..
 */
@RunWith(MockitoJUnitRunner.class)
public class ExpectedExceptionTest {

  @Mock
  private MockRepository mockRepository;

  @InjectMocks
  private MockService mockService;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void findByemailTest() {
    exception.expect(EmailNotFoundException.class);
    given(mockRepository.findByEmail(anyObject())).willReturn(null);
    mockService.findByEmail("123123");
  }
}
