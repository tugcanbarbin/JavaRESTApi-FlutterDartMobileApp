package com.can.spring.learnspringframework;

import com.can.spring.learnspringframework.game.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class,args);

		//Spring part
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		//normal part
//		Game game = new MarioGame();
//		GameRunner runner = new GameRunner(game);
//		runner.run();

//		Game game2 = new SuperCentraGame();
//		GameRunner runner2 = new GameRunner(game2);
//		runner2.run();
//
//		Game game3 = new PacmanGame();
//		GameRunner runner3 = new GameRunner(game3);
//		runner3.run();

	}

}
