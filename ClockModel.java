import java.util.*;
import java.io.*;
import java.time.*;

public class ClockModel extends Date{

    String fileName;

    public ClockModel(){
        fileName = "clock.txt";
    }
    public ClockModel(String fileName){
        setFile(fileName);
    }
    //Opens file and adds time to proper date
    public void addTime(){
        String today;
        try(PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));){
            today = getToday();
            if(today == ""){
                fileOut.print(LocalDate.now() + ",");
                fileOut.print(LocalTime.now() + ",");
            }else if(!today.equals(LocalDate.now().toString())){
                fileOut.print("\n" + LocalDate.now() + ",");
                fileOut.print(LocalTime.now() + ",");
            }else{
            //(today == LocalDate.now().toString()){
                fileOut.print(LocalTime.now()+",");
            }
        }catch(IOException ex){
            System.out.println("ERROR: File name " + fileName + "does not exist.");
            System.out.println(fileName + " will be created.");
        }
    }

    public void setFile(String fileName){
        this.fileName = fileName;
    }
    //Private class to get the first cell of each most recent line, returns most recent line's date
    private String getToday(){
        String line, date ="";
        try (Scanner fileRead = new Scanner(new FileReader(new File(fileName)));) {
            while(fileRead.hasNext()) {
                line = fileRead.nextLine();

                Scanner lineScan = new Scanner(line);

                lineScan.useDelimiter(",");
                date = lineScan.next();
                if(lineScan.hasNext()){
                    lineScan.nextLine();
                }
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return date;
    }

}// End of ClockModel class
