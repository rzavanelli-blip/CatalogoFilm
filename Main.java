import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CatalogoFilm catalogo = new CataloFilm();
        Scanner scanner = new Scanner(System.in);

        int scelta;
        do{
            System.out.println("MENU CATALOGO FILM");
            System.out.println("1. Aggiungi film");
            System.out.println("2. Mostra tutti i film");
            System.out.println("3. Ricerca film");
            System.out.println("4. Modifica Film");
            System.out.println("5. Elimina film");
            System.out.println("0. Esci");
            scelta = scanner.nextLine();
            scanner.nextLine();



            // fai gli switch case per tutti i casi
            switch (scelta) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}
