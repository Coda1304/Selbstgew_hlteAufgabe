import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Adrian on 08/01/16.
 */
public class SortedVisitor implements EnergyVisitor {

    private Betreiber aktBetr;
    private Windpark aktWindpark;
    private TreeMap<Long, sortedTurbine> turbines = new TreeMap<Long,sortedTurbine>(Collections.reverseOrder());

    @Override
    public void visit(Betreiber betreiber) {
        System.out.println("Sortierte Liste der Turbinen nach ihren erhaltenen EEG-Vergütungen:");

        aktBetr = betreiber;
        for (EnergyProducer producer : betreiber.getProducers()){
            producer.accept(this);
        }
        aktBetr=null;


        for(long key : turbines.keySet()){
          System.out.println(turbines.get(key));
        }
    }

    @Override
    public void visit(Windpark windpark) {
        aktWindpark = windpark;
        for (EnergyProducer t : windpark.getTurbinen() ){
            t.accept(this);
        }
        aktWindpark=null;
    }

    @Override
    public void visit(Turbine turbine) {
        long advancement = turbine.getEEGAdvancement();
        turbines.put( advancement ,new sortedTurbine(aktBetr,aktWindpark,turbine));
    }

    private class sortedTurbine {
        private final Betreiber betreiber;
        private final Windpark windpark;
        private final Turbine turbine;
        private final long advancement;

        public sortedTurbine(Betreiber betreiber, Windpark windpark, Turbine turbine) {
            this.betreiber = betreiber;
            this.windpark = windpark;
            this.turbine = turbine;
            this.advancement=turbine.getEEGAdvancement();

        }

        public String toString(){
            return "EEG-Vergütung: "+advancement+"€, Leistung: "+turbine.getPower()+"kw, "+betreiber.getName()+" im Park "+windpark.getName();
        }
    }
}
