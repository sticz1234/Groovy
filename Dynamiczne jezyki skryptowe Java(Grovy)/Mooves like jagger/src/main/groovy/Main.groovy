import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage

class Main extends Application {
    static void main(String[] args) {
        launch(Main, args)
    }

    @Override
    void start(Stage primaryStage) {
        def scene = tryInitializeStructure()
        setMainParameters(primaryStage, scene)
    }

    private static setMainParameters(def primaryStage, def scene) {
        primaryStage.setScene(scene)
        primaryStage.setTitle("Kalkulator")
        primaryStage.setMinWidth(500)
        primaryStage.setMinHeight(500)
        primaryStage.setWidth(500)
        primaryStage.setHeight(500)
        primaryStage.show()
    }

    private static def tryInitializeStructure() {
        def scene = null
        try {
            scene = initializeStructure()
        } catch(NullPointerException | IOException e) {
            e.printStackTrace()
            System.out.println("Nie można załadować struktury aplikacji!")
        }
        scene
    }

    static def initializeStructure() throws IOException {
        URL checkingResource = Main.class.getClassLoader().getResource("calc.fxml")
        def checkingLoader = new FXMLLoader(Objects.requireNonNull(checkingResource))
        Pane root = checkingLoader.load()
        new Scene(root)
    }

}
