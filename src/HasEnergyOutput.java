import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public interface HasEnergyOutput {
    long getOutput(); //in kw
    long getFoerderung(); //in Cent

    void accept(EnergyVisitor visitor);
}
