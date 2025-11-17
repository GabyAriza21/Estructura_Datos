import ProyectoBanco.EntidadesBanco.Account;

public class BankService {
    private List<Account> accounts; // contiene todas las cuentas bancarias del sistema
    private List<Transaction> transactions; // contiene todas las transacciones realizadas en el sistema

    public BankSerive(){
        this.accounts = new ArrayList<>(); // inicializa lista de cuentas vacia
        this.transactions = new ArrayList<>(); // inicializa lista de transacciones vacia 
    }

    // crear cuenta
    public void crearAccount(String id, String nombreTitular) {
        if (getAccountById(id) != null) {
            throw new IllegalArgumentException("Cuenta con ID ya existe.");// una cuenta con el mismo id, lanza expetion
        }
        accounts.add(new Account(id, nombreTitular)); // si no, crea nueva cuenta y la agrega en lista cuentas
    }

    // cerrar cuenta
    public void cerrarAccount(String id) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // si no esta la cuenta, lanza exception
        }
        account.close(); // si esta la cuenta, el metodo close la cierra
    }

    // acctualizar nombre titular
    public void actualizarNombreTitular(String id, String newNombre) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // si no esta la cuenta, lanza exception
        }
        account.setNombreTitular(newNombre); // si esta la cuenta, actualiza el nombre del titular
    }

    // depositar
    public void deposito(String id, double monto) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
        account.deposito(monto); // si existe la cuenta, realiza el deposito
        transactions.add(new Transaction(TipoTransaccion.DEPOSITO, null, id, monto));
    }

    // retirar
    public void retiro(String id, double monto) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
        account.retiro(monto); // si esta la cuenta, realiza el retiro
        transactions.add(new Transaction(TipoTransaccion.RETIRO, id, null, monto));
    }

    // transferir
    public void transferencia(String destinoId, String origenId, double monto) {
        Account origenAccount = getAccountById(origenId); // transfiere fondos entre dos cuentas
        Account destinoAccount = getAccountById(destinoId);
        if (origenAccount == null || destinoAccount == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // se asegura de que si existan, sino lanza
                                                                         // exception
        }
        origenAccount.retiro(monto);
        destinoAccount.deposito(monto);
        transactions.add(new Transaction(TipoTransaccion.TRANSFERENCIA, origenId, destinoId, monto)); // registra la
                                                                                                      // transaccion
    }

    // encontrar cuenta por ID
    private Account encontrarAccountById(String id) {
        for (Account account : accounts) { // recorre la lista de cuentas, buscando por su id
            if (account.getId().equals(id)) {
                return account; // si la encuentra, la retorna
            }
        }
        return null;
    }

    // obtener historial por cuenta
    public List<Transaction> obtenerHistorialPorCuenta(String id) {
        List<Transaction> list = new ArrayList<>();
        for (Transaction transaction : transactions) { // recorre la lista de transacciones, buscando las que coincidan
                                                       // con el id de la cuenta
            if (transaction.getOrigenId().equals(id) || transaction.getDestinoId().equals(id)) {
                list.add(transaction); // si coincide, agrega la transaccion a la lista de resultados
            }
        }
        return list; // retorna la lista de transacciones encontradas
    }

    // obtener todas las cuentas para reportes
    public List<Account> obtenerTodasLasCuentas() {
        return new ArrayList<>(accounts); // retorna una copia de la lista de cuentas
    }
}