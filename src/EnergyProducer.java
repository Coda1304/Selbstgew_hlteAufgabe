import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public interface EnergyProducer {
    long getPower(); //in kw
    long getEEGAdvancement(); //in € @TODO: Anbindung an Strompreise und reale Produktion
    long getFoerderung(); //in Cent/kwh


    void accept(EnergyVisitor visitor);

}
