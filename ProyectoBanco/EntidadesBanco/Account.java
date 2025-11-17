public class Account {
    private String id; 
    private String nombreTitular;  
    private double balance; 
    private AccountStatus estado;
    
    public Account(String id, String nombreTitular){
        if (id == null ){
            throw new IllegalArgumentException("Id invalido"); 
        }
        if (nombreTitular == null){
                throw new IllegalArgumentException("Nombre del titular invalido");
            }
            this.id = id.trim(); //.trim quita los esapcios 
            this.nombreTitular = nombreTitular.trim(); 
            this.balance = 0; 
            this.estado = AccountEstado.ACTIVE; //inicia con la cuenta activa
    }

    public String getId(){
        return id; 
    }

    public String nombreTitular(){
        return nombreTitular;
    }

    public double balance(){
        return balance; 
    }

    public AccountStatus getEstado(){ 
        return estado; 
    }
} 

//poner el estatus, nombre de la persona poner el override (to string)
//ver si es debito o credito 
//
