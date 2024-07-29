package com.projects.productswithdb.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProductControllerTest {

    @Test//after starting the application will test this method
    //here we are just asserting whether 2==2 which is true so test pass
    public void HelloTest()
    {
        assert (2==2);
    }
    @Test
    public void TestSortingAlgo()
    {
        List<Integer> input=new  ArrayList<>(List.of(3,1,7,5));
        Collections.sort(input);
        assert (input.get(1)==3);
        assert (input.get(0)==1);
        assertEquals(16,input.get(2));//this version of assert is better as
        //it also show in output console that what is expected and what we got
        //carefull......first argument is always expected one
    }



}