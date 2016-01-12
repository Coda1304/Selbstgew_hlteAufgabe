import com.google.common.base.Strings;

/**
 * Created by Adrian on 21/12/15.
 */
public class SimpleVisitor implements EnergyVisitor {
    private int depth;
    @Override
    public void visit(Betreiber betreiber) {
        System.out.println(indent() + "--------------------");
        System.out.println(indent() + betreiber.getName());
        System.out.println(indent()+"--------------------");
        for (EnergyProducer producer : betreiber.getProducers()){
            producer.accept(this);
        }
        System.out.println(indent()+"--------------------");
        System.out.println(indent()+"Gesamtoutput: "+betreiber.getPower());

    }

    @Override
    public void visit(Windpark windpark) {
        depth++;
        System.out.println( indent()+"Windpark: "+windpark.getName() );
        System.out.println(indent()+windpark.getTurbinen().size()+" Turbinen:");

        for (EnergyProducer t : windpark.getTurbinen() ){
            t.accept(this);
        }
        depth--;
    }

    @Override
    public void visit(Turbine turbine) {
        depth++;
        System.out.println(indent()+"Foerderung: "+turbine.getFoerderung()+"ct/kWh bei "+turbine.getPower()+"kw Leistung." );
        depth--;
    }

    private String indent(){
        return Strings.repeat("\t",depth);
    }
}
