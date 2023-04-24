package machine;

import java.util.Objects;

public abstract class Virtual_Machine {

    //variable instances of the machine base class
    private String hostname;
    private String requestor_name;
    private int num_of_cpu;
    private int size_of_gb_ram;
    private int size_of_hard_disk;

    public Virtual_Machine(String hostname, String requestor_name, int num_of_cpu, int num_of_gb_ram, int size_of_hard_disk) {
        this.hostname = hostname;
        this.requestor_name = requestor_name;
        this.num_of_cpu = num_of_cpu;
        this.size_of_gb_ram = num_of_gb_ram;
        this.size_of_hard_disk = size_of_hard_disk;
    }

    public String getRequestorName() {
        return requestor_name;
    }

    @Override
    public String toString() {
        return "Virtual_Machine{" +
                "hostname='" + hostname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Virtual_Machine that = (Virtual_Machine) o;
        return num_of_cpu == that.num_of_cpu && size_of_gb_ram == that.size_of_gb_ram && size_of_hard_disk == that.size_of_hard_disk && Objects.equals(hostname, that.hostname) && Objects.equals(requestor_name, that.requestor_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, requestor_name, num_of_cpu, size_of_gb_ram, size_of_hard_disk);
    }
}
