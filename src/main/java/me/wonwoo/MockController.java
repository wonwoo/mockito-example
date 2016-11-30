package me.wonwoo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by wonwoo on 2016. 11. 30..
 */

@RestController
@RequestMapping("/mock")
public class MockController {

  @GetMapping
  public ResponseEntity<?> file() throws IOException {
    String contentDispositionValue = "attachment; filename=\"dummy.txt\"";
    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add("Content-Type", "application/txt");
    headers.add("Content-Disposition", contentDispositionValue);
    Path path = Paths.get("dummy.txt");
    byte[] data = Files.readAllBytes(path);
    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
