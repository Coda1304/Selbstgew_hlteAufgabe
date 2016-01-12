import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 12/01/16.
 */
public class CommandManager {

    private List<Command> commands = new ArrayList<Command>();

    public void run(Command command){
        command.exceute();
        commands.add(command);
    }

    public void undo(){
        if(commands.isEmpty()){
            throw new IllegalStateException("Keine Commands in der Liste.");
        }
        Command lastCommand = commands.remove(commands.size()-1);
        lastCommand.undo();
    }
}
