package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.*;
public class C {
    public C() {
        A a = new A();

        a.field1 = 1;
        //a.field2 = 1; //컴파일 에러
        //a.field3 = 1; //컴파일 에러

        a.method1();
        //a.method2();  //컴파일 에러
        //a.method3();  //컴파일 에러
    }
}
