package com.callioni.assignment1;

import com.callioni.assignment1.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-29T09:21:09")
@StaticMetamodel(EOrder.class)
public class EOrder_ { 

    public static volatile SingularAttribute<EOrder, Date> dateOfPurchase;
    public static volatile SingularAttribute<EOrder, Long> id;
    public static volatile SingularAttribute<EOrder, Customer> customer;

}