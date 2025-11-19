public class SortService {
    public void mergeSortByBalance(List<Account> accounts) { // ordena cuentas por balance (ordenamiento de mezcla)
        if (accounts == null || accounts.size() <= 1) { // verifica si la lista que recibe es nula o tiene uno o ningun elemento
            return;
        }
        mergeSortByBalance(accounts, 0, accounts.size() - 1); //si tiene mas de un elemento, divide la lista en sublistas y luego les cambia el orden
    }

    private void mergeSortByBalance(List<Account> accounts, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSortByBalance(accounts, left, mid);
        mergeSortByBalance(accounts, mid + 1, right);

        mergeByBalance(accounts, left, mid, right);
    }

    private void mergeByBalance(List<Account> accounts, int left, int mid, int right) {
        List<Account> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (accounts.get(i).getBalance() <= accounts.get(j).getBalance()) {
                temp.add(accounts.get(i));
                i++;
            } else {
                temp.add(accounts.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(accounts.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(accounts.get(j));
            j++;
        }

        for (int k = left; k <= right; k++) {
            accounts.set(k, temp.get(k - left));
        }
    }

    public void quickSortByName(List<Account> accounts) { // ordena cuentas por nombre
        if (accounts == null || accounts.size() <= 1) {
            return;
        } // iniciar codigo busqueda por nombre
    }
}
