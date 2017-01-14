/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadsorter.view.rulepanes;

import downloadsorter.AllRules;
import downloadsorter.FXMain;
import downloadsorter.model.Rule;
import downloadsorter.view.MainWindowController;
import downloadsorter.view.RuleEditorController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Eric
 */
public class RuleSelectorController<T extends Rule> implements Initializable {

    @FXML
    ChoiceBox<T> ruleSelector;
    @FXML
    Button removeButton;
    @FXML
    VBox basePane;
    
    FlowPane rulePane;
    RuleEditorController parent;
    MainWindowController mainWindow;
    RulePaneController<T> ruleControl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ruleSelector.setConverter(new StringConverter<T>() {
            @Override
            public T fromString(String s) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            @Override
            public String toString(T r) {
                return r.getDescription();
            }
        });
        ruleSelector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
            @Override
            public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
                setRulePane(newValue);
            }
        });
        removeButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                parent.remove(basePane);
                //mainWindow.writeOperations();
            }
        });
    }    
    
    public void setParentController(RuleEditorController parentControl, MainWindowController main) {
        parent = parentControl;
        mainWindow = main;
        
    }
    
    public void setComboBox(T rule) {
        List<T> allRules = AllRules.getInstance().getRules(rule);
        ObservableList<T> dummyInstances = FXCollections.observableArrayList(allRules);
        for (T r: dummyInstances) {
            if (r.getClass().equals(rule.getClass())){
                dummyInstances.set(dummyInstances.indexOf(r), rule);
            }
        }
        ruleSelector.setItems(dummyInstances);
        ruleSelector.getSelectionModel().select(rule);
    }
    
    public void setRulePane(T rule) {
        
        String location = rule.getFXMLPath();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMain.class.getResource(location));
            basePane.getChildren().remove(rulePane);
            rulePane = (FlowPane) loader.load();
            basePane.getChildren().add(rulePane);
            ruleControl = loader.getController();
            ruleControl.setRule(rule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T saveRule() {
        int index = ruleSelector.getSelectionModel().getSelectedIndex();
        T rule = ruleControl.getRule();
        ruleSelector.getItems().set(index, rule);
        ruleSelector.getSelectionModel().select(rule);
        return rule;
    }
    
    
//interface RuleEnum {
//    Rule getDummyInstance();
//}
//enum SourceType implements RuleEnum{
//    DirectorySource;
//    
//    public SourceRule getDummyInstance() {
//        switch (this) {
//            case DirectorySource: return new DirectorySource();
//            default: return null;
//        }
//    }
//}
//enum FilterType implements RuleEnum{
//    FansubFilter,
//    FilterByList;
//    
//    public FilterRule getDummyInstance() {
//        switch (this) {
//            case FansubFilter: return new FansubFilter();
//            case FilterByList: return new FilterByList();
//            default: return null;
//        }
//    }
//}
//enum DestinationType implements RuleEnum{
//    DestinationNamedDirectories;
//    
//    public DestinationRule getDummyInstance() {
//        switch (this) {
//            case DestinationNamedDirectories: return new DestinationNamedDirectories();
//            default: return null;
//        }
//    }
//}
}