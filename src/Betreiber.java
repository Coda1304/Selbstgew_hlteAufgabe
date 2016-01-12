import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public class Betreiber implements HasEnergyOutput {

    private final String name;
    private final List<EnergyProducer> windparks = new ArrayList<EnergyProducer>();


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
    public long getOutput() {
        long output = 0;
        for(EnergyProducer windpark : windparks) {
            output = output + windpark.getOutput();
        }
        return output;
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

    public List<EnergyProducer> getProducers(){
        return Collections.unmodifiableList(windparks);
    }

    @Override
    public void accept(EnergyVisitor visitor) {
        visitor.visit(this);

    }
}
