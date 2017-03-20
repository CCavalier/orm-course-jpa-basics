package fr.fteychene.orm.jpabasics.manytoone;

import fr.fteychene.orm.jpabasics.AbstractJpaTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManyToOneBidirectionnalTest extends AbstractJpaTest {

   @Autowired
   @Qualifier("manytoone")
   PersonDao personDao;

   @Autowired
   @Qualifier("manytoone")
   AccountDao accountDao;

   @Test
   public void _1_test() {

      Person person = new Person();
      person.setName("Augusto");

      Account account1 = new Account();
      account1.setBalance(100);
      Account account2 = new Account();
      account2.setBalance(200);

      person.setAccounts(Arrays.asList(account1, account2));

      personDao.create(person);

      assertThat(person.getId()).isNotNull();
      person.getAccounts().forEach(a -> assertThat(a.getId()).isNotNull());
   }

   @Test
   @Transactional
   public void _2_load() {
      Account account = accountDao.find(1l);
      assertThat(account).isNotNull();

      Person person = account.getPerson();
      assertThat(person.getId()).isNotNull();
      assertThat(person.getName()).isEqualTo("Augusto");
      assertThat(person.getAccounts()).hasSize(2);

      for (int i = 0; i < 2; i++) {
         assertThat(person.getAccounts()).isNotNull();
         assertThat(person.getAccounts().get(i).getBalance()).isEqualTo((i + 1) * 100);
      }
   }
}