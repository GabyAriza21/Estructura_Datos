public class SearchService {
    public int binarySearchById(List<Account> accounts, String id) {
        if (accounts == null || id == null) {
            return -1;
        }

        int low = 0;
        int high = accounts.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midId = accounts.get(mid).getId();
            int cmp = midId.compareTo(id);

            if (cmp == 0) {
                return mid;
            }
            if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
