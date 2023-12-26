public class Run {

    public static void main(String[] args) {

        CompressionData data = new CompressionData();

        do{
            System.out.println("-----------------------------");
            System.out.println("Press:");
            System.out.println("'c' to compress data");
            System.out.println("'d' to decompress data");
            System.out.println("'x' to exit");
            String option = InOutHandler.read("Enter your choice:");
            System.out.println();
            switch (option) {
                case "c" -> {
                    try {
                        String dataToCompress = InOutHandler.read("Enter data to compress:");
                        InOutHandler.display("Compressed data: " + data.compressData(dataToCompress));
                        System.out.println();
                    }catch(IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                }
                case "d" -> {
                    try {
                        String dataToDecompress = InOutHandler.read("Enter data to decompress:");
                        InOutHandler.display("Decompressed data: " + data.decompressData(dataToDecompress));
                        System.out.println();
                    }catch(IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                }
                case "x" -> {
                    return;
                }
                default -> InOutHandler.display("Invalid option!");
            }
        }while(true);
    }
}
