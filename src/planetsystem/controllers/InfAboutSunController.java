package planetsystem.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import planetsystem.model.Model;
import planetsystem.view.Main;
import planetsystem.view.SetInformation;

import static planetsystem.view.Main.isDouble;


public class InfAboutSunController {

    @FXML
    public TextField sunName;

    @FXML
    public TextField mass;


    Model model;

    Stage stage;

    SetInformation SI;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setClass(SetInformation SI) {
        this.SI = SI;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void nextScene() throws Exception {
        if (!sunName.getText().isEmpty() && isDouble(mass.getText()) && Double.parseDouble(mass.getText()) > 0) {
            if (Double.parseDouble(mass.getText()) > 0) {
                model.setSunMass(Double.parseDouble(mass.getText()));
                model.setSunName(sunName.getText());
                SI.setDataAboutPlanets();
            } else {
                Main.showMessage(stage.getScene().getWindow(), "Обязательно нужно указать название звезды, " +
                        "и массу звезды (число положительное) ");
            }
        }
    }
}

