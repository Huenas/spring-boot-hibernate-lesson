package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose ... simulate an exception
        if(tripWire){
            throw new RuntimeException("No soup for you!!!!");
        }
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account myAccount1 = new Account("Jose", "1");
        Account myAccount2 = new Account("Alib", "2");
        Account myAccount3 = new Account("Lucas", "3");
        // add them to our accounts list
        myAccounts.add(myAccount1);
        myAccounts.add(myAccount2);
        myAccounts.add(myAccount3);
        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + "Doing my DB Work : Adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "DoWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + "getNameeeeeeeeeeeeeeeeee()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "setNameeeeeeeeeeeeeeeeeeeeeeeeeee()");

        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "getServiceCodeeeeeeeeeeeeeeeee()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "setServiceCodeeeeeeeeeeeeeeeee()");

        this.serviceCode = serviceCode;
    }
}
