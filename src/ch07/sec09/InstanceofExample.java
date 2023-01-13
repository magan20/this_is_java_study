package ch07.sec09;

public class InstanceofExample {
    public static void personInfo(Person person) {
        System.out.println("name: " + person.name);
        person.walk();

		/*if (person instanceof Student) {
 			// Student 객체일 경우 강제 타입 변환
 			Student student = (Student) person;
 			// Student 객체만 가지고 있는 필드 및 메소드 사용
 			System.out.println("studentNo: " + student.studentNo);
 			student.study();
 		}*/

        if (person instanceof Student student) {
            System.out.println("studentNo: " + student.studentNo);
            student.study();
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("홍길동");
        personInfo(p1);

        System.out.println();

        Person p2 = new Student("김길동", 10);
        personInfo(p2);
    }
}