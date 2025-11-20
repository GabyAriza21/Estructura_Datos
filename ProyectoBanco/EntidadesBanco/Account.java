public class Account {
    private String id;
    private String holderName;
    private double balance;
    private AccountStatus status;

    public Account(String id, String holderName) {
        if (id == null || id.trim().isEmpty()) { //verifica si el id:null o si solo tiene espacios en blanco
            throw new IllegalArgumentException("Id invalido"); //si asi es, lanza el mensaje de invalido
        }
        if (holderName == null || holderName.trim().isEmpty()) { //verifica si el nombre:null o si solo tiene espacios en blanco
            throw new IllegalArgumentException("Nombre del titular invalido"); //si asi es, lanza el mensaje de invalido
        }

        this.id = id.trim(); // .trim quita los esapcios
        this.holderName = holderName.trim();
        this.balance = 0; // la cuenta inicia en 0
        this.status = AccountStatus.ACTIVE; // inicia con la cuenta activa
    }

    public String getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void deposit(long amount) { //permite ingresar dinero a la cuenta
        if (amount <= 0) { //verifica que el monto sea mayor a 0, si es 0 o negativo
            throw new IllegalArgumentException("Monto invalido para deposito");//lanza el mensaje
        } 
        this.balance += amount; //si no, suma lo depositado a balance de Account
    }

    public void setHolderName(String newName) { //actualiza el nombre del titular
        if (newName == null || newName.trim().isEmpty()) { //verifica si el nombre es nulo o solo espacios en blanco
            throw new IllegalArgumentException("Nombre del titular invalido");// si asi es, lanza el mensaje
        }
        this.holderName = newName.trim();// si no, se eliminan los espacios en blanco y se actualiza el nombre del titular

    }

    public void withdraw(double amount) { //permite retirar dinero de la cuenta
        if (amount <= 0) { //verifica que el monto sea mayor a 0, si es 0 o negativo
            throw new IllegalArgumentException("Monto invalido para retiro");//lanza el mensaje
        }
        if (amount > this.balance) {//verifica que el monto a retirar no sea mayor al saldo disponible
            throw new IllegalArgumentException("Fondos insuficientes para retiro");//si es mayor, lanza el mensaje
        }
        this.balance -= amount;// si no, resta el monto retirado al balance de Account
    }

    public void close() {// cierra la cuenta
        this.status = AccountStatus.CLOSED;// cambia el estado de la cuenta a cerrada
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id='" + id + '\'' +
                ", Holder='" + holderName + '\'' +
                ", Balance=" + balance +
                ", Status=" + status +
                '}';
    }
}
