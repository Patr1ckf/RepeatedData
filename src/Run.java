public class Run {
    public static void main(String[] args) {
        CompressionData data = new CompressionData();
        System.out.println(data.compressData("AABAABCCCD"));
        System.out.println(data.decompressData("A±2BA±2BC±3D"));
    }
}
