public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int oneMegaByte = 1024;
        int inMegabytes = kiloBytes / oneMegaByte;
        int remainderKilobytes = kiloBytes % oneMegaByte;
        System.out.println(
                kiloBytes +
                        " KB = " +
                        inMegabytes +
                        " MB and " +
                        remainderKilobytes +
                        " KB"
        );
    }
}
