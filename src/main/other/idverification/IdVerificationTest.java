package main.other.idverification;

public class IdVerificationTest {

	public static void main(String[] args) {
		// Good Path
		IdVerificationTest.givenValidId_whenCheckingIfIdIsValid_returnTrue();

		// Bad Path
		IdVerificationTest.givenMalformedId_withThreeInitials_whenCheckingIfIdIsValid_returnFalse();
		IdVerificationTest.givenMalFormedId_withTooManyInitials_whenCheckingIfIdIsValid_returnFalse();
		IdVerificationTest.giveNullId_whenCheckingIfIdIsValid_returnFalse();
	}

	private static void givenValidId_whenCheckingIfIdIsValid_returnTrue() {
		boolean result = IdVerification.isValidId("CAJI202002196");

		if (result == false) {
			throw new IllegalStateException("Test failed");
		}
	}

	private static void givenMalformedId_withThreeInitials_whenCheckingIfIdIsValid_returnFalse () {
		boolean result = IdVerification.isValidId("CAJ202002196");

		if (result == true) {
			throw new IllegalStateException("Test failed");
		}
	}

	private static void givenMalFormedId_withTooManyInitials_whenCheckingIfIdIsValid_returnFalse() {
		boolean result = IdVerification.isValidId("CAJII202002196");

		if (result == true) {
			throw new IllegalStateException("Test failed");
		}
	}

	private static void giveNullId_whenCheckingIfIdIsValid_returnFalse() {
		boolean result = IdVerification.isValidId(null);

		if (result == true) {
			throw new IllegalStateException("Test failed");
		}
	}
}
