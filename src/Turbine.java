import java.util.List;

/**
 * Created by Adrian on 21/12/15.
 */
public class Turbine implements HasEnergyOutput,EnergyProducer{

    private final long output;
    private final long foerderung;

    public Turbine(long foerderung, long output){
       this.foerderung=foerderung;
       this.output=output;

    }

    @Override
    public long getOutput() {
        return output;
    }

    @Override
    public long getFoerderung() {
        return foerderung;
        
    }


    @Override
    public void accept(EnergyVisitor visitor) {
        visitor.visit(this);

    }

}


