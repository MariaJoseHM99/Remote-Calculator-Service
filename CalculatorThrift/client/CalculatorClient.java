import java.util.Scanner;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;



public class CalculatorClient {

    private static Scanner reader;
    private static int firstDigit;
    private static int secondDigit;
    private static Calculator.Iface client;

    public static void main(String[] args) throws TException {

        TTransport transport = new TSocket("localhost", 8080);
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new Calculator.Client(protocol);
        reader = new Scanner(System.in);
        transport.open();

       
        int option = 0;

        do {
            ExposeMenu();       
            option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                ReadDigits("Suma");
                ShowResult(client.Sum(firstDigit,secondDigit));
                break;

                case 2:
                ReadDigits("Resta");
                ShowResult(client.Subtract(firstDigit,secondDigit));
                break;

                case 3:
                ReadDigits("Multiplicación");
                ShowResult(client.Multiply(firstDigit,secondDigit));
                break;

                case 4:
                ReadDigits("División");
                ShowResult(client.Divide(firstDigit,secondDigit));
                break;

                case -1:
                System.out.println("Estás saliendo...");
                break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (option != -1);

        transport.close();


    }


    private static void ExposeMenu(){
        System.out.println(" --- C  A  L  C  U  L  A  D  O  R  A --- ");
        System.out.println("1.Suma");
        System.out.println("2.Resta");
        System.out.println("3.Multiplicación");
        System.out.println("4.División");
        System.out.println("Si desea salir ingrese -1");
        System.out.println("\nSelecciona una opción: ");
    }

    private static void ReadDigits(String mathOperation){
        System.out.println("Ingrese el primer numero de la " + mathOperation + ":");
        firstDigit = reader.nextInt();

        System.out.println("Ingrese el segundo numero de la " + mathOperation + ":");
        secondDigit = reader.nextInt(); 

        reader.nextLine();

    }

    private static void ShowResult(Result result){
        if (result.errorMessage != null) {
            System.out.println(result.errorMessage);
        }

        System.out.println("El resultado de la operación es: " + result.result);
        System.out.println("Presione ENTER para continuar");
        reader.nextLine();
        
    }
}
