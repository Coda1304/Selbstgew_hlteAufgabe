/**
 * Created by Adrian on 12/01/16.
 */
public class ReplaceTurbine implements Command {

    private final Turbine replacedTurbine;
    private final Windpark windpark;
    private final Turbine newTurbine;

    public ReplaceTurbine(Turbine replacedTurbine, Windpark windpark, Turbine newTurbine) {
        this.replacedTurbine = replacedTurbine;
        this.windpark = windpark;
        this.newTurbine = newTurbine;
    }

    @Override
    public void exceute() {
        windpark.removeTurbine(replacedTurbine);
        windpark.addTurbine(newTurbine);
    }

    @Override
    public void undo() {
        windpark.removeTurbine(newTurbine);
        windpark.addTurbine(replacedTurbine);
    }
}
