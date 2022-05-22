package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

public interface MultiplicationService {

    /**
     * 두개의 무작위 인수를 담은 {@link Multiplication}객체를 생성한다
     * @return 무작위 인수를 담은 {@link Multiplication}객체
     */
    Multiplication createRandomMultiplication();
}
