import ProyectoBanco.EntidadesBanco.Account;
import ProyectoBanco.EntidadesBanco.TransactionType;


public class BankService {
    private List<Account> accounts; // contiene todas las cuentas bancarias del sistema
    private List<Transaction> transactions; // contiene todas las transacciones realizadas en el sistema
    private Stack<Transaction> historyStack; // pila para deshacer transacciones

    public BankService() {
        this.accounts = new ArrayList<>(); // inicializa lista de cuentas vacia
        this.transactions = new ArrayList<>(); // inicializa lista de transacciones vacia
        this.historyStack = new Stack<>(); // inicializa pila vacia
    }

    // crear cuenta
    public void createAccount(String id, String holderName) {
        if (getAccountById(id) != null) {
            throw new IllegalArgumentException("Cuenta con ID ya existe.");// una cuenta con el mismo id, lanza expetion
        }
        accounts.add(new Account(id, holderName)); // si no, crea nueva cuenta y la agrega en lista cuentas
    }

    // cerrar cuenta
    public void closeAccount(String id) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // si no esta la cuenta, lanza exception
        }
        account.close(); // si esta la cuenta, el metodo close la cierra
    }

    // acctualizar nombre titular
    public void updateHolderName(String id, String newName) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // si no esta la cuenta, lanza exception
        }
        account.setHolderName(newName); // si esta la cuenta, actualiza el nombre del titular
    }

    // depositar
    public void deposit(String id, double amount) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
        if (account.getStatus() == AccountStatus.CLOSED) {
            throw new IllegalStateException("No se puede depositar en una cuenta cerrada.");
        }
        account.deposit(amount); // si existe la cuenta, realiza el deposito
        transactions.add(new Transaction(TransactionType.DEPOSIT, null, id, amount)); // registra la transaccion
        historyStack.push(new Transaction(TransactionType.DEPOSIT, null, id, amount)); // registra la transaccion
    }

    // retirar
    public void withdraw(String id, double amount) {
        Account account = getAccountById(id);
        if (account == null) {
            throw new IllegalArgumentException("Cuenta no encontrada.");
        }
        if (account.getStatus() == AccountStatus.CLOSED) {
            throw new IllegalStateException("No se puede retirar de una cuenta cerrada.");
        }
        account.withdraw(amount); // si esta la cuenta, realiza el retiro
        transactions.add(new Transaction(TransactionType.WITHDRAW, id, null, amount));// registra la transaccion
        historyStack.push(new Transaction(TransactionType.WITHDRAW, id, null, amount)); // registra la transaccion
    }

    // transferir
    public void transfer(String fromId, String toId, double amount) {
        Account originAccount = getAccountById(fromId); // transfiere fondos entre dos cuentas
        Account destAccount = getAccountById(toId);
        if (originAccount == null || destAccount == null) {
            throw new IllegalArgumentException("Cuenta no encontrada."); // se asegura de que si existan, sino lanza
                                                                         // exception
        }
        if (originAccount.getStatus() == AccountStatus.CLOSED || destAccount.getStatus() == AccountStatus.CLOSED) {
            throw new IllegalStateException("No se puede transferir desde o hacia una cuenta cerrada.");
        }
        originAccount.withdraw(amount);
        destAccount.deposit(amount);
        transactions.add(new Transaction(TransactionType.TRANSFER, fromId, toId, amount)); // registra la transaccion
        historyStack.push(new Transaction(TransactionType.TRANSFER, fromId, toId, amount)); // registra la transaccion

    }

    public void undoLastTransaction() {
        if (historyStack.isEmpty()) {
            throw new IllegalArgumentException("No hay transacciones para deshacer."); // si la pila esta vacia, lanza
                                                                                       // exception
        }
        Transaction lastTransaction = historyStack.pop(); // obtiene la ultima transaccion de la pila
        transactions.remove(lastTransaction); // la elimina de la lista de transacciones
        switch (lastTransaction.getType()) { // deshace la transaccion segun su tipo
            case DEPOSIT: {
                Account depositAccount = getAccountById(lastTransaction.getToId());// busca la cuenta de destino
                if (depositAccount != null) { // si la cuenta existe
                    depositAccount.withdraw(lastTransaction.getAmount()); // hace un retiro para deshacer el deposito
                }
                break;
            }

            case WITHDRAW: {
                Account withdrawAccount = getAccountById(lastTransaction.getFromId());//busca la cuenta de origen
                if (withdrawAccount != null) {// si la cuenta existe
                    withdrawAccount.deposit(lastTransaction.getAmount());// hace un deposito para deshacer el retiro
                }
                break;
            }

            case TRANSFER: {
                Account fromAccount = getAccountById(lastTransaction.getFromId());// busca la cuenta de origen
                Account toAccount = getAccountById(lastTransaction.getToId());// busca la cuenta de destino
                if (fromAccount != null && toAccount != null) { // si ambas cuentas existen
                    toAccount.withdraw(lastTransaction.getAmount()); // hace un retiro en la cuenta destino
                    fromAccount.deposit(lastTransaction.getAmount()); // hace un deposito en la cuenta origen
                }
                break;
            }
        }
        System.out.println("Ultima transaccion deshecha exitosamente.");
    }

    // encontrar cuenta por ID 
    private Account getAccountById(String id) {
        for (Account account : accounts) { // recorre la lista de cuentas, (buscando por su id)
            if (account.getId().equals(id)) {
                return account; // si la encuentra, la retorna
            }
        }
        return null;
    }

    // obtener historial por cuenta
    public List<Transaction> getHistoryByAccount(String id) {
        List<Transaction> list = new ArrayList<>();
        for (Transaction transaction : transactions) { // recorre la lista de transacciones, buscando las que coincidan
                                                       // con el id de la cuenta
            if ((transaction.getFromId() != null && id.equals(transaction.getFromId()))
                    || (transaction.getToId() != null && id.equals(transaction.getToId()))) {
                list.add(transaction); // si coincide, agrega la transaccion a la lista de resultados
            }
        }
        return list; // retorna la lista de transacciones encontradas
    }

    // obtener todas las cuentas para reportes
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts); // retorna una copia de la lista de cuentas
    }
}