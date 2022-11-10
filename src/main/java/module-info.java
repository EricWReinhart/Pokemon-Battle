module csci205_final_project{
    requires java.base;
    requires java.desktop;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    //exports org.Fearsome_Foursome.Pokemons.Arena1;
    //opens org.Fearsome_Foursome.Pokemons.Arena1 to javafx.fxml;
    exports org.Fearsome_Foursome.Pokemons.Arena2;
    opens org.Fearsome_Foursome.Pokemons.Arena2 to javafx.fxml;
}