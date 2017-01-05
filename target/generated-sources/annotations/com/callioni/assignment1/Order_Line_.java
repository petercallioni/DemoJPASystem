package com.callioni.assignment1;

import com.callioni.assignment1.Car;
import com.callioni.assignment1.EOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-29T09:21:09")
@StaticMetamodel(Order_Line.class)
public class Order_Line_ { 

    public static volatile SingularAttribute<Order_Line, Integer> quantity;
    public static volatile SingularAttribute<Order_Line, EOrder> eorder;
    public static volatile SingularAttribute<Order_Line, Car> car;
    public static volatile SingularAttribute<Order_Line, Long> id;

}