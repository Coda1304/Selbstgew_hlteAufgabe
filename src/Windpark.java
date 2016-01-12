import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public class Windpark implements EnergyProducer {

    private final String name;

    private List<EnergyProducer> turbinen = new ArrayList<EnergyProducer>();

    public Windpark(String name){
        this.name = name;
    }

    public void addTurbine(EnergyProducer e){
       turbinen.add(e);
    }

    public List<EnergyProducer> getTurbinen(){
        return Collections.unmodifiableList(turbinen);
    }

    public String getName(){
        return name;
    }


    @Override
    public long getOutput() {
        long result=0;
        for(EnergyProducer turbine : turbinen){
            result = result+turbine.getOutput();
        }
        return result;
    }

    @Override
    public long getFoerderung() {
        long result=0;
        for(EnergyProducer turbine : turbinen){
            result = result+turbine.getFoerderung();
        }
        return result;
    }


    @Override
    public void accept(EnergyVisitor visitor) {
        visitor.visit(this);
    }
}
