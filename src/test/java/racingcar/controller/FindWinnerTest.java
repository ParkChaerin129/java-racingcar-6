package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class FindWinnerTest {

    AppConfig appConfig = new AppConfig();
    List<Car> cars;
    PlayEachRacingGame playEachRacingGame= appConfig.playEachRacingGame();
    FindWinners findWinners = new FindWinnersImpl();

    @BeforeEach
    void setCars(){
        Car car1=new Car("pobi");
        Car car2=new Car("woni");
        Car car3=new Car("jun");

        cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    @Test
    void 단독_우승자(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                4, 3,2
        );

        List<String> result=findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly("pobi");
    }

    @Test
    void 공동_우승자(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars=playEachRacingGame.getPlayEachRacingGame(cars);
                },
                4, 3,7
        );

        List<String> result=findWinners.getWinner(cars);

        Assertions.assertThat(result).containsExactly("pobi","jun");
    }

}
