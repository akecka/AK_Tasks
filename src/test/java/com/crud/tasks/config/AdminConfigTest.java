package com.crud.tasks.config;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AdminConfigTest {

    @Test
    public void testAdminConfig() {
        //Given
        AdminConfig adminConfig = new AdminConfig();
        adminConfig.getAdminMail();
        //Then
        assertNotNull(adminConfig.toString());
    }
}
