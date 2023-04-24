package machine;

public class Server extends Virtual_Machine{

    private String linux_distribution_name;
    private int major_distribution_num;
    private double kernel_version;
    private String admin_team;

    public Server(String hostname, String requestor_name, int num_of_cpu, int num_of_gb_ram, int size_of_hard_disk, String linux_distribution_name, int major_distribution_num, double kernel_version, String admin_team) {
        super(hostname, requestor_name, num_of_cpu, num_of_gb_ram, size_of_hard_disk);

        this.linux_distribution_name = linux_distribution_name;
        this.major_distribution_num = major_distribution_num;
        this.kernel_version = kernel_version;
        this.admin_team = admin_team;
    }

    @Override
    public String toString() {
        return "Server";
    }
}
