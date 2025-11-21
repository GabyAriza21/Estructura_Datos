public class SortService {
    public void mergeSortByBalance(List<Account> accounts) { // ordena cuentas por balance
        if (accounts == null || accounts.size() <= 1) { // verifica si la lista que recibe es nula o tiene uno o ningun elemento
            return;
        }
        mergeSortByBalance(accounts, 0, accounts.size() - 1); //si tiene mas de un elemento, divide la lista en sublistas y luego les cambia el orden
    }

    private void mergeSortByBalance(List<Account> accounts, int left, int right) { // ordena la sublista de cuentas
        if (left >= right) { // recibe la lista de cuentas y los indices izquierdo y derecho
            return;
        }

        int mid = (left + right) / 2; //verifica si el indice iz mayor= al derecho, si hay mas de un elemento, calcula el punto medio (/2)

        mergeSortByBalance(accounts, left, mid);// llama la funcion para organizar la mitad izquierda 
        mergeSortByBalance(accounts, mid + 1, right); // llama la funcion para organizar la mitad derecha

        mergeByBalance(accounts, left, mid, right); //pone en una sola sublista ordenada a las dos mitades 
    }

    private void mergeByBalance(List<Account> accounts, int left, int mid, int right) { //combina 2 sublistas ordenadas de cuentas en una sola lista ordenada por saldo
        List<Account> temp = new ArrayList<>(); //se crea una lista temporal: guarda elementos combinados en orden
        int i = left; //inicio de la primera mitad
        int j = mid + 1; //inicio de la segunda mitad

        while (i <= mid && j <= right) {//compara saldos de las cuentas en ambas mitades
            if (accounts.get(i).getBalance() <= accounts.get(j).getBalance()) {//si el saldo1 es menor= al saldo2
                temp.add(accounts.get(i));//esa cuenta se va para temp
                i++;//incrementa i
            } else {//si no, saldo2
                temp.add(accounts.get(j));//va para temp
                j++;//incrementa j
            }
        }
        while (i <= mid) { //si la primera mitad tiene elementos sin procesar
            temp.add(accounts.get(i));//se agregan a temp
            i++;
        }

        while (j <= right) {//si la segunda mitad tiene elementos sin procesar
            temp.add(accounts.get(j));//se agregan a temp
            j++;
        }

        for (int k = left; k <= right; k++) { //copia los elementos ordenados de temp a la lista original con las posiciones que son
            accounts.set(k, temp.get(k - left)); //cuadra el indice de temp con la posicion correcta de la lista original
        }
    }

    public void quickSortByName(List<Account> accounts) { // ordena cuentas por nombre
        if (accounts == null || accounts.size() <= 1) { //mira si la lista es nula o si tiene o no elementos
            return;
        } quickSortByName(accounts, 0, accounts.size() -1); //si tiene mas de 1 elemento, divide la lista en sublistas y ordena cada parte segun el nombre del titular
    }

    private void quickSortByName(List<Account> accounts, int low, int high) { // ordena la sublista de cuentas por nombre del titular, recibe la llista de cuentas, y low-high indices
        if (low < high) { //mira si el indice low es menor que high
            int pivotIndex = partitionByName(accounts, low, high); //si cumple, llama a partitionByName: ordena la sublista 
            quickSortByName(accounts, low, pivotIndex - 1); //los nombres menores o iguales al pivote quedan en iz, los nombres mayores al pivote quedan en derecha
            quickSortByName(accounts, pivotIndex + 1, high); //ordena las sublistas a la izquierda y derecha del pivote
        }  
    }

    private int partitionByName(List<Account> accounts, int low, int high){ //recibe la lista de cuentas, el indice inicial de la sublista que se va a particionar y el indice final de la sublista
        String pivot = accounts.get(high).getHolderName().toLowerCase();//pivot: nombre del titular de la cuenta en la posicion high de lista-accounts y se convierte a minusculas
        int i = low - 1; // marca l aposicion donde se colocan los elementos menores= al pivote. en el recorrido de la sublista, los que cumplen la condicion se pasan a la iz de i

        for (int j = low; j < high; j++){ // recorre la sublista desde el indice low hasta high-1
            String currentName = accounts.get(j).getHolderName().toLowerCase(); //se obtiene el nombre del titular de la cuenta en la posicion j y se convierte a minusculas

            if (currentName.compareTo(pivot) <= 0) { //compara el nombre actual con el pivote
                i++; 
                swap(accounts, i, j);// si el nombre actual es menor= al pivote, incrementa i y intercambia las cuentas en las posiciones i y j
            }
        }

        swap(accounts, i + 1, high);//se intercambia el elemento en la posicion i+1 con el pivote, dejando al pivote en la posicion que es
        return i + 1; //retorna la nueva posicion del pivote

    }

    public void quickSortById(List<Account> accounts){ // ordena cuentas por id
        if (accounts == null || accounts.size() <= 1) { //verifica si la lista:null o si tiene uno o ningun elemento
            return;
        }
        quickSortById(accounts, 0, accounts.size() - 1); //si tiene mas de un elemento, divide la lista en sublistas y ordena cada parte segun el id
    }

    private void quickSortById(List<Account> accounts, int low, int high) { // ordena la sublista de cuentas por id, recibe la lista de cuentas, y low-high indices
        if (low < high) { //mira si el indice low es menor que high
            int pivotIndex = partitionById(accounts, low, high);// si cumple, llama a partitionById: ordena la sublista
            quickSortById(accounts, low, pivotIndex - 1);//los id menores o iguales al pivote quedan en iz, los id mayores al pivote quedan en derecha
            quickSortById(accounts, pivotIndex + 1, high);//ordena las sublistas a la izquierda y derecha del pivote
        }
    }

    private int partitionById(List<Account> accounts, int low, int high) {//recibe la lista de cuentas, el indice inicial de la sublista que se va a particionar y el indice final de la sublista
        String pivot = accounts.get(high).getId();//pivot: id de la cuenta en la posicion high de lista-accounts
        int i = low - 1;// marca la posicion donde se colocan los elementos menores= al pivote. en el recorrido de la sublista, los que cumplen la condicion se pasan a la iz de i

        for (int j = low; j < high; j++) { // recorre la sublista desde el indice low hasta high-1
            String currentId = accounts.get(j).getId();//se obtiene el id de la cuenta en la posicion j

            if (currentId.compareTo(pivot) <= 0) {//compara el id actual con el pivote
                i++;
                swap(accounts, i, j);// si el id actual es menor= al pivote, incrementa i y intercambia las cuentas en las posiciones i y j
            }
        }

        swap(accounts, i + 1, high);//se intercambia el elemento en la posicion i+1 con el pivote, dejando al pivote en la posicion que es
        return i + 1;//retorna la nueva posicion del pivote
    }

    private void swap(List<Account> accounts, int i, int j){ //intercambia las cuentas en las posiciones i y j de la lista accounts
        Account temp = accounts.get(i);// guarda la cuenta en la posicion i en una variable temporal
        accounts.set(i, accounts.get(j));// coloca la cuenta en la posicion j en la posicion i
        accounts.set(j, temp);// coloca la cuenta guardada en temp en la posicion j (los elementos en i y j quedan intercambiados)
    }
}
 