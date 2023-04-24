package machine;

public class Desktop extends Virtual_Machine{
    private int windows_version;
    private String build_number;

    public Desktop(String hostname, String requestor_name, int num_of_cpu, int size_of_gb_ram, int size_of_hard_disk, int microsoft_windows_version, String build_number) {
        super(hostname, requestor_name, num_of_cpu, size_of_gb_ram, size_of_hard_disk);

        this.windows_version = microsoft_windows_version;
        this.build_number = build_number;
    }

    @Override
    public String toString() {
        return "Desktop";
    }
}
