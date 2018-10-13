# CodeInterview

## 一、维护该仓库的初衷

Mac上著名软件HomeBrew的作者在2015年面试Google的时候被问到了一道翻转二叉树的题目，没做出来，因此最后被拒……于是他在个人推特上抱怨到:

> Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.



数据结构与算法是基本功。以前零零散散地刷过一些算法题。但日常开发中没怎么用到，一段时间过后又不熟悉了。建立这个仓库维护自己做过的算法题，方便回顾的同时，希望能够给有需要的同学提供一些参考。



## 二、该仓库中主要包括以下内容：

- 剑指 offer 部分题解
- leetCode 部分题解
- 程序员代码面试指南
- 八大排序
- 大数据量和空间限制相关题目
- 逻辑题



## 三、LeetCode 题目大致分类



- [ Leetcode](https://github.com/geemaple/algorithm#leetcode)
  - [Math](https://github.com/geemaple/algorithm#math)
  - [Array and String](https://github.com/geemaple/algorithm#array-and-string)
  - [Two Pointers](https://github.com/geemaple/algorithm#two-pointers)
  - [Linked List](https://github.com/geemaple/algorithm#linked-list)
  - [Binary Search](https://github.com/geemaple/algorithm#binary-search)
  - [Divide and Conquer](https://github.com/geemaple/algorithm#divide-and-conquer)
  - [Tree Traversal](https://github.com/geemaple/algorithm#tree-traversal)
  - [Graph Traversal](https://github.com/geemaple/algorithm#graph-traversal)
  - [Backtracking](https://github.com/geemaple/algorithm#backtracking)
  - [Hash Table](https://github.com/geemaple/algorithm#hash-table)
  - [Heap](https://github.com/geemaple/algorithm#heap)
  - [Stack](https://github.com/geemaple/algorithm#stack)
  - [Dynamic Programming](https://github.com/geemaple/algorithm#dynamic-programming)
  - [Greedy](https://github.com/geemaple/algorithm#greedy)
  - [Union Find](https://github.com/geemaple/algorithm#union-find)
  - [Trie](https://github.com/geemaple/algorithm#trie)
  - [Other](https://github.com/geemaple/algorithm#other)
- [Lintcode](https://github.com/geemaple/algorithm#lintcode)



### Math

| Problem                          | Solution                                                     | Time     | Space  | Difficulty | Tag  | Note |
| -------------------------------- | ------------------------------------------------------------ | -------- | ------ | ---------- | ---- | ---- |
| 002.add-two-numbers              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/2.add-two-numbers.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/2.add-two-numbers.py) | O(N)     | O(1)   | Medium/S-- |      |      |
| 007.reverse-integer              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/7.reverse-integer.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/7.reverse-integer.py) | O(L)     | O(1)   | Easy/S--   |      |      |
| 043.multiply-strings             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/43.multiply-strings.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/43.multiply-strings.py) | O(M*N)   | O(M+N) | Medium/S++ |      |      |
| 048.rotate-image                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/48.rotate-image.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/48.rotate-image.py) | O(M * N) | O(1)   | Medium/S++ |      |      |
| 050.powx-n                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/50.powx-n.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/50.powx-n.py) | O(logN)  | O(1)   | Medium/S++ |      |      |
| 067.add-binary                   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/67.add-binary,cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/67.add-binary.py) | O(N)     | O(1)   | Easy       |      |      |
| 311.sparse-matrix-multiplication | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/311.sparse-matrix-multiplication.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/311.sparse-matrix-multiplication.py) | O(N^3)   | O(N^2) | Medium/S-- |      |      |
| 415.add-strings                  | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/415.add-strings.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/415.add-strings.py) | O(N)     | O(1)   | Easy       |      |      |
| 836.rectangle-overlap            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/836.rectangle-overlap.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/836.rectangle-overlap.py) | O(1)     | O(1)   | Easy       |      |      |

| Problem              | Solution                                                     | Time | Difficulty | Tag                   | Note |
| -------------------- | ------------------------------------------------------------ | ---- | ---------- | --------------------- | ---- |
| 012.integer-to-roman | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/12.integer-to-roman.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/12.integer-to-roman.py) | O(N) | Medium     | N = length of results |      |
| 013.roman-to-integer | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/13.roman-to-integer.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/13.roman-to-integer.py) | O(N) | Easy       |                       |      |
| 136.single-number    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/136.single-number.cpp) | O(N) | Easy       | bits                  |      |
| 202.happy-number     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/202.happy-number.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/202.happy-number.py) | O(N) | Easy       |                       |      |

### Array and String

| Problem                                     | Solution                                                     | Time        | Difficulty | Tag    | Note                                      |
| ------------------------------------------- | ------------------------------------------------------------ | ----------- | ---------- | ------ | ----------------------------------------- |
| 53.maximum-subarray                         | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/53.maximum-subarray.py) | O(N)        | Easy       |        |                                           |
| 54.spiral-matrix                            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/54.spiral-matrix.cpp) | O(N)        | Medium     |        |                                           |
| 66.plus-one                                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/66.plus-one.cpp) | O(N)        | Easy       |        |                                           |
| 118.pascals-triangle                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/118.pascals-triangle.cpp) | O(N^2)      | Easy       |        |                                           |
| 350.intersection-of-two-arrays-ii           | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/350.intersection-of-two-arrays-ii.py) | O(N * logN) | Easy       |        |                                           |
| 485.max-consecutive-ones                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/485.max-consecutive-ones.cpp) | O(N)        | Easy       |        |                                           |
| 498.diagonal-traverse                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/498.diagonal-traverse.cpp) | O(M * N)    | Medium     |        |                                           |
| 560.subarray-sum-equals-k                   | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/560.subarray-sum-equals-k.py) | O(N)        | Medium     |        |                                           |
| 561.array-partition-i                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/561.array-partition-i.cpp) | O(N * logN) | Easy       |        |                                           |
| 724.find-pivot-index                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/724.find-pivot-index.cpp) | O(N)        | Easy       |        |                                           |
| 747.largest-number-at-least-twice-of-others | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/747.largest-number-at-least-twice-of-others) | O(N)        | Easy       |        |                                           |
| 796.rotate-string                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/796.rotate-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/796.rotate-string.py) | O(N^2)      | Easy       | string | TODO: Rabin-Karp Algorithm, KMP algorithm |
| 859.buddy-strings                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/859.buddy-strings.cpp) | O(N)        | Easy       | string |                                           |

