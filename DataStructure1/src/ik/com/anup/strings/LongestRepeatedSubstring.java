package ik.com.anup.strings;



//find  abetter solution  may be KMP can be used 



























import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*Find the longest substring that repeats at least twice in the given string.

Example
{
"s": "efabcdhefhabcdiefi"
}
Output:

"abcd"
"abcd" repeats twice, "ef" repeats three times, some shorter substrings like "a" repeat, too. "abcd" is the longest of them all.

Notes
If multiple repeated substrings are the longest, return any one of them.
If no substring repeats, return an empty string.
Constraints:

2 <= length of the given string <= 2*105
Given string consists of lowercase English letters, a-z*/
public class LongestRepeatedSubstring {

    public static String get_longest_repeated_substring(String s) {
        SuffixTrie st = buildSuffixTree(s + "{");
        return findLRS(st);
    }

    private static SuffixTrie buildSuffixTree(String str) {
        int n = str.length();
        byte[] a = new byte[n];
        for (int i = 0; i < n; i++) {
            a[i] = (byte) (str.charAt(i) - 'a');
        }
        Node root = new Node(0, 0, 0, null);
        Node node = root;
        for (int i = 0, tail = 0; i < n; i++, tail++) {
            Node last = null;
            while (tail >= 0) {
                Node ch = node.children.get(a[i - tail]);
                while (ch != null && tail >= ch.end - ch.begin) {
                    tail -= ch.end - ch.begin;
                    node = ch;
                    ch = ch.children.get(a[i - tail]);
                }
                if (ch == null) {
                    node.children.put(a[i], new Node(i, n, node.depth + node.end - node.begin, node));
                    if (last != null) {
                        last.suffixLink = node;
                    }
                    last = null;
                } else {
                    byte t = a[ch.begin + tail];
                    if (t == a[i]) {
                        if (last != null) {
                            last.suffixLink = node;
                        }
                        break;
                    } else {
                        Node splitNode = new Node(ch.begin, ch.begin + tail,
                            node.depth + node.end - node.begin, node);
                        splitNode.children.put(a[i], new Node(i, n, ch.depth + tail, splitNode));
                        splitNode.children.put(t, ch);
                        ch.begin += tail;
                        ch.depth += tail;
                        ch.parent = splitNode;
                        node.children.put(a[i - tail], splitNode);
                        if (last != null) {
                            last.suffixLink = splitNode;
                        }
                        last = splitNode;
                    }
                }
                if (node == root) {
                    --tail;
                } else {
                    node = node.suffixLink;
                }
            }
        }
        return new SuffixTrie(root, str);
    }

    private static String findLRS(SuffixTrie suffixTrie) {
        Node node = suffixTrie.root;
        String s = suffixTrie.str;
        int lrsLength = 0;
        int lrsSuffixIndex = -1;
        String lrs = "";
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.children.isEmpty()) {
                int currLength = current.depth;
                if (currLength > lrsLength) {
                    lrsLength = currLength;
                    lrsSuffixIndex = s.length() - (current.depth + current.end - current.begin);
                }
            } else {
                for (Map.Entry<Byte, Node> entry : current.children.entrySet()) {
                    stack.push(current.children.get(entry.getKey()));
                }
            }
        }
        if (lrsLength > 0) {
            lrs = s.substring(lrsSuffixIndex, lrsSuffixIndex + lrsLength);
        }
        return lrs;
    }

    private static class SuffixTrie {
        final Node root;
        final String str;

        private SuffixTrie(Node root, String str) {
            this.root = root;
            this.str = str;
        }
    }

    private static class Node {
        int begin;
        int end;
        int depth;
        Node parent;
        Map<Byte, Node> children;
        Node suffixLink;

        Node(int begin, int end, int depth, Node parent) {
            this.begin = begin;
            this.end = end;
            this.parent = parent;
            this.depth = depth;
            children = new HashMap<>();
        }
    }

}
