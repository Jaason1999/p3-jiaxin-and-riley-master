import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class UserParser{
  public static ArrayList<User> parseUsers (String filename) throws Exception{
    ArrayList<User> users = new ArrayList<User>();

    File dataFile = new File(filename);

    Scanner scanner = new Scanner(new File(filename), "UTF-8");
    String line = scanner.nextLine();//the first line is field headers, we do not want that.
    System.out.println(line);                                                                                                                                                                                                                                                                                                                       
    int i = 0;
    while(scanner.hasNextLine() && i < 100){ //this i < 100 is just to help you test, so that it doesn't take too long to run each time. you should eventually move towards reading in the entire file.
      line = scanner.nextLine();
      Scanner dataLine = new Scanner(input.nextLine()).useDelimiter("\",\"");

      String Topic = dataLine.next().replaceAll("\"", "");//removes all the quotation mark
      String Sentiment_string  = dataLine.next().replaceAll("\"", "");
      int Sentiment = sentimentConverter(Sentiment_string);

      String UserId  = dataLine.next().replaceAll("\"", "");
      String UserDate = dataLine.next().replaceAll("\"", "");
      String UserText = dataLine.next().replaceAll("\"", "");

      User users= new User(Topic, Sentiment, TweetId, TweetDate, TweetText);

      String[] fields = line.split("\",\"");
      fields[0] = fields[0].substring(1);
      try{
        users.add(new User(fields[0]));
        i++;
      } 吧                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  4
      catch(Exception e){
        System.out.println("file error: "+ e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
      }
    }

    return users;
  }
}