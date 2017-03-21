package fr.fteychene.orm.jpabasics.singleentity;

import fr.fteychene.orm.jpabasics.AbstractJpaTest;
import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.transaction.Transactional;

/**
 * Created by fteychene on 14/03/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class TestSingleEntityTopDown extends AbstractJpaTest {


    @Test
    public void _1_create() {
        User singleTablePerson = new User();
        singleTablePerson.setFirstName("Augusto");
        singleTablePerson.setLastName("Rodriguez");

        em().persist(singleTablePerson);

        Assertions.assertThat(singleTablePerson).isNotNull();
        Assertions.assertThat(singleTablePerson.getFirstName()).isEqualTo("Augusto");
        Assertions.assertThat(singleTablePerson.getLastName()).isEqualTo("Rodriguez");
    }

    @Test
    public void _2_load() {
        User singleTablePerson = em().find(User.class, 1L);

        Assertions.assertThat(singleTablePerson).isNotNull();
        Assertions.assertThat(singleTablePerson.getFirstName()).isEqualTo("Augusto");
        Assertions.assertThat(singleTablePerson.getLastName()).isEqualTo("Rodriguez");
    }
}
