/**
 * Created by Adrian on 12/01/16.
 */
public class DeleteTurbine implements Command {

    private final Turbine deletedTurbine;
    private final Windpark windpark;

    public DeleteTurbine(Turbine deletedTurbine, Windpark windpark) {
        this.deletedTurbine = deletedTurbine;
        this.windpark = windpark;
    }


    @Override
    public void exceute() {
     windpark.removeTurbine(deletedTurbine);
    }

    @Override
    public void undo() {
        windpark.addTurbine(deletedTurbine);
    }
}
