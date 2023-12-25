public class Run {

    private static String option;

    public static void main(String[] args) {

        CompressionData data = new CompressionData();

        do{
            System.out.println("Press:");
            System.out.println("'c' to compress data");
            System.out.println("'d' to decompress data");
            System.out.println("'x' to exit");
            option = InOutHandler.read("Enter your choice:");
            System.out.println();
            switch (option) {
                case "c" -> {
                    String dataToCompress = InOutHandler.read("Enter data to compress:");
                    InOutHandler.display("Compressed data: " + data.compressData(dataToCompress));
                }
                case "d" -> {
                    String dataToDecompress = InOutHandler.read("Enter data to decompress:");
                    InOutHandler.display("Decompressed data: " + data.decompressData(dataToDecompress));
                }
                case "x" -> {
                    return;
                }
            }
        }while(true);
    }
}
