module csci205_final_project{
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports org.Fearsome_Foursome.Creatures;
    opens org.Fearsome_Foursome.Creatures to javafx.fxml;

    exports org.Fearsome_Foursome.Battle;
    opens org.Fearsome_Foursome.Battle to javafx.fxml;

    exports org.Fearsome_Foursome.GameMVC.Controller;
    opens org.Fearsome_Foursome.GameMVC.Controller to javafx.fxml;

    exports org.Fearsome_Foursome.GameMVC.Model;
    opens org.Fearsome_Foursome.GameMVC.Model to javafx.fxml;

    exports org.Fearsome_Foursome.Moves;
    opens org.Fearsome_Foursome.Moves to javafx.fxml;

    exports org.Fearsome_Foursome.Screens.Menu;
    opens org.Fearsome_Foursome.Screens.Menu to javafx.fxml;


}