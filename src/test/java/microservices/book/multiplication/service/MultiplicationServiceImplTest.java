package microservices.book.multiplication.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;

public class MultiplicationServiceImplTest {

	private MultiplicationServiceImpl multiplicationServiceImpl;

	@Mock
	private RandomGeneratorService randomGeneratorService;

	private MultiplicationResultAttempt multiplicationResultAttempt;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
	}

	@Test
	public void createRandomMultiplicationTest() {
		//given(mock 객체가 처음에 50, 나중에 30을 반환하도록 설정)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

		//when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

		//assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		// assertThat(multiplication.getResult()).isEqualTo(1500);
	}

	@Test
	public void checkCorrectAttemptTest() {
		Multiplication multiplication = new Multiplication(50,60);
		User user = new User("John_doe");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user,
			multiplication, 3000);

		//when
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

		//assert
		assertThat(attemptResult).isTrue();
	}

	@Test
	public void checkWrongAttemptTest() {

		Multiplication multiplication = new Multiplication(50,60);
		User user = new User("John_doe");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user,
			multiplication, 3010);

		//when
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

		//assert
		assertThat(attemptResult).isFalse();
	}
}
