package ik.com.anup.LinkedList;
//hint::: need order in additiOn to using k/v pair so only hashmap will not work
//1.four static var headNode, tailNode, size and CachedMap<Int,Node>
//2. Node has prev and next pointer



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Design And Implement LRU Cache
Implement a Least Recently Used (LRU) cache and execute a given sequence of SET(key, value) 
and GET(key) operations. Return the results of all the GET operations from the sequence.

Initially the cache is empty. Cache capacity is a part of the input. 
Keys and values are all positive. GET(key) returns either the cached value or -1 (cache miss). 
SET(key, value) adds or updates the value for the key. If cache is at capacity and a new value needs to be added, 
remove the least recently used (LRU) value first.

Example
{
"capacity": 2,
"query_type": [1, 1, 0, 1, 0, 1, 0],
"key": [5, 10, 5, 15, 10, 5, 5],
"value": [11, 22, 1, 33, 1, 55, 1]
}
Output:

[11, -1, 55]
query_type of 0 means GET and query_type of 1 means SET.

Here are the operations from the input along with the return values and side effects of their execution:

Operation	Cache after	Returned value	Side effect
SET(5, 11)	[5 -> 11]		5 -> 11 added to cache
SET(10, 22)	[10 -> 22, 5 -> 11]		5 -> 11 became LRU
GET(5)	[5 -> 11, 10 -> 22]	11	10 -> 22 became LRU
SET(15, 33)	[15 -> 33, 5 -> 11]		10 -> 22 got evicted
GET(10)	[15 -> 33, 5 -> 11]	-1	Access order unchanged
SET(5, 55)	[5 -> 55, 15 -> 33]		Key 5 updated, became the
most recently used (MRU)
GET(5)	[5 -> 55, 15 -> 33]	55	No change; key 5 already
was the MRU
Notes
The function accepts four arguments:

The cache capacity,
query_type array with 0 for GET and 1 for SET operation,
key array with the keys for all the operations,
value array with the values for SET operations (value to be ignored for GETs).
The three input arrays all have the same length n and together they represent n operations.
Constraints:

1 <= capacity <= 105
1 <= n <= 105
1 <= any key <= 105
1 <= any value <= 105*/
public class LRUCache {

    static class CacheNode {
        private int key;
        private int value;
        private CacheNode next = null;
        private CacheNode prev = null;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final Map<Integer, CacheNode> cacheMap = new HashMap<>();
    private static CacheNode headNode = null;// latest used node
    private static CacheNode tailNode = null;// least latest used node
    private static int size = 0;

    static ArrayList<Integer> implement_lru_cache(int capacity, ArrayList<Integer> query_type, 
    		ArrayList<Integer> key, ArrayList<Integer> value) {

        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < query_type.size(); i++) {

            switch (query_type.get(i)) {
                case 0:
                    result.add(get(key.get(i)));
                    break;
                case 1:
                    put(key.get(i), value.get(i), capacity);
                    break;
                default:
                    throw new RuntimeException("Invalid query type");
            }
        }

        return result;
    }

    private static int get(int key) {

        if (headNode == null) return -1;

        if (!cacheMap.containsKey(key)) return -1;

        extractAndPush(key);
        return headNode.value;//since this headNode is the latest one
    }

    private static void put(int key, int value, int capacity) {

        if (cacheMap.containsKey(key)) {
            cacheMap.get(key).value = value;
            extractAndPush(key);
            return;
        }

        if (size == capacity) {
            cacheMap.remove(tailNode.key);

            CacheNode prevNode = tailNode.prev;
            if (prevNode != null) {
                prevNode.next = null; tailNode.prev= null;
                tailNode = prevNode;
            } else {
                headNode = tailNode = null;
            }

            size--;
        }

        final CacheNode currNode = new CacheNode(key, value);
        cacheMap.put(key, currNode);
        size++;

        if (headNode == null) {
            headNode = currNode;
            tailNode = currNode;
            return;
        }

        currNode.next = headNode;
        headNode.prev = currNode;
        headNode = currNode;//itr
    }

    private static void extractAndPush(int key) {// 1 and 2 steps>> total 8 vars
        final CacheNode cNode = cacheMap.get(key);
        if (headNode == cNode) return;

        //bookkeeping for prev and next node pointers
        CacheNode pNode = cNode.prev;
        CacheNode nNode = cNode.next;

        pNode.next = nNode;

        if (nNode != null) {
            nNode.prev = pNode;
        } else {
            tailNode = pNode;
        }
       // 2. book keeping for currentnode
        cNode.next = headNode;// pull to the front
        cNode.prev = null;//
        //
        headNode.prev = cNode;// headnode becomes secondNode
        headNode = cNode;//cNode is head now
    }
    
    
	/*
	 * public LRUCache(int size) { this.cache = new LinkedHashSet<Integer>(size);
	 * this.size = size; }
	 */
 
    public static void main(String[] args)
    {
       // LRUCache ca = new LRUCache(4);
      
    }
}
