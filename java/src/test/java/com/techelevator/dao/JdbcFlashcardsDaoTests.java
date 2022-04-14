package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcFlashcardsDaoTests extends BaseDaoTests {
    @Test
    public void API_injects_data_into_database() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        JdbcFlashCardsDao sut = new JdbcFlashCardsDao(jdbcTemplate);

        boolean result = sut.saveCardObserving();

        Assert.assertTrue(result);


    }
}
