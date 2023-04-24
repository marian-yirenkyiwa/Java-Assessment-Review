package machine;

import machine.Virtual_Machine;

public interface SystemBuildService {

    //this is an abstract class that other classes will inherit and override
    String createNewMachine(Virtual_Machine machine);
}
