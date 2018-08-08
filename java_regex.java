import java .io .BufferedReader;
import java .io .FileReader;
import java .io .IOException;

public class java_regex {
    public static void main( String [] args ) {
        String file = "./files/results.csv";
        String line;

        try {
            // Abre el archivo
            BufferedReader br = new BufferedReader( new FileReader( file ) );
            // Itera cada uno de las líneas del archivo
            while( ( line = br .readLine() ) != null ) {
                System .out .println( line );
            }
        }
        catch( Exception e ) {
            System .out .println( "Error: " + e );
        }
    }
}
