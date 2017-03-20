package fr.fteychene.orm.jpabasics.singleentity;

import fr.fteychene.orm.jpabasics.AbstractJpaTest;
import fr.fteychene.orm.jpabasics.JpaApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fteychene on 14/03/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = TestSingleEntityBottomUp.OverrideConfiguration.class)
@ActiveProfiles("embeddedDatasource")
@Transactional
public class TestSingleEntityBottomUp extends AbstractJpaTest {

    @Configuration
    @JpaApplication.OverrideConfiguration
    @PropertySource("classpath:singleentity/override.properties")
    static class OverrideConfiguration {

        @Bean
        @Qualifier("scripts")
        public String[] startupScripts() {
            return new String[] {"singleentity/create-db.sql"};
        }
    }

    @Test
    public void _1_create() {
        User singleTablePerson = new User();
        singleTablePerson.setFirstName("Augusto");
        singleTablePerson.setLastName("Rodriguez");

        em().persist(singleTablePerson);

        assertThat(singleTablePerson).isNotNull();
        assertThat(singleTablePerson.getFirstName()).isEqualTo("Augusto");
        assertThat(singleTablePerson.getLastName()).isEqualTo("Rodriguez");
    }

    @Test
    public void _2_load() {
        User singleTablePerson = em().find(User.class, 1L);

        assertThat(singleTablePerson).isNotNull();
        assertThat(singleTablePerson.getFirstName()).isEqualTo("Augusto");
        assertThat(singleTablePerson.getLastName()).isEqualTo("Rodriguez");
    }
}
