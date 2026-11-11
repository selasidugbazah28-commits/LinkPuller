import java.net.*;
import java.io.*;

public class HtmlRead {
    public static void main(String[] args) {
        HtmlRead app= new HtmlRead();
    }
    public HtmlRead(){

        try{
            System.out.println();
            URL fred = new URL("https://www.milton.edu/");
            URLConnection urlc = fred.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
              //  if (line.contains("milton")) {
                //    System.out.println("where = " + line.indexOf(".edu"));
                 //   System.out.println(line);
               // }


                String[] pieces = line.split("href=\""); // Splits the line at href to print each one seperately
                //line.replace("\'"," \"");
                String filter = "Milton"; // Filters for only links that have spotify in them

                for (int i = 1; i < pieces.length; i++) {
                    int end = pieces[i].indexOf("\"");
                        String link = pieces[i].substring(0, end);
                    if (link.contains("")){
                        //System.out.println(link); // This allows me to see every link in spotify
                    }
                    if (link.toLowerCase().contains(filter.toLowerCase())){

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