| Problem                                       | Solution                                                     | Time        | Space | Difficulty | Tag                   | Note                        |
| --------------------------------------------- | ------------------------------------------------------------ | ----------- | ----- | ---------- | --------------------- | --------------------------- |
| 042.trapping-rain-water                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/42.trapping-rain-water.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/42.trapping-rain-water.py) | O(N)        | O(N)  | Hard       | Scan Twice            |                             |
| 056.merge-intervals                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/56.merge-intervals.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/56.merge-intervals.py) | O(N * logN) | O(1)  | Medium     | Sort                  | N = number of intervals     |
| 057.insert-interval                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/57.insert-interval.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/57.insert-interval.py) | O(N)        | O(1)  | Hard       | Sort                  | N = number of intervals     |
| 157.read-n-characters-given-read4             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/157.read-n-characters-given-read4.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/157.read-n-characters-given-read4.py) | O(N)        | O(1)  | Easy       | String                |                             |
| 161.one-edit-distance                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/161.one-edit-distance.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/161.one-edit-distance.py) | O(N)        | O(1)  | Medium     | String                |                             |
| 163.missing-ranges                            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/163.missing-ranges.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/163.missing-ranges.py) | O(N)        | O(1)  | Medium     | Array                 | Mind int overflow           |
| 215.kth-largest-element-in-an-array           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/215.kth-largest-element-in-an-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/215.kth-largest-element-in-an-array.py) | O(N)        | O(1)  | Medium/S-- | quick-select          | best = O(N), worst = O(N^2) |
| 240.search-a-2d-matrix-ii                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/240.search-a-2d-matrix-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/240.search-a-2d-matrix-ii.py) | O(N + M)    | O(1)  | Medium     |                       |                             |
| 271.encode-and-decode-strings                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/271.encode-and-decode-strings.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/271.encode-and-decode-strings.py) | O(N)        | O(1)  | Easy       | String                | N = count of chars          |
| 277.find-the-celebrity                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/277.find-the-celebrity.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/277.find-the-celebrity.py) | O(N)        | O(1)  | Medium     |                       |                             |
| 346.moving-average-from-data-stream           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/346.moving-average-from-data-stream.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/346.moving-average-from-data-stream.py) | O(N)        | O(K)  | Easy       | Queue(Circular array) |                             |
| 388.longest-absolute-file-path                | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/388.longest-absolute-file-path.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/388.longest-absolute-file-path.py) | O(N)        | O(N)  | Medium     | String                |                             |
| 408.valid-word-abbreviation                   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/408.valid-word-abbreviation.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/408.valid-word-abbreviation.py) | O(N)        | O(1)  | Easy       |                       |                             |
| 527.word-abbreviation                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/527.word-abbreviation.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/527.word-abbreviation.py) | O(N * L)    | O(N)  | Hard       | L = avg word length   |                             |
| 674.longest-continuous-increasing-subsequence | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/674.longest-continuous-increasing-subsequence.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/674.longest-continuous-increasing-subsequence.py) | O(N)        | O(1)  | Easy       |                       |                             |

### Two Pointers

| Problem                                                    | Solution                                                     | Time                       | Space | Difficulty | Tag                 | Note         |
| ---------------------------------------------------------- | ------------------------------------------------------------ | -------------------------- | ----- | ---------- | ------------------- | ------------ |
| 003.longest-substring-without-repeating-characters         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/3.longest-substring-without-repeating-characters.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/3.longest-substring-without-repeating-characters.py) | O(N)                       | O(N)  | Medium     |                     |              |
| 026.remove-duplicates-from-sorted-array                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/26.remove-duplicates-from-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/26.remove-duplicates-from-sorted-array.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 027.remove-element                                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/27.remove-element.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/27.remove-element.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 028.implement-strstr                                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/28.implement-strstr.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/28.implement-strstr.py) | O(M + N)                   | O(1)  | Easy       | Pattern Searching   | KMP          |
| 042.trapping-rain-water                                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/42.trapping-rain-water.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/42.trapping-rain-water.py) | O(N)                       | O(1)  | Hard       | Two Pointers        |              |
| 076.minimum-window-substring                               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/76.minimum-window-substring.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/76.minimum-window-substring.py) | O(N)                       | O(N)  | Hard       |                     |              |
| 088.merge-sorted-array                                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/88.merge-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/88.merge-sorted-array.py) | O(N + M)                   | O(1)  | Easy       |                     |              |
| 125.valid-palindrome                                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/125.valid-palindrome.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/125.valid-palindrome.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 141.linked-list-cycle                                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/141.linked-list-cycle.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/141.linked-list-cycle.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 159.longest-substring-with-at-most-two-distinct-characters | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/159.longest-substring-with-at-most-two-distinct-characters.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/159.longest-substring-with-at-most-two-distinct-characters.py) | O(N)                       | O(N)  | Hard       |                     |              |
| 167.two-sum-ii-input-array-is-sorted                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/167.two-sum-ii-input-array-is-sorted.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/167.two-sum-ii-input-array-is-sorted.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 209.minimum-size-subarray-sum                              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/209.minimum-size-subarray-sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/209.minimum-size-subarray-sum.py) | O(N)                       | O(1)  | Medium     |                     |              |
| 234.palindrome-linked-list                                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/234.palindrome-linked-list.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/234.palindrome-linked-list.py) | O(N)                       | O(1)  | Easy       |                     | maybe Harder |
| 283.move-zeroes                                            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/283.move-zeroes.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/283.move-zeroes.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 340.longest-substring-with-at-most-k-distinct-characters   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/340.longest-substring-with-at-most-k-distinct-characters.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/340.longest-substring-with-at-most-k-distinct-characters.py) | O(N)                       | O(N)  | Hard       |                     |              |
| 344.reverse-string                                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/344.reverse-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/344.reverse-string.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 345.reverse-vowels-of-a-string                             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/345.reverse-vowels-of-a-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/345.reverse-vowels-of-a-string.py) | O(N)                       | O(1)  | Easy       |                     |              |
| 349.intersection-of-two-arrays                             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/349.intersection-of-two-arrays.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/349.intersection-of-two-arrays.py) | O(K * logK), k = max(M, N) | O(1)  | Easy       | hash, binary-search |              |
| 350.intersection-of-two-arrays-ii                          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/350.intersection-of-two-arrays-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/350.intersection-of-two-arrays-ii.py) | O(K * logK), k = max(M, N) | O(1)  | Easy       | hash, binary-search |              |
| 532.k-diff-pairs-in-an-array                               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/532.k-diff-pairs-in-an-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/532.k-diff-pairs-in-an-array.py) | O(N * logN)                | O(1)  | Easy       | Hash                |              |
| 844.backspace-string-compare                               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/844.backspace-string-compare.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/844.backspace-string-compare.py) | O(N)                       | O(1)  | Easy       | stack               |              |

