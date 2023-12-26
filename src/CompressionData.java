import java.util.ArrayList;

public class CompressionData {
    private String currentCharacter;

    ArrayList<Character> splitData(String data){
        ArrayList<Character> charactersContainer = new ArrayList<>();
        for (int i=0; i <data.length(); i++){
            charactersContainer.add(data.charAt(i));
        }
        return charactersContainer;
    }

    String compressData(String data){

        int counter = 1;
        StringBuilder compressedData = new StringBuilder();
        ArrayList<Character> charactersContainer = splitData(data);
        if (data.contains("±")) {
            throw new IllegalArgumentException("'±' character in data!");
        }

        for(int i=0; i<charactersContainer.size(); i++){
            currentCharacter = String.valueOf(charactersContainer.get(i));
            if(i<charactersContainer.size()-1 && charactersContainer.get(i).equals(charactersContainer.get(i+1))) {
                counter++;
            }
            else {
                compressedData.append(currentCharacter);
                if(counter>1){
                    compressedData.append("±");
                    compressedData.append(counter);
                    counter = 1;
                }
            }
        }
        return String.valueOf(compressedData);
    }

    String decompressData(String data){

        StringBuilder decompressedData = new StringBuilder();
        ArrayList<Character> charactersContainer = splitData(data);

        for(int i=0; i<charactersContainer.size(); i++){
            currentCharacter = String.valueOf(charactersContainer.get(i));
            if(i<charactersContainer.size()-1 && charactersContainer.get(i+1) == '±'){
                if(charactersContainer.get(i+1) == '±' && charactersContainer.get(i+2) == '±'){
                    throw new IllegalArgumentException("Two consecutive '±' characters!!");
                }

                StringBuilder repetitionsString = new StringBuilder();
                int k = i+2;
                while (Character.isDigit(charactersContainer.get(k))) {
                    repetitionsString.append(charactersContainer.get(k));
                    k++;
                    if(k >= charactersContainer.size()){
                        break;
                    }
                    }
                int repetitions = Integer.parseInt(String.valueOf(repetitionsString));

                for(int j = 0; j< repetitions; j++){
                    decompressedData.append(currentCharacter);
                }
                i = k-1;
            }
            else{
                decompressedData.append(currentCharacter);
            }

        }
        return String.valueOf(decompressedData);
    }
}
