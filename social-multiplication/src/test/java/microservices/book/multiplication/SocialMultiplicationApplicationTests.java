package microservices.book.multiplication;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;
import microservices.book.multiplication.service.RandomGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialMultiplicationApplicationTests {
    @MockBean
    private RandomGeneratorService randomGeneratorService;
    @Autowired
    private MultiplicationService multiplicationService;

    @Test
    public void createRandomMultiplicationTest() {
        //given (our mocked Random Generator service will return first 50, then 30)
        BDDMockito.given(randomGeneratorService.generateRandomFactor())
                .willReturn(50,30);
        //when \
        Multiplication multiplication=multiplicationService.createRandomMultiplication();
        //then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);

    }

}