### Two Pointers(legacy)

| Problem                              | Solution                                                     | Time     | Difficulty | Tag           | Note |
| ------------------------------------ | ------------------------------------------------------------ | -------- | ---------- | ------------- | ---- |
| 15.3sum                              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/15.3sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/15.3sum.py) | O(N^2)   | Medium     |               |      |
| 16.3sum-closest                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/16.3sum-closest.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/16.3sum-closest.py) | O(N^2)   | Medium     |               |      |
| 18.4sum                              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/18.4sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/18.4sum.py) | O(N^3)   | Medium     |               |      |
| 19.remove-nth-node-from-end-of-list  | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/19.remove-nth-node-from-end-of-list.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/19.remove-nth-node-from-end-of-list.py) | O(N)     | Medium     |               |      |
| 75.sort-colors                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/75.sort-colors.cpp) [python](https://github.com/geemaple/algorithm/blob/master/leetcode/75.sort-colors.py) | O(N)     | Medium     | counting-sort |      |
| 142.linked-list-cycle-ii             | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/142.linked-list-cycle-ii.py) | O(N)     | Medium     | linked-list   |      |
| 160.intersection-of-two-linked-lists | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/160.intersection-of-two-linked-lists.py) | O(N + M) | Easy       | linked-list   |      |

### Linked List

| Problem                           | Solution                                                     | Time        | Difficulty | Tag  | Note |
| --------------------------------- | ------------------------------------------------------------ | ----------- | ---------- | ---- | ---- |
| 21.merge-two-sorted-lists         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/21.merge-two-sorted-lists.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/21.merge-two-sorted-lists.py) | O(N)        | Easy       |      |      |
| 25.reverse-nodes-in-k-group       | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/25.reverse-nodes-in-k-group.py) | O(N)        | Hard       |      |      |
| 61.rotate-list                    | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/61.rotate-list.py) | O(N)        | Medium     |      |      |
| 86.partition-list                 | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/86.partition-list.py) | O(N)        | Medium     |      |      |
| 92.reverse-linked-list-ii         | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/92.reverse-linked-list-ii.py) | O(N)        | Medium     |      |      |
| 138.copy-list-with-random-pointer | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/138.copy-list-with-random-pointer.py) | O(N)        | Medium     |      |      |
| 143.reorder-list                  | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/143.reorder-list.py) | O(N)        | Medium     |      |      |
| 148.sort-list                     | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/148.sort-list.py) | O(N * logN) | Medium     |      |      |
| 203.remove-linked-list-elements   | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/203.remove-linked-list-elements.py) | O(N)        | Easy       |      |      |
| 206.reverse-linked-list           | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/206.reverse-linked-list.py) | O(N)        | Easy       |      |      |
| 237.delete-node-in-a-linked-list  | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/237.delete-node-in-a-linked-list.py) | O(1)        | Easy       |      |      |
| 328.odd-even-linked-list          | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/328.odd-even-linked-list.py) | O(N)        | Medium     |      |      |

### Binary Search

