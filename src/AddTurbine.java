/**
 * Created by Adrian on 12/01/16.
 */
public class AddTurbine implements Command {

    private final Turbine newTurbine;
    private final Windpark windpark;

    public AddTurbine(Turbine newTurbine, Windpark windpark) {
        this.newTurbine = newTurbine;
        this.windpark = windpark;
    }

    @Override
    public void exceute() {
        windpark.addTurbine(newTurbine);
    }

    @Override
    public void undo() {
        windpark.removeTurbine(newTurbine);
    }
}
