package me.wonwoo;

import java.util.List;

/**
 * Created by wonwoo on 2016. 10. 25..
 */
public interface MockRepository {

  List<Account> findAll();

  Account findByname(String name);
}