| Problem                                                     | Solution                                                     | Time             | Space | Difficulty | Tag           | Note                  |
| ----------------------------------------------------------- | ------------------------------------------------------------ | ---------------- | ----- | ---------- | ------------- | --------------------- |
| 029.divide-two-integers                                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/29.divide-two-integers.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/29.divide-two-integers.py) | O(logN)          | O(1)  | Medium/S++ | Math          |                       |
| $033.search-in-rotated-sorted-array                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/33.search-in-rotated-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/33.search-in-rotated-sorted-array.py) | O(logN)          | O(1)  | Medium/S++ |               |                       |
| 034.find-first-and-last-position-of-element-in-sorted-array | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/34.find-first-and-last-position-of-element-in-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/34.find-first-and-last-position-of-element-in-sorted-array.py) | O(LogN)          | O(1)  | Medium     |               |                       |
| 069.sqrtx                                                   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/69.sqrtx.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/69.sqrtx.py) | O(logN)          | O(1)  | Easy       |               |                       |
| 074.search-a-2d-matrix                                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/74.search-a-2d-matrix.cpp),[python](https://github.com/geemaple/algorithm/blob/master/leetcode/74.search-a-2d-matrix.py) | O(logN)          | O(1)  | Medium     | N = row * col |                       |
| 081.search-in-rotated-sorted-array-ii                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/81.search-in-rotated-sorted-array-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/81.search-in-rotated-sorted-array-ii.py) | O(logN) ~ O(N)   | O(1)  | Medium/S++ |               |                       |
| 153.find-minimum-in-rotated-sorted-array                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/153.find-minimum-in-rotated-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/153.find-minimum-in-rotated-sorted-array.py) | O(logN)          | O(1)  | Medium     |               |                       |
| 154.find-minimum-in-rotated-sorted-array-ii                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/154.find-minimum-in-rotated-sorted-array-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/154.find-minimum-in-rotated-sorted-array-ii.py) | O(logN) ~ O(N)   | O(1)  | Hard       |               |                       |
| 162.find-peak-element                                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/162.find-peak-element.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/162.find-peak-element.py) | O(logN)          | O(1)  | Medium     |               |                       |
| 278.first-bad-version                                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/278.first-bad-version.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/278.first-bad-version.py) | O(logN)          | O(1)  | Easy       |               |                       |
| 302.smallest-rectangle-enclosing-black-pixels               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/302.smallest-rectangle-enclosing-black-pixels.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/302.smallest-rectangle-enclosing-black-pixels.py) | O(MLogN + NLogM) | O(1)  | Hard/SSS   |               |                       |
| 374.guess-number-higher-or-lower                            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/374.guess-number-higher-or-lower.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/374.guess-number-higher-or-lower.py) | O(LogN)          | O(1)  | Easy       |               |                       |
| 704.binary-search                                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/704.binary-search.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/704.binary-search.py) | O(logN)          | O(1)  | Easy       |               |                       |
| 852.peak-index-in-a-mountain-array                          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/852.peak-index-in-a-mountain-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/852.peak-index-in-a-mountain-array.py) | O(logN)          | O(1)  | Easy       |               | Golden-section search |

### Divide and Conquer

| Problem                                     | Solution                                                     | Time          | Difficulty | Tag  | Note                    |
| ------------------------------------------- | ------------------------------------------------------------ | ------------- | ---------- | ---- | ----------------------- |
| 4.median-of-two-sorted-arrays               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/4.median-of-two-sorted-arrays.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/4.median-of-two-sorted-arrays.py) | O(log(M + N)) | Hard       |      |                         |
| 98.validate-binary-search-tree              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/98.validate-binary-search-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/98.validate-binary-search-tree.py) | O(N)          | Medium     |      | TODO: inorder-traversal |
| 104.maximum-depth-of-binary-tree            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/104.maximum-depth-of-binary-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/104.maximum-depth-of-binary-tree.py) | O(N)          | Easy       |      |                         |
| 110.balanced-binary-tree                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/110.balanced-binary-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/110.balanced-binary-tree.py) | O(N)          | Easy       |      |                         |
| 236.lowest-common-ancestor-of-a-binary-tree | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/236.lowest-common-ancestor-of-a-binary-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/236.lowest-common-ancestor-of-a-binary-tree.py) | O(N)          | Medium     |      |                         |

| Problem                      | Solution                                                     | Time     | Space | Difficulty | Tag  | Note                |
| ---------------------------- | ------------------------------------------------------------ | -------- | ----- | ---------- | ---- | ------------------- |
| 282.expression-add-operators | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/282.expression-add-operators.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/282.expression-add-operators.py) | O(2 ^ N) | O(N)  | Hard/SSS   | DFS  | N = length of input |

### Tree Traversal

| Problem                                  | Solution                                                     | Time | Difficulty | Tag  | Note |
| ---------------------------------------- | ------------------------------------------------------------ | ---- | ---------- | ---- | ---- |
| 94.binary-tree-inorder-traversal         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/94.binary-tree-inorder-traversal.cpp) | O(N) | Medium     |      |      |
| 102.binary-tree-level-order-traversal    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/102.binary-tree-level-order-traversal.cpp) | O(N) | Medium     |      |      |
| 107.binary-tree-level-order-traversal-ii | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/107.binary-tree-level-order-traversal-ii.cpp) | O(N) | Easy       |      |      |
| 144.binary-tree-preorder-traversal       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/144.binary-tree-preorder-traversal.cpp) | O(N) | Medium     |      |      |

| Problem                                  | Solution                                                     | Time     | Space    | Difficulty | Tag  | Note                   |
| ---------------------------------------- | ------------------------------------------------------------ | -------- | -------- | ---------- | ---- | ---------------------- |
| 130.surrounded-regions                   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/130.surrounded-regions.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/130.surrounded-regions.py) | O(M * N) | O(M & N) | Medium     | BFS  |                        |
| 156.binary-tree-upside-down              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/156.binary-tree-upside-down.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/156.binary-tree-upside-down.py) | O(V)     | O(1)     | Medium     |      |                        |
| 285.inorder-successor-in-bst             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/285.inorder-successor-in-bst.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/285.inorder-successor-in-bst.py) | O(H)     | O(1)     | Medium     | BST  | H = height of the tree |
| 286.walls-and-gates                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/286.walls-and-gates.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/286.walls-and-gates.py) | O(M * N) | O(M * N) | Medium     | BFS  |                        |
| 314.binary-tree-vertical-order-traversal | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/314.binary-tree-vertical-order-traversal.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/314.binary-tree-vertical-order-traversal.py) | O(V)     | O(V)     | Medium     |      |                        |
| 366.find-leaves-of-binary-tree           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/366.find-leaves-of-binary-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/366.find-leaves-of-binary-tree.py) | O(V)     | O(V)     | Medium     |      |                        |
| 433.minimum-genetic-mutation             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/433.minimum-genetic-mutation.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/433.minimum-genetic-mutation.py) | O(V + E) | O(N)     | Medium     |      |                        |
| 538.convert-bst-to-greater-tree          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/538.convert-bst-to-greater-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/538.convert-bst-to-greater-tree.py) | O(V)     | O(1)     | Easy       |      |                        |

