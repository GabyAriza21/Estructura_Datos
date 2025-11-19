public class ConsoleUi {
    private BankService bank = new BankService(); // transmite la logica de negocio del banco
    private SortService sorter = new SortService(); // transmite orden (saldo, nombre) de las listas de las cuentas
    private SearchService searcher = new SearchService();// transmite la busqueda binaria por Id
    private Scanner sc = new Scanner(System.in); // lee la entrada del usuario

    public void start() {
        int option; // almacena la opcion seleccionada del usuario
        do {
            showMenu(); // muestra las opciones disponibles
            option = Interger.parseInt(sc.nextLine());// lee la opcion seleccionada por el usuario
            handleOption(option);// guarda la opcion seleccionada y la procesa
        } while (option != 0);
    }

    private void showMenu() {
        System.out.println("1. Crear Account");
        System.out.println("2. Actualizar nombre titular");
        System.out.println("3. Cerrar Account");
        System.out.println("4. Deposito");
        System.out.println("5. Retiro");
        System.out.println("6. Transferencia");
        System.out.println("7. Buscar cuenta por Id");
        System.out.println("8. Reporte por balance");
        System.out.println("9. Reporte por nombre titular");
        System.out.println("10. Ver historial");
        System.out.println("0. Salir");

    }

    private void handleOption(int option){
        switch (option){
            case 1:
                break;
            case 2:
                break; 
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;

            case 0:
                System.out.println("Saliendo...");
                break;

            default:    
                System.out.println("Opcion invalida. Intente de nuevo.");
                break;
        }

    }

}
