/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package club.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fredd
 */
public class ALNLMemberTest {
    
    public ALNLMemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFullName method, of class Member.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Member instance = new Member();
        instance.setFullName("Billy Bob");
        String expResult = "Billy Bob";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEmailAddress method, of class Member.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        instance.setEmailAddress("billy@email.com");
        String expResult = "billy@email.com";
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Member.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        instance.setPhoneNumber("222-111-3333");
        String expResult = "222-111-3333";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProgramName method, of class Member.
     */
    @Test
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member instance = new Member();
        instance.setProgramName("CPA");
        String expResult = "CPA";
        String result = instance.getProgramName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYearLevel method, of class Member.
     */
    @Test
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member instance = new Member();
        instance.setYearLevel(2);
        int expResult = 2;
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidPositive method, of class Member.
     */
    @Test
    public void testIsValidPositive() {
        System.out.println("isValidPositive");
        String testName = "Billy Bob";
        String testEmail =  "billy@email.com";
        
        Member instance = new Member(testName, testEmail);
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValid method, of class Member.
     */
    @Test
    public void testIsValidNegative() {
        System.out.println("isValidNegative");
        Member instance = new Member();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Auto generated set tests. Not used in this project">
    /****
     * Set Tests
     */
    
        /**
     * Test of setEmailAddress method, of class Member.
     */
    /*
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        Member instance = new Member();
        instance.setEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
        /**
     * Test of setPhoneNumber method, of class Member.
     */
    /*
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "";
        Member instance = new Member();
        instance.setPhoneNumber(phoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    
    /**
     * Test of setProgramName method, of class Member.
     */
    /*
    @Test
    public void testSetProgramName() {
        System.out.println("setProgramName");
        String programName = "";
        Member instance = new Member();
        instance.setProgramName(programName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
        /**
     * Test of setYearLevel method, of class Member.
     */
    /*
    @Test
    public void testSetYearLevel() {
        System.out.println("setYearLevel");
        int yearLevel = 0;
        Member instance = new Member();
        instance.setYearLevel(yearLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    // </editor-fold>
}
