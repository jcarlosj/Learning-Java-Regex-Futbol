import java .io .BufferedReader;
import java .io .FileReader;
import java .io .IOException;
import java .util .regex .Matcher;
import java .util .regex .Pattern;

public class java_regex {
    public static void main( String [] args ) {
        Pattern patron = Pattern .compile( "^([\\d]{4,4})\\-[\\d]{2}\\-[\\d]{2},(.+),(.+),(\\d+),(\\d+),.*$" );         // Compila la expresión regular en Java hay que escapar los \ backslaches, motivo por el que se usan dobles
        String file = "./files/results.csv";
        String line;
        int goleada = 0, diferencia;

        try {
            // Abre el archivo
            BufferedReader br = new BufferedReader( new FileReader( file ) );
            // Itera cada uno de las líneas del archivo
            while( ( line = br .readLine() ) != null ) {
                Matcher matcher = patron .matcher( line );

                // Valida si la expresión ha hecho match
                if( matcher .find() ) {
                    int total = Integer .parseInt( matcher .group( 4 ) ) - Integer .parseInt( matcher .group( 5 ) );
                    diferencia = total < 0 ? total * ( -1 ) : total;
                    if( 3 < diferencia ) {
                        System .out .println( matcher .group( 1 ) + ": " + matcher .group( 4 ) + " - " + matcher .group( 5 ) + " | " + matcher .group( 2 ) + " Vs " + matcher .group( 3 ) );
                        goleada++;
                    }
                }
            }
            System .out .println( "Partidos ganados por goleada: " + goleada );
        }
        catch( Exception e ) {
            System .out .println( "Error: " + e );
        }
    }
}
