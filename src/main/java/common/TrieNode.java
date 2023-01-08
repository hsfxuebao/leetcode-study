package common;

/**
 * Trie 树节点实现
 *
 */
public class TrieNode<V> {
    V val = null;
    TrieNode<V>[] children = new TrieNode[256];
}