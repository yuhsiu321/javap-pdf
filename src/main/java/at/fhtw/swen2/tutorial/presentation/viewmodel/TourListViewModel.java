package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TourListViewModel {

    @Autowired
    TourService tourService;

    private String apiKey = "vpYWl32FtXtF2BrrnpC5V94yYIqFkodG";

    private String baseUrl = "https://www.mapquestapi.com/directions/v2/route?key=" + apiKey;

    private List<Tour> masterData = new ArrayList<>();
    private ObservableList<Tour> tourListItems = FXCollections.observableArrayList();

    public ObservableList<Tour> getTourListItems() {
        return tourListItems;
    }

    public void addItem(Tour tour) {
        tourListItems.add(tour);
        masterData.add(tour);
    }

    public void deleteItem(Tour tour){
        tourListItems.remove(tour);
        masterData.remove(tour);
    }

    public void clearItems(){ tourListItems.clear(); }

    public void initList(){
        tourService.getTourList().forEach(p -> {
            addItem(p);
        });
    }

    public void filterList(String searchText){
        Task<List<Tour>> task = new Task<>() {
            @Override
            protected List<Tour> call() throws Exception {
                updateMessage("Loading data");
                return masterData
                        .stream()
                        .filter(value -> value.getName().toLowerCase().contains(searchText.toLowerCase()))
                        .collect(Collectors.toList());
            }
        };

        task.setOnSucceeded(event -> {
            tourListItems.setAll(task.getValue());
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }

    public void showDetailsWindow(Tour tour) {

        Stage detailsStage = new Stage();
        detailsStage.setTitle("Tour Details");

        Label nameLabel = new Label("Tour Name: " + tour.getName());
        Label descriptionLabel = new Label("Description: " + tour.getTourDescription());
        Label distanceLabel = new Label("Distance: " + tour.getDistance() + " km");
        Label timeLabel = new Label("Total Time: " + tour.getTime() + " seconds");
        Label transportLabel = new Label("Transport Type: " + tour.getTransportType());

        try {
            String urlString;
            if(Objects.equals(tour.getTransportType(), "pedestrian")) {
                urlString = baseUrl + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&outFormat=json&routeType=pedestrian";
            } else if (Objects.equals(tour.getTransportType(), "bicycle")) {
                urlString = baseUrl + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&outFormat=json&routeType=bicycle";
            }else if (Objects.equals(tour.getTransportType(), "drive(fastest)")) {
                urlString = baseUrl + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&outFormat=json&routeType=fastest";
            }else if (Objects.equals(tour.getTransportType(), "drive(shortest)")) {
                urlString = baseUrl + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&outFormat=json&routeType=shortest";
            }else {
                urlString = baseUrl + "&from=" + tour.getFrom() + "&to=" + tour.getTo() + "&outFormat=json&routeType=pedestrian";
            }
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //System.out.println(urlString);
            // Parse JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(conn.getInputStream());

            String sessionId = jsonNode.get("route").get("sessionId").asText();

            String ImageUrl = "https://www.mapquestapi.com/staticmap/v5/map?key=vpYWl32FtXtF2BrrnpC5V94yYIqFkodG&size=300,300&session="+sessionId;
            URL imageUrl = new URL(ImageUrl);

            InputStream imageStream = imageUrl.openStream();
            Image image = new Image(imageStream);
            ImageView imageView = new ImageView(image);

            VBox root = new VBox(nameLabel, descriptionLabel, distanceLabel, timeLabel, transportLabel);
            root.getChildren().add(imageView);
            Scene scene = new Scene(root);

            detailsStage.setScene(scene);
            detailsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setTourListItems(ObservableList<Tour> tourListItems) {
        this.tourListItems = tourListItems;
    }
}
