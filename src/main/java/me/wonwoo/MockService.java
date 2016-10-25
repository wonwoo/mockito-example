package me.wonwoo;

import java.util.List;

/**
 * Created by wonwoo on 2016. 10. 25..
 */
public class MockService {

  private final MockRepository mockRepository;

  public MockService(MockRepository mockRepository) {
    this.mockRepository = mockRepository;
  }

  public List<Account> findAll() {
    return mockRepository.findAll();
  }

  public Account findByname(String name) {
    final Account account = mockRepository.findByname(name);
    //어쩌구 저쩌구
    mockRepository.findByname(name);
    return account;
  }
}
