public class Account {
    private String id;
    private String nombreTitular;
    private double balance;
    private EstadoCuenta estado;

    public Account(String id, String nombreTitular) {
        if (id == null) {
            throw new IllegalArgumentException("Id invalido");
        }
        if (nombreTitular == null) {
            throw new IllegalArgumentException("Nombre del titular invalido");
        }
        this.id = id.trim(); // .trim quita los esapcios
        this.nombreTitular = nombreTitular.trim();
        this.balance = 0; // la cuenta inicia en 0
        this.estado = EstadoCuenta.ACTIVE; // inicia con la cuenta activa
    }

    public String getId() {
        return id;
    }

    public String nombreTitular() {
        return nombreTitular;
    }

    public double balance() {
        return balance;
    }

    public AccountStatus getEstado() {
        return estado;
    }

    public void deposito(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto invalido para deposito");
            this.balance += monto;
        }
    }

    public void setNombreTitular(String newNombre) {
        if (newNombre == null) {
            throw new IllegalArgumentException("Nombre del titular invalido");
        }
        this.nombreTitular = newNombre.trim();

    }

    public void retiro(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto invalido para retiro");
        }
        if (monto > this.balance) {
            throw new IllegalArgumentException("Fondos insuficientes para retiro");
        }
        this.balance -= monto;
    }

    public void cerrar() {
        this.estado = EstadoCuenta.CLOSED;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", nombreTitular='" + nombreTitular + '\'' +
                ", balance=" + balance +
                ", estado=" + estado +
                '}';
    }
}
