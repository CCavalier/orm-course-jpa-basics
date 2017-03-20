package fr.fteychene.orm.jpabasics.lazyloading;

import javax.persistence.*;

@Entity(name = "lazyAccount")
@Table(name = "LAZY_ACCOUNT")
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name="balance")
   private double balance;

   @ManyToOne
   @JoinColumn(name = "fk_user")
   private fr.fteychene.orm.jpabasics.manytoone.Person person;

   public Long getId() {
      return id;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public fr.fteychene.orm.jpabasics.manytoone.Person getPerson() {
      return person;
   }

   void setPerson(fr.fteychene.orm.jpabasics.manytoone.Person person) {
      this.person = person;
   }

   @Override
   public String toString() {
      return "LazyLoadingAccount{" +
              "id=" + id +
              ", balance=" + balance +
              '}';
   }
}