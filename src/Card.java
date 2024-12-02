import java.io.*;
import java.util.Scanner;

public class Card {

    private Integer Number;
    private String Colour;

    public Card(Integer Number, String Colour){
        this.Number = Number;
        this.Colour = Colour;
    }

    public Integer GetNumber(){
        return Number;
    }

    public String GetColour(){
        return Colour;
    }

    public static Card[] card = new Card[30];

    //initialisation of card array
    static {
        for (int i = 0; i < 30; i++) {
            card[i] = new Card(1, " ");
        }
    }

    public static void ReadData(){
        File fileName = new File("CardValues.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String line1;
            for (int i = 0; i < 30; i++) {
                if ((line = reader.readLine()) != null) {
                    line1 = reader.readLine();
                    card[i].Number = Integer.valueOf(line);
                    card[i].Colour = line1;
                }else{
                    break;
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File not found");
        } catch (IOException ioException){
            System.out.println("IO Exception");
        }
    }

    public static Boolean[] SelectedArray = new Boolean[30];
    static {
        for (int i = 0; i < 30; i++) {
            SelectedArray[i] = false;
        }
    }
    public static Boolean selected(Integer index){
        return SelectedArray[index];
    }
    public static Integer ChooseCard(Integer index){
        if(index >= 1 && index <= 30){
            if(Boolean.TRUE.equals(selected(index-1))){
                for (int i = 1; i < 30; i++) {
                    if(Boolean.FALSE.equals(selected(i - 1))){
                        return i-1;
                    }
                }
            }else{
                SelectedArray[index-1] = true;
                return index-1;
            }
        }else{
            System.out.println("The index is not within the range [1,30]");
        }
        return null;
    }

    public static void main(String[] args){
        ReadData();
        Card[] Player1 = new Card[4];
        Scanner keyboard = new Scanner(System.in);
        for (int i =0; i<4; i++) {
            System.out.println("\nEnter a number(index): ");
            Integer data = keyboard.nextInt();
            Player1[i] = card[ChooseCard(data)];
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Number of the card: "+ Player1[i].Number);
            System.out.println("Colour of the card: "+ Player1[i].Colour);
        }
    }
}
