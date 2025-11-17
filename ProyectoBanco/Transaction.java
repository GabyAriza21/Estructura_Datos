public class Transaction {
    private final TransactionType type;
    private final String fromId;
    private final String toId;
    private final long amount;

    public Transaction(TransactionType type, String fromId, String toId, long amount) {
        if (type == null)
            throw new IllegalArgumentException("Tipo de transacción inválido.");
        if (amount <= 0)
            throw new IllegalArgumentException("Monto debe ser > 0.");

        this.type = type;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", amount=" + amount +
                '}';
    }
}