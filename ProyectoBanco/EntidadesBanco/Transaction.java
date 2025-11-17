public class Transaction {
    private final TipoTransaccion tipo;
    private final String origenId;
    private final String destinoId;
    private final long monto;

    public Transaction(TipoTransaccion tipo, String origenId, String destinoId, long amount) {
        if (tipo == null)
            throw new IllegalArgumentException("Tipo de transacción inválido.");
        if (monto <= 0)
            throw new IllegalArgumentException("Monto debe ser > 0.");

        this.tipo = tipo;
        this.origenId = origenId;
        this.destinoId = destinoId;
        this.monto = monto;
    }

    public TransactionType getTipo() {
        return tipo;
    }

    public String getOrigenId() {
        return origenId;
    }

    public String getDestinoId() {
        return destinoId;
    }

    public long getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tipo=" + tipo +
                ", origenId='" + origenId + '\'' +
                ", destinoId='" + destinoId + '\'' +
                ", monto=" + monto +
                '}';
    }
}