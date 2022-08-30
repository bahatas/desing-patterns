package com.example.designpatterns.strategy.ibanconv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IbanTest {
    /**
     * Method under test: {@link Iban#Iban(IbanPort, String)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     Iban.iban
        //     Iban.ibanPort

        new Iban(new IbanSandboxBreakDown(), "Iban");

    }

    /**
     * Method under test: {@link Iban#toSortCode()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToSortCode() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Invalid Iban
        //       at com.example.designpatterns.strategy.ibanconv.IbanSandboxBreakDown.toSortCode(IbanSandboxBreakDown.java:9)
        //       at com.example.designpatterns.strategy.ibanconv.Iban.toSortCode(Iban.java:14)
        //   In order to prevent toSortCode()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toSortCode().
        //   See https://diff.blue/R013 to resolve this issue.

        (new Iban(new IbanSandboxBreakDown(), "Iban")).toSortCode();
    }

    /**
     * Method under test: {@link Iban#toSortCode()}
     */
    @Test
    void testToSortCode2() {
        IbanSandboxBreakDown ibanSandboxBreakDown = mock(IbanSandboxBreakDown.class);
        when(ibanSandboxBreakDown.toSortCode((String) any())).thenReturn("Sort Code");
        assertEquals("Sort Code", (new Iban(ibanSandboxBreakDown, "Iban")).toSortCode());
        verify(ibanSandboxBreakDown).toSortCode((String) any());
    }

    /**
     * Method under test: {@link Iban#toAccountNumber()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToAccountNumber() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Invalid Iban
        //       at com.example.designpatterns.strategy.ibanconv.IbanSandboxBreakDown.toAccountNumber(IbanSandboxBreakDown.java:17)
        //       at com.example.designpatterns.strategy.ibanconv.Iban.toAccountNumber(Iban.java:18)
        //   In order to prevent toAccountNumber()
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toAccountNumber().
        //   See https://diff.blue/R013 to resolve this issue.

        (new Iban(new IbanSandboxBreakDown(), "Iban")).toAccountNumber();
    }

    /**
     * Method under test: {@link Iban#toAccountNumber()}
     */
    @Test
    void testToAccountNumber2() {
        IbanSandboxBreakDown ibanSandboxBreakDown = mock(IbanSandboxBreakDown.class);
        when(ibanSandboxBreakDown.toAccountNumber((String) any())).thenReturn("42");
        assertEquals("42", (new Iban(ibanSandboxBreakDown, "Iban")).toAccountNumber());
        verify(ibanSandboxBreakDown).toAccountNumber((String) any());
    }

    @Test
    void testAccountNumber (){
        IbanPort ibanSand = new IbanSandboxBreakDown();
        Iban iban = new Iban(ibanSand,"GB 29 NWBK 601613 31926819");
        assertEquals("601613",iban.toSortCode());
        assertEquals("31926819",iban.toAccountNumber());
    }
}

