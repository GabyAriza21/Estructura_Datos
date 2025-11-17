public class Account {
    private String id; 
    private String holderName; 
    private double balanceCents; 
    private AccountStatus status;
    
    public Account(String id, String holderName){
        if (id == null ){
            throw new IllegalArgumentException("Id invalido"); 
        }
        if (holderName == null){
                throw new IllegalArgumentException("Nombre del titular invalido");
            }
            this.id = id.trim(); //.trim quita los esapcios 
            this.holderName = holderName.trim(); 
            this.balanceCents = 0; 
            this.status = AccountStatus.ACTIVE; //inicia con la cuenta activa
    }

    public String getId(){
        return id; 
    }

    public String holderName(){
        return holderName;
    }

    public double balanceCents(){
        return balanceCents; 
    }

    public AccountStatus getStatus(){
        return status; 
    }
} 

//poner el estatus, nombre de la persona poner el override (to string)
//ver si es debito o credito 
//
