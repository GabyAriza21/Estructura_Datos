public class Account {
    private String id;
    private String holderName;
    private double balance;
    private AccountStatus status;

    public Account(String id, String holderName) {
        if (id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        if (nombreTitular == null) {
            throw new IllegalArgumentException("Nombre del titular invalido");
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

    public void deposito(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Monto invalido para deposito");
        } 
        this.balance += amount;
    }

    public void setHolderName(String newName) {
        if (newName == null) {
            throw new IllegalArgumentException("Nombre del titular invalido");
        }
        this.holderName = newName.trim();

    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Monto invalido para retiro");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Fondos insuficientes para retiro");
        }
        this.balance -= amount;
    }

    public void close() {
        this.status = AccountStatus.CLOSED;
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
