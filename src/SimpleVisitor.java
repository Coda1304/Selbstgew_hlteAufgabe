/**
 * Created by Adrian on 21/12/15.
 */
public class SimpleVisitor implements EnergyVisitor {

    @Override
    public void visit(Betreiber betreiber) {
        System.out.println("--------------------");
        System.out.println(betreiber.getName());
        System.out.println("--------------------");
        for (EnergyProducer producer : betreiber.getProducers()){
            producer.accept(this);
        }
    }

    @Override
    public void visit(Windpark windpark) {

        System.out.println( "Windpark: "+windpark.getName() );
        System.out.println(windpark.getTurbinen().size()+" Turbinen:");

        for (EnergyProducer t : windpark.getTurbinen() ){
            t.accept(this);
        }
    }

    @Override
    public void visit(Turbine turbine) {
        System.out.println("Foerderung: "+turbine.getFoerderung()+"ct/kWh bei "+turbine.getOutput()+"kw Leistung." );

    }
}
