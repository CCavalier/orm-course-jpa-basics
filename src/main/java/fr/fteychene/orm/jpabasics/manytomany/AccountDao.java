package fr.fteychene.orm.jpabasics.manytomany;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by fteychene on 16/03/17.
 */
@Repository(value = "manyToManyAccountDao")
@Qualifier("manytomany")
@Transactional
public class AccountDao {

    @PersistenceContext
    EntityManager em;
}
