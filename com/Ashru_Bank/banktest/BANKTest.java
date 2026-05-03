import org.junit.Test;
import static org.junit.Assert.*;

public class BANKTest {

    // ===== DEPOSIT TESTS =====

    @Test
    public void testDepositSuccess() {
        BANK b = new BANK();
        b.currentBalance = 1000;

        double result = b.depositLogic(500);

        assertEquals(1500, result, 0.01);
    }

    @Test
    public void testDepositInvalidNegative() {
        BANK b = new BANK();
        b.currentBalance = 1000;

        double result = b.depositLogic(-200);

        assertEquals(1000, result, 0.01);
    }

    @Test
    public void testDepositZero() {
        BANK b = new BANK();
        b.currentBalance = 1000;

        double result = b.depositLogic(0);

        assertEquals(1000, result, 0.01);
    }

    // ===== WITHDRAW TESTS =====

    @Test
    public void testWithdrawSuccessWithoutOTP() {
        BANK b = new BANK();
        b.currentBalance = 3000;

        boolean result = b.withdrawLogic(1500);

        assertTrue(result);
        assertEquals(1500, b.currentBalance, 0.01);
    }

    @Test
    public void testWithdrawInvalidNegative() {
        BANK b = new BANK();
        b.currentBalance = 3000;

        boolean result = b.withdrawLogic(-500);

        assertFalse(result);
        assertEquals(3000, b.currentBalance, 0.01);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BANK b = new BANK();
        b.currentBalance = 1000;

        boolean result = b.withdrawLogic(5000);

        assertFalse(result);
        assertEquals(1000, b.currentBalance, 0.01);
    }

    // ===== OTP-BASED WITHDRAW TEST =====

    @Test
    public void testWithdrawWithOTP() {
        BANK b = new BANK();
        b.currentBalance = 5000;

        // simulate correct OTP
        b.systemOTP = 1234;

        boolean result = b.withdrawWithOTPLogic(3000, 1234);

        assertTrue(result);
        assertEquals(2000, b.currentBalance, 0.01);
    }

    @Test
    public void testWithdrawWithWrongOTP() {
        BANK b = new BANK();
        b.currentBalance = 5000;

        b.systemOTP = 1234;

        boolean result = b.withdrawWithOTPLogic(3000, 9999);

        assertFalse(result);
        assertEquals(5000, b.currentBalance, 0.01);
    }

    // ===== PIN VALIDATION TEST =====

    @Test
    public void testValidatePINSuccess() {
        BANK b = new BANK();
        b.userPIN = 1234;

        assertTrue(b.validatePINLogic(1234));
    }

    @Test
    public void testValidatePINFail() {
        BANK b = new BANK();
        b.userPIN = 1234;

        assertFalse(b.validatePINLogic(9999));
    }

    // ===== MOBILE VALIDATION TEST =====

    @Test
    public void testValidateMobileSuccess() {
        BANK b = new BANK();
        b.userMobile = 9876543210L;

        assertTrue(b.validateMobileLogic(9876543210L));
    }

    @Test
    public void testValidateMobileFail() {
        BANK b = new BANK();
        b.userMobile = 9876543210L;

        assertFalse(b.validateMobileLogic(1234567890L));
    }
}