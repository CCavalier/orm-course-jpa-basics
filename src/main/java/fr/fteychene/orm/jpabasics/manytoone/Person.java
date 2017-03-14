package fr.fteychene.orm.jpabasics.manytoone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MANY_TO_ONE_PERSON")
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "FIRST_NAME")
   private String name;


   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


   @Override
   public String toString() {
      return "OneToOnePerson{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
   }
}
