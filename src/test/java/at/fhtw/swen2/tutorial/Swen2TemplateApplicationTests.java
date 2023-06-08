package at.fhtw.swen2.tutorial;

import at.fhtw.swen2.tutorial.presentation.Swen2TemplateApplication;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class Swen2TemplateApplicationTests {

	@Autowired
	private Swen2TemplateApplication application;

	private ConfigurableApplicationContext applicationContext;


	@AfterEach
	public void tearDown() {
		if (applicationContext != null) {
			applicationContext.close();
		}
	}

	@Test
	public void testApplicationStartup() {
		Platform.startup(() -> {
			try {
				Stage stage = new Stage();
				application.start(stage);

				// Add your assertions or test logic here

				assertNotNull(stage); // Example assertion

				application.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

