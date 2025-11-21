public class SearchService {
    public int binarySearchById(List<Account> accounts, String id) {//implementa busqueda binaria para encontrar una cuenta por su id
        if (accounts == null || id == null) { //verifica si la lista es nula o el id es nulo
            return -1; //si es asi, retorna -1 indicando que no se encontro
        }

        int low = 0; //el inicio de la lista (primer elemento)
        int high = accounts.size() - 1; //el final de la lista (ultimo elemento)

        while (low <= high) { //mientras el indice low sea menor= al indice high
            int mid = (low + high) / 2; //calcula el indice medio de la lista
            String midId = accounts.get(mid).getId(); //obtiene el id de la cuenta en la posicion media
            int cmp = midId.compareTo(id);//compara el id medio con el id buscado

            if (cmp == 0) { //si son iguales
                return mid;//retorna el indice medio (se encontro la cuenta)
            }
            if (cmp < 0) {//si el id medio es menor que el id buscado
                low = mid + 1;//ajusta el indice low para buscar en la mitad derecha
            } else {//si el id medio es mayor que el id buscado
                high = mid - 1;//ajusta el indice high para buscar en la mitad izquierda
            }
        }
        return -1;//si no se encontro la cuenta, retorna -1 indicando que no se encontro
    } 

}
