package fr.fteychene.orm.jpabasics.onetomany;

import javax.persistence.*;

@Entity(name="OneToManyAccount")
@Table(name = "ACCOUNT_ONETOMANY")
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name="balance")
   private double balance;

   public Long getId() {
      return id;
   }

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   @Override
   public String toString() {
      return "OneToManyAccount{" +
            "id=" + id +
            ", balance=" + balance +
            '}';
   }
}
