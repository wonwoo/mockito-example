package me.wonwoo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by wonwoo on 2016. 11. 30..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MockControllerTest {

  @Rule
  public final TemporaryFolder folder = new TemporaryFolder();

  private final RestTemplate restTemplate = new RestTemplate();

  @LocalServerPort
  private int port;

  @Test
  public void fileDownloadTxt() throws IOException {
    final byte[] body = downloadTxt("/mock");
    final File file = writeTxt(body);

    //
    System.out.println(file.getAbsoluteFile());
  }

  public String createUrl(String context) {
    return "http://localhost:" + port + context;
  }

  protected File writeTxt(byte[] body) throws IOException {
    File txtFile = folder.newFile();
    OutputStream stream = new FileOutputStream(txtFile);
    try {
      stream.write(body);
    } finally {
      stream.close();
    }
    return txtFile;
  }
  private byte[] downloadTxt(String context) {
    return restTemplate.getForObject(createUrl(context), byte[].class);
  }
}