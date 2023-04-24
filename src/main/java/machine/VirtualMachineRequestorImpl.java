package machine;

import java.util.HashMap;
import java.util.Map;

public class VirtualMachineRequestorImpl implements VirtualMachineRequestor{
    //creating an object of type AuthorisingService
    AuthorisingService authorisingService;

    //creating an object of type SystemBuildService
    SystemBuildService systemBuildService;

    //creating a map collection to store a collection of users, machine type and qty
    // upon successful creation of a virtual machine
    Map<String, Map<String, Integer>> storeUsersMap = new HashMap<>();

    //this variable will check the total number of failed builds in a day
    private int totalFailedBuilds = 0;

    //this variable will check if a machineType has been built already and increase its count
    private int machineTypeCount;

    //the VirtualMachineRequestorImpl constructor initializes the AuthrisingService object and the SystemBuildService object
    public VirtualMachineRequestorImpl(AuthorisingService authorisingService, SystemBuildService systemBuildService) {
        this.authorisingService = authorisingService;
        this.systemBuildService = systemBuildService;
    }

    //the createNewRequest creates a build request for a virtual machine
    //it checks if the user is authorised or not
    //it also checks if the build request is successful or not
    @Override
    public void createNewRequest(Virtual_Machine machine) throws UserNotEntitledException, MachineNotCreatedException {
        //an if/else condition to check if user is authorised to request for a virtual machine
        if (authorisingService.isAuthorised(machine.getRequestorName())) {

            //if true, create a new machine
            String hostName = systemBuildService.createNewMachine(machine);

            //the toString returns the hostname of the machine(Desktop or Server) and is stored in the hostName variable
            //String hostName = machine.toString();

            //checking if hostname is empty then throw an exception, and update the total count of the totalFailedBuilds
            if(hostName.equals("")){
                totalFailedBuilds++;
                throw new MachineNotCreatedException("Oops! couldn't create a virtual machine");

            }else{
                //creating an instance of a map collection to store a collection of
                // machine type and qty of successful machine builds
                Map<String, Integer>  machineTypeQty = new HashMap<>();

                //checking if machine type has 1 or more counts, then update the count
                if(storeUsersMap.get(machine.getRequestorName()).containsKey(machine.toString())){
                    machineTypeCount = storeUsersMap.get(machine.getRequestorName()).get(machine.toString());
                    machineTypeCount +=1;
                    machineTypeQty.put(machine.toString(), machineTypeCount);
                }else{
                    machineTypeQty.put(machine.toString(), 1);
                }

                //storing values in the storeUsersMap collection
                storeUsersMap.put(machine.getRequestorName(), machineTypeQty);
            }

        //   if user entitlement is false then throw an exception
        }else{
            throw new UserNotEntitledException("Sorry, you are not entitled to create a request");
        }
    }

    //this method returns a collections of total successful builds by users in a day
    @Override
    public Map totalBuildsByUserForDay() {
        return storeUsersMap;
    }

    //this method returns a count of the total number of failed builds in a day
    @Override
    public int totalFailedBuildsForDay() {
        return totalFailedBuilds;
    }
}
