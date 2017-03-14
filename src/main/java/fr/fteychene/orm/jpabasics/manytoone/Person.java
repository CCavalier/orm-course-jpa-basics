package fr.fteychene.orm.jpabasics.manytoone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MANY_TO_ONE_PERSON")
@Table(name = "MANY_TO_ONE_PERSON")
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "FIRST_NAME")
   private String name;

   @OneToMany(mappedBy = "person", cascade = {CascadeType.ALL})
   private List<Account> accounts = new ArrayList<>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Account> getAccounts() {
      return accounts;
   }

   public void setAccounts(List<Account> accounts) {
      this.accounts = accounts;
   }

   @Override
   public String toString() {
      return "ManyToOnePerson{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
   }
}