### Graph Traversal

| Problem                     | Solution                                                     | Time       | Difficulty | Tag              | Note       |
| --------------------------- | ------------------------------------------------------------ | ---------- | ---------- | ---------------- | ---------- |
| 127.word-ladder             | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/127.word-ladder.py) | O(N * L^2) | Medium     | BFS              |            |
| 200.number-of-islands       | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/200.number-of-islands.py) | O(M x N)   | Medium     | BFS/DFS          | union-find |
| 207.course-schedule         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/207.course-schedule.cpp) | O(V + E)   | Medium     |                  |            |
| 210.course-schedule-ii      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/210.course-schedule-ii.cpp) | O(V + E)   | Medium     | topological-sort |            |
| 444.sequence-reconstruction | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode.444.sequence-reconstruction.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/444.sequence-reconstruction.py) | O(V+E)     | Medium     | topological-sort |            |

### Backtracking

| Problem                     | Solution                                                     | Time           | Difficulty | Tag       | Note                         |
| --------------------------- | ------------------------------------------------------------ | -------------- | ---------- | --------- | ---------------------------- |
| 39.combination-sum          | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/39.combination-sum.py) | ???            | Medium     | DFS       |                              |
| 40.combination-sum-ii       | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/40.combination-sum-ii.py) | ???            | Medium     | DFS       |                              |
| 46.permutations             | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/46.permutations.py) | ???            | Medium     | DFS       |                              |
| 47.permutations-ii          | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/47.permutations-ii.py) | ???            | Medium     | DFS       |                              |
| 51.n-queens                 | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/51.n-queens.py) | ???            | Hard       | DFS       |                              |
| 52.n-queens-ii              | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/52.n-queens-ii.py) | ???            | Hard       | DFS       |                              |
| 078.subsets                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/78.subsets.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/78.subsets.py) | O(N * 2^N)     | Medium/S-- | DFS       | bit-manipulation / iterative |
| 090.subsets-ii              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/90.subsets-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/90.subsets-ii.py) | O(N * 2^N)     | Medium/S++ | DFS       |                              |
| 126.word-ladder-ii          | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/126.word-ladder-ii.py) | O((V+E) * L^2) | Hard       | BFS + DFS |                              |
| 131.palindrome-partitioning | [python](https://github.com/geemaple/algorithm/blob/master/leetcode/131.palindrome-partitioning.py) | ???            | Medium     | DFS       |                              |

| Problem                                  | Solution                                                     | Time             | Space    | Difficulty | Tag                    | Note                |
| ---------------------------------------- | ------------------------------------------------------------ | ---------------- | -------- | ---------- | ---------------------- | ------------------- |
| 17.letter-combinations-of-a-phone-number | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/17.letter-combinations-of-a-phone-number.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/17.letter-combinations-of-a-phone-number.py) | O(2 ^ N)         | O(N)     | Medium     | Time in [3 ^ N, 4 ^ N] |                     |
| 079.word-search                          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/79.word-search.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/79.word-search.py) | O(M * N * L * L) | O(M * N) | Medium     | DFS                    | L = length of words |

### Hash Table

| Problem                               | Solution                                                     | Time            | Difficulty | Tag                                                          | Note |
| ------------------------------------- | ------------------------------------------------------------ | --------------- | ---------- | ------------------------------------------------------------ | ---- |
| 1.two-sum                             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/1.two-sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/1.two-sum.py) | O(N)            | Easy       |                                                              |      |
| 36.valid-sudoku                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/36.valid-sudoku.cpp) | O(N ^ 2)        | Medium     | array-indexes                                                |      |
| 49.group-anagrams                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/49.group-anagrams.cpp) | O(N * k * Logk) | Medium     |                                                              |      |
| 170.two-sum-iii-data-structure-design | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/170.two-sum-iii-data-structure-design.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/170.two-sum-iii-data-structure-design.py) | O(N)            | Easy       |                                                              |      |
| 202.happy-number                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/202.happy-number.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/202.happy-number.py) | O(N)            | Easy       |                                                              |      |
| 217.contains-duplicate                | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/217.contains-duplicate.cpp) | O(N)            | Easy       |                                                              |      |
| 219.contains-duplicate-ii             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/219.contains-duplicate-ii.cpp) | O(N)            | Easy       |                                                              |      |
| 249.group-shifted-strings             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/249.group-shifted-strings.cpp) | O(N * K)        | Medium     |                                                              |      |
| 347.top-k-frequent-elements           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/347.top-k-frequent-elements.cpp) | O(N * LogN)     | Medium     | TODO: quick-sort, bucket-sort                                |      |
| 349.intersection-of-two-arrays        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/349.intersection-of-two-arrays.cpp) | O(M + N)        | Easy       |                                                              |      |
| 350.intersection-of-two-arrays-ii     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/350.intersection-of-two-arrays-ii.cpp) | O(M * N)        | Easy       |                                                              |      |
| 359.logger-rate-limiter               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/359.logger-rate-limiter.cpp) | O(1)            | Easy       | [amortized](https://stackoverflow.com/questions/200384/constant-amortized-time) |      |
| 380.insert-delete-getrandom-o1        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/380.insert-delete-getrandom-o1.cpp) | O(1)            | Medium     |                                                              |      |
| 454.4sum-ii                           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/454.4sum-ii.cpp) | O(N ^ 2)        | Medium     |                                                              |      |
| 599.minimum-index-sum-of-two-lists    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/599.minimum-index-sum-of-two-lists.cpp) | O(M + N)        | Easy       |                                                              |      |
| 652.find-duplicate-subtrees           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/652.find-duplicate-subtrees.cpp) | O(N)            | Medium     |                                                              |      |
| 771.jewels-and-stones                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/771.jewels-and-stones.cpp) | O(M + N)        | Easy       |                                                              |      |

