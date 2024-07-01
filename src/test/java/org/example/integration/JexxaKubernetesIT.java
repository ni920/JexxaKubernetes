package org.example.integration;

import org.example.JexxaKubernetes;
import io.jexxa.jexxatest.JexxaIntegrationTest;
import io.jexxa.jexxatest.integrationtest.rest.RESTBinding;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class  JexxaKubernetesIT
{
    private static JexxaIntegrationTest jexxaIntegrationTest;  // Simplified IT testing with jexxa-test
    private static RESTBinding restBinding;                    // Binding to access application under test via REST

    @BeforeAll
    static void initBeforeAll()
    {
        jexxaIntegrationTest = new JexxaIntegrationTest(JexxaKubernetes.class);
        restBinding = jexxaIntegrationTest.getRESTBinding();
    }


    @Test
    void testStartupApplication()
    {
        //Arrange -
        var boundedContext = restBinding.getBoundedContext();

        //Act / Assert
        var result = boundedContext.contextName();

        //Assert
        assertEquals(JexxaKubernetes.class.getSimpleName(), result);
    }

    @AfterAll
    static void shutDown()
    {
        jexxaIntegrationTest.shutDown();
    }
}
