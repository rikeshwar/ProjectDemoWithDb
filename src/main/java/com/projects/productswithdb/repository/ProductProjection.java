package com.projects.productswithdb.repository;

public interface ProductProjection {
    Long getIddd();//while working with native query sql...hibernate presume you know
    //exact column name in database so this won't work
    //while in Hql hibernate will come for rescue...but its compulsory to use
    //alis for column name to take help of the hibernate
    String getNameee();

}
