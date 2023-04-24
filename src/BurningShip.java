//
// (c) Max van Daalen, April 2023
//

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class BurningShip extends Application
{
    private final int PLOT_WIDTH = 1200;
    private final int PLOT_HEIGHT = 800;

    @Override
    public void start(final Stage primaryStage) throws Exception
    {
/*      // co-ordinates for the full set
        // note,  the "y" values have been inverted for asthetics
        //
        final var topLeft = new Complex(-2.0, -1.0);
        final var bottomRight = new Complex(1.0, 1.0); */

        // co-ordinates for the first antenna ship, with appropriate co-ordinate swaps for asthetics
        //
        final var topLeft = new Complex(-1.8, -0.12);
        final var bottomRight = new Complex(-1.64, 0.05);

        final var maxIterations = 200;
        final var plot = new Render(topLeft, bottomRight, PLOT_WIDTH, PLOT_HEIGHT, maxIterations);
        final var root = new Pane();
        root.getChildren().add(plot);

        primaryStage.setTitle("The Burning Ship Set");
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();

        primaryStage.setOnCloseRequest(windowEvent -> Platform.exit());
    }

    public static final void main(final String[] args)
    {
        Application.launch(args);
    }
}
