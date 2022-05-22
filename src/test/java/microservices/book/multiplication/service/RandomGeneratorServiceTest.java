package microservices.book.multiplication.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

	@Autowired
	RandomGeneratorService randomGeneratorService;

	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
		//무작위 숫자 생성
		List<Integer> randomFactors = IntStream.range(0, 1000)
			.map(i -> randomGeneratorService.generateRandomFactor())
			.boxed()
			.collect(Collectors.toList());

		assertThat(randomFactors)
			.containsOnlyElementsOf(IntStream.range(11,100)
				.boxed()
				.collect(Collectors.toList())
			);
	}
}
