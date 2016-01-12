import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public class Betreiber implements EnergyProducer {

    private final String name;
    private final List<EnergyProducer> windparks = new ArrayList<EnergyProducer>();
    //Hätte eigentlich noch andere Stromerzeuger, aber diese werden hier nicht aufgeführt

    public Betreiber(String name) {
        this.name=name;

    }

    public String getName() {
        return name;
    }



    public void addWindpark(EnergyProducer park){
       windparks.add(park);
    }

    @Override
    public long getPower() {
        long power = 0;
        for(EnergyProducer windpark : windparks) {
            power = power + windpark.getPower();
        }
        return power;
    }

    @Override
    //TODO: Formel überarbeiten
    public long getFoerderung() {

        long foerderung=0;
        for(EnergyProducer windpark : windparks) {
            foerderung = foerderung + windpark.getFoerderung();
        }

        return foerderung;
    }

    @Override
    public long getEEGAdvancement() {
        long advancement=0;
        for(EnergyProducer windpark : windparks) {
            advancement = advancement + windpark.getEEGAdvancement();
        }

        return advancement;
    }

    public List<EnergyProducer> getProducers(){
        return Collections.unmodifiableList(windparks);
    }

    @Override
    public void accept(EnergyVisitor visitor) {
        visitor.visit(this);

    }
}
