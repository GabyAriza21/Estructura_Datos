public class SortService {
    public void mergeSortByBalance(List<Account> accounts) { // ordena cuentas por balance (ordenamiento de mezcla)
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
        if (accounts == null || accounts.size() <= 1) {
            return;
        } // iniciar codigo busqueda por nombre
    }
}
