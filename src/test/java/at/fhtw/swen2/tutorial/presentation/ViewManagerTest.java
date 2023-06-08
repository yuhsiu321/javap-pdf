package at.fhtw.swen2.tutorial.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ViewManagerTest {

    @Autowired
    private ViewManager viewManager;

    @MockBean
    private ApplicationContext applicationContext;

    @MockBean
    private Stage stage;

    @Test
    public void testLoad() throws IOException {
        // Mock the view path
        String view = "at/fhtw/swen2/tutorial/presentation/view/TestView";

        // Mock the FXMLLoader and its dependencies
        FXMLLoader loader = mock(FXMLLoader.class);
        Parent parent = mock(Parent.class);
        Scene scene = mock(Scene.class); // Mock the Scene object

        when(loader.load()).thenReturn(parent);

}}