| Problem                                | Solution                                                     | Time | Space | Difficulty | Tag        | Note |
| -------------------------------------- | ------------------------------------------------------------ | ---- | ----- | ---------- | ---------- | ---- |
| 128.longest-consecutive-sequence       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/128.longest-consecutive-sequence.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/128.longest-consecutive-sequence.py) | O(N) | O(N)  | Hard       | Union-find |      |
| 205.isomorphic-strings                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/205.isomorphic-strings.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/205.isomorphic-strings.py) | O(N) | O(N)  | Easy       |            |      |
| 246.strobogrammatic-number             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/246.strobogrammatic-number.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/246.strobogrammatic-number.py) | O(N) | O(1)  | Easy       |            |      |
| 288.unique-word-abbreviation           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/288.unique-word-abbreviation.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/288.unique-word-abbreviation.py) | O(1) | O(N)  | Medium     |            |      |
| 387.first-unique-character-in-a-string | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/387.first-unique-character-in-a-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/387.first-unique-character-in-a-string.py) | O(N) | O(N)  | Easy       |            |      |
| 438.find-all-anagrams-in-a-string      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/438.find-all-anagrams-in-a-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/438.find-all-anagrams-in-a-string.py) | O(N) | O(N)  | Easy       |            |      |

### Heap

| Problem                                     | Solution                                                     | Time                  | Space    | Difficulty | Tag                                | Note |
| ------------------------------------------- | ------------------------------------------------------------ | --------------------- | -------- | ---------- | ---------------------------------- | ---- |
| 23.merge-k-sorted-lists                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/23.merge-k-sorted-lists.cpp) | O(N * LogK)           | -        | Hard       | TODO: merge-sort, bottom-up        |      |
| 378.kth-smallest-element-in-a-sorted-matrix | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/378.kth-smallest-element-in-a-sorted-matrix.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/378.kth-smallest-element-in-a-sorted-matrix.py) | O((K + M) * LogM)     | O(M)     | Medium     | TODO: binary-search, O(N) solution |      |
| 407.trapping-rain-water-ii                  | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/407.trapping-rain-water-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/407.trapping-rain-water-ii.py) | O(M * N * Log(M + N)) | O(M + N) | Hard       |                                    |      |

### Stack

| Problem              | Solution                                                     | Time | Space | Difficulty | Tag  | Note |
| -------------------- | ------------------------------------------------------------ | ---- | ----- | ---------- | ---- | ---- |
| 20.valid-parentheses | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/20.valid-parentheses.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/20.valid-parentheses.py) | O(N) | O(N)  | Easy       |      |      |

### Dynamic Programming

> PS: Often space could be optimized using circular array, it not that hard, just mod every new and old indexes against the size(For 2D: row, col, diagonal)

| Problem                      | Solution                                                     | Time   | Difficulty | Tag         | Note |
| ---------------------------- | ------------------------------------------------------------ | ------ | ---------- | ----------- | ---- |
| 70.climbing-stairs           | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/70.climbing-stairs.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/70.climbing-stairs.py) | O(N)   | Easy       | Coordinates |      |
| 120.triangle                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/120.triangle.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/120.triangle.py) | O(N^2) | Medium     | Coordinates |      |
| 368.largest-divisible-subset | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/368.largest-divisible-subset.cpp) | O(N^2) | Medium     |             |      |
| 403.frog-jump                | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/403.frog-jump.cpp) | O(N^2) | Hard       |             |      |

