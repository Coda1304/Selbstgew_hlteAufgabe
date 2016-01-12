/**
 * Created by Adrian on 21/12/15.
 */
public class Turbine implements EnergyProducer{

    private final long power;
    private final long foerderung;

    public Turbine(long foerderung, long power){
       this.foerderung=foerderung;
       this.power =power;

    }

    @Override
    public long getPower() {
        return power;
    }

    @Override
    public long getFoerderung() {
        return foerderung;
        
    }

    @Override
    public long getEEGAdvancement() {
        return ( (power*24*15)*foerderung/100 );
        // Der Wind weht nur in jeder zweiten Std. Hier müssten reale Winddaten für die EEG Vergütung genutzt werden
    }

    @Override
    public void accept(EnergyVisitor visitor) {
        visitor.visit(this);

    }

}


