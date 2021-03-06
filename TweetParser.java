import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class TweetParser{
  /**
   * Take the name of a comma-separated value (.csv) file in 
   *the local directory and parse the contents for tweets. 
   *The tweets have an expected structure of "Topic", "Sentiment", 
   *"TweetId", "TweetDate", "TweetText"
   * @param  filename the name of a comma-separated value (.csv) 
   *file in the local directory
   * @return          An array of parsed Message objects
   */
  public static ArrayList<Tweet> parseTweets(String filename) throws Exception {
    ArrayList<Tweet> tweets = new <ArrayList<Tweet>>(2);
  
    ArrayList<Tweet> ErrorTweet = new ArrayList<Tweet>();
    ArrayList<Tweet> CorrectTweet = new ArrayList<Tweet>();
    

    File dataFile = new File(filename);

    //Make file object from " .csv"

    // Read data with Scanner
    Scanner scanner = new Scanner(new File(filename), "UTF-8");
    String line = scanner.nextLine();//the first line is field headers, we do not want that.
    System.out.println(line);
    int i = 0;
    while(scanner.hasNextLine() && i < 10000){ //this i < 10000 is just to help you test, so that it doesn't take too long to run each time. you should eventually move towards reading in the entire file.
      line = scanner.nextLine();
      Scanner dataLine = new Scanner(input.nextLine()).useDelimiter("\",\"");

      String Topic = dataLine.next().replaceAll("\"", "");//removes all the quotation mark
      String Sentiment_string  = dataLine.next().replaceAll("\"", "");
      int Sentiment = sentimentConverter(Sentiment_string);

      String TweetId  = dataLine.next().replaceAll("\"", "");
      String TweetDate = dataLine.next().replaceAll("\"", "");
      String TweetText = dataLine.next().replaceAll("\"", "");

      // Use data to construct Messages
      Tweet tweets= new Tweet(Topic, Sentiment, TweetId, TweetDate, TweetText);
      
      String[] fields = line.split("\",\"");
      fields[0] = fields[0].substring(1);
      try{
        long l = Long.parseLong(fields[0]);
        tweets.add(new Tweet(l, fields[1]));
        i++;
      }
      catch(Exception e){
        System.out.println("file error: "+ e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
      }
    }

    return tweets;
  }
}