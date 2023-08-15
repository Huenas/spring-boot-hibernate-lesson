package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addSillyMember() {
        System.out.println(getClass() + "Doing my DB Work : Adding a membership Account");

    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + "Gtg sleep");


    }
}