| Problem                                 | Solution                                                     | Time       | Space    | Difficulty | Note                       | Grade   |
| --------------------------------------- | ------------------------------------------------------------ | ---------- | -------- | ---------- | -------------------------- | ------- |
| 010.regular-expression-matching         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/10.regular-expression-matching.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/10.regular-expression-matching.py) | O(MN)      | O(MN)    | Hard/S++   | Sequence                   |         |
| 044.wildcard-matching                   | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/44.wildcard-matching.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/44.wildcard-matching.py) | O(MN)      | O(MN)    | Hard       | Sequence                   |         |
| 062.unique-paths                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/62.unique-paths.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/62.unique-paths.py) | O(M * N)   | O(M * N) | Medium     | Coordinates                |         |
| 063.unique-paths-ii                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/63.unique-paths-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/63.unique-paths-ii.py) | O(M * N)   | O(M * N) | Medium     | Coordinates                |         |
| 064.minimum-path-sum                    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/64.minimum-path-sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/64.minimum-path-sum.py) | O(M * N)   | O(M * N) | Medium     | Coordinates                |         |
| 072.edit-distance                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/72.edit-distance.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/72.edit-distance.py) | O(MN)      | O(MN)    | Hard/S--   | Sequence                   |         |
| 087.scramble-string                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/87.scramble-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/87.scramble-string.py) | O(N^4)     | O(N^3)   | Hard/SSS   | Range                      |         |
| 091.decode-ways                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/91.decode-ways.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/91.decode-ways.py) | O(N)       | O(N)     | Medium/S++ | Partition                  |         |
| 097.interleaving-string                 | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/97.interleaving-string.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/97.interleaving-string.py) | O(MN)      | O(MN)    | Hard/S--   | Sequence                   |         |
| 115.distinct-subsequences               | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/115.distinct-subsequences.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/115.distinct-subsequences.py) | O(MN)      | O(MN)    | Hard/S--   | Sequence                   |         |
| 132.palindrome-partitioning-ii          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/132.palindrome-partitioning-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/132.palindrome-partitioning-ii.py) | O(N^2)     | O(N^2)   | Hard       | Partition                  |         |
| 188.best-time-to-buy-and-sell-stock-iv  | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/188.best-time-to-buy-and-sell-stock-iv.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/188.best-time-to-buy-and-sell-stock-iv.py) | O(N*K)     | O(N * K) | Hard/SSS   |                            |         |
| 198.house-robber                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/198.house-robber.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/198.house-robber.py) | O(N)       | O(N)     | Easy       | Sequence                   |         |
| 121.best-time-to-buy-and-sell-stock     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/121.best-time-to-buy-and-sell-stock.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/121.best-time-to-buy-and-sell-stock.py) | O(N)       | O(1)     | Easy       | Coordinates                |         |
| 123.best-time-to-buy-and-sell-stock-iii | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/123.best-time-to-buy-and-sell-stock-iii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/123.best-time-to-buy-and-sell-stock-iii.py) | O(N)       | O(N)     | Hard/SSS   |                            |         |
| 213.house-robber-ii                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/213.house-robber-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/213.house-robber-ii.py) | O(N)       | O(N)     | Medium/S-- | Sequence                   |         |
| 256.paint-house                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/256.paint-house.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/256.paint-house.py) | O(N)       | O(N)     | Easy/S--   | Sequence                   |         |
| 265.paint-house-ii                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/265.paint-house-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/265.paint-house-ii.py) | O(M * N)   | O(M * N) | Hard       | Sequence                   |         |
| 279.perfect-squares                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/279.perfect-squares.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/279.perfect-squares.py) | O(N ^ 1.5) | O(N)     | Medium     | Partition                  |         |
| 300.longest-increasing-subsequence      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/300.longest-increasing-subsequence.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/300.longest-increasing-subsequence.py) | O(N*logN)  | O(N)     | Medium/SSS | Binary-search / DP         | Perfect |
| 312.burst-balloons                      | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/312.burst-balloons.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/312.burst-balloons.py) | O(N^3)     | O(N^2)   | Hard/S--   | Range                      |         |
| 322.coin-change                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/322.coin-change.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/322.coin-change.py) | O(L*N)     | O(N)     | Medium     | N = amount, L = len(coins) |         |
| 338.counting-bits                       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/338.counting-bits.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/338.counting-bits.py) | O(N)       | O(1)     | Medium/S-- | Bit-manipulation           |         |
| 354.russian-doll-envelopes              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/354.russian-doll-envelopes.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/354.russian-doll-envelopes.py) | O(N*logN)  | O(N)     | Hard/S--   | Coordinates                |         |
| $361.bomb-enemy                         | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/361.bomb-enemy.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/361.bomb-enemy.py) | O(M * N)   | O(M * N) | Medium/S++ | Coordinates                |         |
| 377.combination-sum-iv                  | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/377.combination-sum-iv.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/377.combination-sum-iv.py) | O(M*N)     | O(N)     | Medium     | backpack-vi(Lintcode)      |         |
| 474.ones-and-zeroes                     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/474.ones-and-zeroes.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/474.ones-and-zeroes.py) | O(LMN)     | O(LMN)   | Medium     | Sequence                   |         |
| 516.longest-palindromic-subsequence     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/516.longest-palindromic-subsequence.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/516.longest-palindromic-subsequence.py) | O(N^2)     | O(N^2)   | Medium     |                            |         |

### Greedy

| Problem                                | Solution                                                     | Time   | Space | Difficulty | Tag                 | Note |
| -------------------------------------- | ------------------------------------------------------------ | ------ | ----- | ---------- | ------------------- | ---- |
| 45.jump-game-ii                        | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/45.jump-game-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/45.jump-game-ii.py) | O(N)   | O(1)  | Hard       |                     |      |
| 055.jump-game                          | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/55.jump-game.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/55.jump-game.py) | O(N)   | O(1)  | Medium     | dynamic-programming |      |
| 122.best-time-to-buy-and-sell-stock-ii | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/122.best-time-to-buy-and-sell-stock-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/122.best-time-to-buy-and-sell-stock-ii.py) | O(N)   | O(1)  | Easy       |                     |      |
| $406.queue-reconstruction-by-height    | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/406.queue-reconstruction-by-height.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/406.queue-reconstruction-by-height.py) | O(N^2) | O(1)  | Medium/S++ | Sort Multiple Keys  |      |

### Union Find

| Problem                  | Solution                                                     | Time     | Space    | Difficulty | Tag     | Note               |
| ------------------------ | ------------------------------------------------------------ | -------- | -------- | ---------- | ------- | ------------------ |
| 261.graph-valid-tree     | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/261.graph-valid-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/261.graph-valid-tree.py) | O(N)     | O(N)     | Medium     | BFS/DFS |                    |
| 305.number-of-islands-ii | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/305.number-of-islands-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/305.number-of-islands-ii.py) | O(N)     | O(M * N) | Hard       |         | N = len(positions) |
| 721.accounts-merge       | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/721.accounts-merge.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/721.accounts-merge.py) | O(M * N) | O(M * N) | Medium     |         |                    |

### Trie

