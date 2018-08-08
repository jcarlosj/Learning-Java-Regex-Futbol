import java .io .BufferedReader;
import java .io .FileReader;
import java .io .IOException;
import java .util .regex .Matcher;
import java .util .regex .Pattern;

public class java_regex {
    public static void main( String [] args ) {
        Pattern patron = Pattern .compile( "^\\d{4}\\-.*[zkZK].*$" );         // Compila la expresión regular en Java hay que escapar los \ backslaches, motivo por el que se usan dobles
        String file = "./files/results.csv";
        String line;

        try {
            // Abre el archivo
            BufferedReader br = new BufferedReader( new FileReader( file ) );
            // Itera cada uno de las líneas del archivo
            while( ( line = br .readLine() ) != null ) {
                Matcher matcher = patron .matcher( line );

                // Valida si la expresión ha hecho match
                if( matcher .find() ) {
                    System .out .println( line );
                }

            }
        }
        catch( Exception e ) {
            System .out .println( "Error: " + e );
        }
    }
}
