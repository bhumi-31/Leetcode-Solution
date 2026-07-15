class Pair{
    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    ArrayList<Pair> cache;
    int n;
    public LRUCache(int capacity) {
        n = capacity;
        cache = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i = 0;  i < cache.size(); i++){
            if(cache.get(i).key == key){
                Pair p = cache.remove(i);
                cache.add(0, p);

                return p.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < cache.size(); i++){
            if(cache.get(i).key == key){
                cache.remove(i);
                cache.add(0, new Pair(key, value));
                return;
            }
        }

        if(cache.size() == n){
            cache.remove(cache.size() - 1);
        }

        cache.add(0, new Pair(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */