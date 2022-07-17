import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person{
    private String name;
     private int age;
     private String country;

     public Person(String name, int age, String country) {
         this.name = name;
         this.age = age;
         this.country = country;
     }

     public String getName() {
         return name;
     }

     public int getAge() {
         return age;
     }

     public String getCountry() {
         return country;
     }
}
public class PersonService {

    public static List<Person> getPersons(List<Person> persons) {
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
        Collections.sort(persons,(p1,p2)->p1.getName().compareTo(p2.getName()));
        return persons;
    }

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        // Printing the name of each person.
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}

