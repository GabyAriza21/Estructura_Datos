import ProyectoBanco.LogicaSistema.BankService;

public class ConsoleUi {
    private BankService bank = new BankService(); // transmite la logica de negocio del banco
    private SortService sorter = new SortService(); // transmite orden (saldo, nombre) de las listas de las cuentas
    private SearchService searcher = new SearchService();// transmite la busqueda binaria por Id
    private Scanner sc = new Scanner(System.in); // lee la entrada del usuario

    public void start() {
        int option; // almacena la opcion seleccionada del usuario
        do {
            showMenu(); // muestra las opciones disponibles
            option = Integer.parseInt(sc.nextLine());// lee la opcion seleccionada por el usuario
            handleOption(option);// guarda la opcion seleccionada y la procesa
        } while (option != 0);
    }

    private void showMenu() {
        System.out.println("=== Bank Final Proyect===");
        System.out.println("1. Create Account");
        System.out.println("2. Update Holder Name");
        System.out.println("3. Close Account");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Transfer");
        System.out.println("7. Search Account by ID");
        System.out.println("8. Repor by balance");
        System.out.println("9. Report by holder name");
        System.out.println("10. View account history");
        System.out.prinln("11. Undo last transaction");
        System.out.println("0. Exit");
        System.out.println("===========================");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1:
                createAccount();
                break;
            case 2:
                updateHolderName();
                break;
            case 3:
                closeAccount();
                break;
            case 4:
                deposit();
                break;
            case 5:
                withdraw();
                break;
            case 6:
                transfer();
                break;
            case 7:
                searchById();
                break;
            case 8:
                reportByBalance();
                break;
            case 9:
                reportByName();
                break;
            case 10:
                viewHistory();
                break;
            case 11:
                undoLastTransaction();
                break;

            case 0:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Opcion invalida. Intente de nuevo.");
                break;
        }
    }

    private void createAccount() {// crea la cuenta nueva
        System.out.println("Ingrese el ID de la cuenta:"); // pide el id de la cuenta a crear
        String id = sc.nextLine(); // lee el id ingresado por el usuario y la guarda en la variable id

        System.out.println("Ingrese el nombre del titular:"); // pide el nombre del titular de la cuenta a crear
        String holderName = sc.nextLine(); // lee el nombre ingresado por el usuario y la guarda en la variable
                                           // holderName

        bank.createAccount(id, holderName);// llama al metodo createAccount de BankService para crear la cuenta
        System.out.println("Cuenta creada exitosamente.");// mensaje de exito
    }

    private void updateHolderName() {// actualiza el nombre del titular de la cuenta
        System.out.println("Ingrese el ID de la cuenta a actualizar:");// pide el id de la cuenta a actualizar
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable id

        System.out.println("Ingrese el nuevo nombre del titular:"); // pide el nuevo nombre del titular de la cuenta
        String newHolderName = sc.nextLine();// lee el nuevo nombre ingresado por el usuario y la guarda en la variable
                                             // newHolderName

        bank.updateHolderName(id, newHolderName); // llama al metodo updateHolderName de BankService para actualizar el
                                                  // nombre del titular
        System.out.println("Nombre del titular actualizado exitosamente.");// mensaje de exito
    }

    private void closeAccount() {// cierra la cuenta
        System.out.println("Ingrese el ID de la cuenta a cerrar:");// pide el id de la cuenta a cerrar
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable id

        bank.closeAccount(id); // llama al metodo closeAccount de BankService para cerrar la cuenta
        System.out.println("Cuenta cerrada exitosamente.");// mensaje de exito
    }

    private void deposit() { // deposita dinero en la cuenta
        System.out.println("Ingrese el ID de la cuenta para depositar:");// pide el id de la cuenta para depositar
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda en id

        System.out.println("Ingrese el monto a depositar:");// pide el monto a depositar
        double amount = Double.parseDouble(sc.nextLine());// lee el monto ingresado por el usuario

        bank.deposit(id, amount);// llama al metodo deposit de BankService para depositar el dinero
        System.out.println("Deposito exitoso.");// mensaje de exito
    }

    private void withdraw() {// etirar dinero de la cuenta
        System.out.println("Ingrese el ID de la cuenta para retirar:");// pide el id de la cuenta para retirar
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable id

        System.out.println("Ingrese el monto a retirar:");// pide el monto a retirar
        double amount = Double.parseDouble(sc.nextLine());// lee el monto ingresado por el usuario y la guarda en la variable
                                                    // amount

        bank.withdraw(id, amount);// llama al metodo withdraw de BankService para retirar el dinero
        System.out.println("Retiro exitoso.");// mensaje de exito
    }

    private void transfer() { // transfiere dinero de una cuenta a otra
        System.out.println("Ingrese el ID de la cuenta origen:");// pide el id de la cuenta origen
        String from = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable from

        System.out.println("Ingrese el ID de la cuenta destino:");// pide el id de la cuenta destino
        String to = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable to

        System.out.println("Ingrese la cantidad:");// pide la cantidad a transferir
        double amount = Double.parseDouble(sc.nextLine());// lee la cantidad ingresada por el usuario y la guarda en la variable amount

        bank.transfer(from, to, amount);// llama al metodo transfer de BankService para transferir el dinero
        System.out.println("Transferencia exitosa.");// mensaje de exito
    }

    private void searchById() {
        System.out.println("Ingrese el ID de la cuenta a buscar:");// pide el id de la cuenta a buscar
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda en la variable id

        List<Account> accounts = bank.getAllAccounts();// obtiene la lista de todas las cuentas
        sorter.quickSortById(accounts);// ordena la lista de cuentas por nombre

        int index = searcher.binarySearchById(accounts, id);// busca la cuenta por id usando busqueda binaria
        if (index >= 0) {
            System.out.println("Cuenta encontrada: " + accounts.get(index));// muestra la cuenta encontrada
        } else {
            System.out.println("Cuenta no encontrada.");// mensaje de cuenta no encontrada
        }
    }

    private void reportByBalance() {// genera un reporte de cuentas ordenadas por saldo
        List<Account> accounts = bank.getAllAccounts();// obtiene la lista de todas las cuentas
        sorter.mergeSortByBalance(accounts);// ordena la lista de cuentas por saldo

        System.out.println("Reporte de cuentas por saldo:");// muestra el reporte de cuentas por saldo
        for (Account acc : accounts) {
            System.out.println(acc);// muestra cada cuenta
        }
    }

    private void reportByName() {
        List<Account> accounts = bank.getAllAccounts();// obtiene la lista de todas las cuentas
        sorter.quickSortByName(accounts);// ordena la lista de cuentas por nombre

        System.out.println("Reporte de cuentas por nombre:");// muestra el reporte de cuentas por nombre
        for (Account acc : accounts) {
            System.out.println(acc);// muestra cada cuenta
        }
    }

    private void viewHistory() {
        System.out.println("Ingrese el ID de la cuenta para ver el historial:");// pide el id de la cuenta para ver el
                                                                                // historial
        String id = sc.nextLine();// lee el id ingresado por el usuario y la guarda

        List<Transaction> history = bank.getHistoryByAccount(id);// obtiene el historial de transacciones de la cuenta
        System.out.println("Historial de transacciones:");// muestra el historial de transacciones
        for (Transaction tran : history) {
            System.out.println(tran);// muestra cada transaccion
        }
    } 

    private void undoLastTransaction(){
        bank.undoLastTransaction();//llama al metodo undoLastTransaction de BankService para deshacer la ultima transaccion
        System.out.println("Ultima transaccion deshecha exitosamente.");//mensaje de exito
    } 
}
