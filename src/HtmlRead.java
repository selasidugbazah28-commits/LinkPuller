import java.net.*;
import java.io.*;
import java.util.Scanner;

public class HtmlRead {
    public static void main(String[] args) {
        HtmlRead app= new HtmlRead();
    }
    public HtmlRead(){

        try{

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter a link (Add the entirety of it): ");
            String website = input.nextLine();

            System.out.println("You would like to see links that contain: ");
            String filter2 = input.nextLine();


            System.out.println();
            //URL fred = new URL("https://open.spotify.com/"); // Where we look to pull links from (Spotify)
            URL bob = new URL(website); // Where we look to pull links from
            URLConnection urlc = bob.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
              //  if (line.contains("milton")) {
                //    System.out.println("where = " + line.indexOf(".edu"));
                 //   System.out.println(line);
               // }


                String[] pieces = line.split("href=\""); // Splits the line at href=" to print each link seperately
                //line.replace("\'"," \"");
                String filter = "Spotify"; // Filters for only links that contain spotify in them

                for (int i = 1; i < pieces.length; i++) { // starts at 1 since 0 is just the text before the first link
                    int end = pieces[i].indexOf("\""); // finds the quote at the end of each link
                        String link = pieces[i].substring(0, end); // keeps only the text between the href and last quote
                    if (link.contains("")){
                        //System.out.println(link); // This allows me to see every link in spotify
                    }
                    if (link.toLowerCase().contains(filter2.toLowerCase()) && link.contains("http") || link.contains("href=")){ // This makes the filter include lowercase and capital. Everything that contains milton and has http (No partial links) are printed out

                        System.out.println(link); // This prints out only links that contain spotify
                    }
                }
            }
            reader.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }



}