| Problem                                       | Solution                                                     | Time                     | Space                   | Difficulty | Tag         | Note                                           |
| --------------------------------------------- | ------------------------------------------------------------ | ------------------------ | ----------------------- | ---------- | ----------- | ---------------------------------------------- |
| 208.implement-trie-prefix-tree                | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/208.implement-trie-prefix-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/208.implement-trie-prefix-tree.py) | O(L)                     | O(N * L)                | Medium     | -           | L = len(word), N = number of words             |
| 211.add-and-search-word-data-structure-design | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/211.add-and-search-word-data-structure-design.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/211.add-and-search-word-data-structure-design.py) | add = O(L), find >= O(L) | O(N * L)                | Medium/S-- | DFS         | L = len(word), N = count(words)                |
| 212.word-search-ii                            | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/212.word-search-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/212.word-search-ii.py) | O(M * N * L * L)         | MAX(O(M * N), O(K * L)) | Hard       | DFS         | K = number of words, L = avg length of words   |
| 425.word-squares                              | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/425.word-squares.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/425.word-squares.py) | O(2^N)                   | O(NL)                   | Hard/SSS   | DFS Pruning |                                                |
| 677.map-sum-pairs                             | [cpp](https://github.com/geemaple/algorithm/blob/master/leetcode/677.map-sum-pairs.cpp), [python](https://github.com/geemaple/algorithm/blob/master/leetcode/677.map-sum-pairs.py) | O(L), O(KL)              | O(N * L)                | Medium     |             | L = length of input, k = number of items found |

### Other

| Problem                | Solution                                                     | Difficulty | Tag  | Note |
| ---------------------- | ------------------------------------------------------------ | ---------- | ---- | ---- |
| 175.combine-two-tables | [sql](https://github.com/geemaple/algorithm/blob/master/leetcode/175.combine-two-tables.sql) | Easy       | SQL  |      |

## 四、Lintcode

| Problem                                   | Solution                                                     | Time                     | Space   | Difficulty    | Tag                                 | Note          |
| ----------------------------------------- | ------------------------------------------------------------ | ------------------------ | ------- | ------------- | ----------------------------------- | ------------- |
| 077.longest-common-subsequence            | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/77.longest-common-subsequence.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/77.longest-common-subsequence.py) | O(M*N)                   | O(M*N)  | Medium        | dynamic-programming                 |               |
| 081.find-median-from-data-stream          | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/81.find-median-from-data-stream.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/81.find-median-from-data-stream.py) | O(N * LogN)              | O(N)    | Hard          | Heap                                |               |
| 089.k-sum                                 | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/89.k-sum.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/89.k-sum.py) | O(NKT)                   | O(NKT)  | Hard          | dynamic-programming                 |               |
| 91.minimum-adjustment-cost                | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/91.minimum-adjustment-cost.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/91.minimum-adjustment-cost.py) | O((100^2)N)              | O(100N) | Medium        | dynamic-programming                 |               |
| 092.backpack                              | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/92.backpack.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/92.backpack.py) | O(M*N)                   | O(M)    | Medium        | dynamic-programming                 |               |
| 125.backpack-ii                           | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/125.backpack-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/125.backpack-ii.py) | O(M*N)                   | O(M)    | Medium/S++    | dynamic-programming                 |               |
| 183.wood-cut                              | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/183.wood-cut.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/183.wood-cut.py) | O(N * LogN)              | O(1)    | Medium/S--    | binary-search                       |               |
| 394.coins-in-a-line                       | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/394.coins-in-a-line.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/394.coins-in-a-line.py) | O(N)                     | O(N)    | Medium        | dynamic-programming                 |               |
| 396.coins-in-a-line-iii                   | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/396.coins-in-a-line-iii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/396.coins-in-a-line-iii.py) | O(N^2)                   | O(N^2)  | Hard/SSS      | dynamic-programming                 |               |
| 437.copy-books                            | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/437.copy-books.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/437.copy-books.py) | O(K * N^2) / O(N * LogA) | O(NK)   | Hard/SSS      | dynamic-programming / binary-search |               |
| 440.backpack-iii                          | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/440.backpack-iii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/440.backpack-iii.py) | O(M * N)                 | O(M)    | Hard/SSS      | dynamic-programming                 |               |
| 447.search-in-a-big-sorted-array          | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/447.search-in-a-big-sorted-array.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/447.search-in-a-big-sorted-array.py) | O(LogK)                  | O(1)    | binary-search | Medium/S++                          |               |
| 465.kth-smallest-sum-in-two-sorted-arrays | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/465.kth-smallest-sum-in-two-sorted-arrays.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/465.kth-smallest-sum-in-two-sorted-arrays.py) | O((K + N) * LogN)        | O(N)    | Hard          | heap                                | N = B.size()  |
| 543.kth-largest-in-n-arrays               | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/543.kth-largest-in-n-arrays.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/543.kth-largest-in-n-arrays.py) | O(M * N * LogK)          | O(K)    | Easy          | heap                                |               |
| 526.load-balancer                         | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/526.load-balancer.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/526.load-balancer.py) | O(1)                     | O(N)    | Medium        | Hash + Array                        |               |
| 563.backpack-v                            | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/563.backpack-v.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/563.backpack-v.py) | O(M*N)                   | O(M)    | Medium        | dynamic-programming                 |               |
| 589.connecting-graph                      | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/589.connecting-graph.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/589.connecting-graph.py) | O(1)                     | O(N)    | Medium        | union-find                          |               |
| 590.connecting-graph-ii                   | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/590.connecting-graph-ii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/590.connecting-graph-ii.py) | O(1)                     | O(N)    | Medium        | union-find                          |               |
| 591.connecting-graph-iii                  | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/591.connecting-graph-iii.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/591.connecting-graph-iii.py) | O(1)                     | O(N)    | Medium        | union-find                          |               |
| 629.minimum-spanning-tree                 | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/629.minimum-spanning-tree.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/629.minimum-spanning-tree.py) | O(N * logN)              | O(N)    | Hard          | union-find                          | Prim, Kruskal |
| 652.factorization                         | [cpp](https://github.com/geemaple/algorithm/blob/master/lintcode/652.factorization.cpp), [python](https://github.com/geemaple/algorithm/blob/master/lintcode/652.factorization.py) | O(N)                     | O(LogN) | Medium/S++    | N = input number                    |               |

 

## 五、参考资料&致谢

- [LeetCode 题目总结/分类](https://www.douban.com/note/330562764/)
- [Algorithm](https://github.com/geemaple/algorithm)
- 《剑指 offer》
- 《程序员代码面试指南》
- linCode