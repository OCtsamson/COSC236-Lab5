package lab5.tests;

import lab5.Borrowing.BorrowingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSingleton {
	@Test
	void TestSingleton() {
		BorrowingService service1 = BorrowingService.getInstance();
		BorrowingService service2 = BorrowingService.getInstance();
		assertEquals(service1, service2,"Two Singleton instances detected");
	}
}
