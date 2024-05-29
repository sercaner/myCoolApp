package com.udemy.myCoolApp.dao;

import com.udemy.myCoolApp.Account;

public interface AccountDAO {

    void addAccount(Account  theAccount, boolean vipFlag);

    boolean doWork();
}
