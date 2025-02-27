---
title: Binary search trees, continued
repo: <https://github.com/Grinnell-CSC207/lab-bsts-maven>
summary: |
  We continue to explore binary search trees and their use in 
  implementing the Map ADT.
---
Preparation
-----------

If you have not done so already, do the normal preparation.  That is,
fork and clone the specified respository and input it into VSCode. Then
update the README and push.

Exercises
---------

### Exercise 1: Removing elements

_Driver: **B**_

Sketch how you might implement the `remove` method.  Spend no more than
five minutes on your sketch.  Be prepared to discuss it with your instructor
or class mentor.

### Exercise 2: Removing elements, revisited

_Driver: **B**_

Experience suggests that removing elements from the tree is most easily
accomplished recursively, using a strategy something like that used
in the recursive `set`.  Here's a sketch in pseudocode.

```text
remove(key)
  root = removeHelper(root, key);
  return cache;

removeHelper(node, key) 
  if node == null
    cache = null;
    return null;
  else
    cache = node.value;
    compare key to node.key
    case equal:
      if node is a leaf
        return null;
      else if node.left is null
        return node.right;
      else if node.right is null;
         return node.left;
      otherwise
        do something complicated
    case less:
      node.left = removeHelper(node.left, key);
    case greater:
      node.right = removeHelper(node.right, key);
    return node;
```

a. Implement this sketch, leaving the "do something complicated"
unimplemented.  (You'll still need to return the node; you might
print an error message to stderr to indicate that you reached that
state.)

b. Update the experiment to explore the four basic cases: Removing
a leaf, removing an entry with no left child, removing an entry
with no right child, and removing a node with both left and right
children.  (The last experiment should not succeed.)

c. Sketch how you might implement the complicated case, in which
the node to be removed has both a left and right subtree.  (Again,
spend no more than five minutes and be prepared to discuss it with
your instructor or class mentor.)

### Exercise 3: Removing elements, concluded

_Driver: **A**_

One inefficient approach that some people take is to reinsert all of
the values in the left and right subtrees into the tree.  But we should
be able to do better than that.

If you think about it for a moment, you'll realize that every key in
the right subtree is greater than every key in the left subtree.  We
can take advantage of that fact to handle removal.  In particular, we
can safely put the right subtree at the far right end of the left
subtree and then return the left subtree.  (Alternately, we can
safely put the left subtree at the far left end of the right subtree
and return the right subtree.)

We also know that the rightmost key in the left subtree is larger
than everything else in the left subtree and smaller than everything
else in the right subtree.  Hence, we could remove the rightmost
key/value pair from the left subtree and then make a new node
whose left subtree is the modified left subtree and whose right
subtree is the right subtree.

Implement and check one of those strategies.

### Exercise 4: More systematic experimentation

_Driver: **A**_

The following array of strings should allow you to build a balanced tree 
of fifteen elements.  (If it doesn't, reorganize it to do so.)

```java
    String[] balanced = {"horse", "dingo", "llama", "baboon", "fox", "jackal",
        "narwhal", "aardvark", "civet", "emu", "gazelle", "impala", "koala",
        "moose", "ocelot"};
```

a. What do you expect to happen if you remove values in the same order
that they were added?

b. Check your answer with an experiment.

c. What do you expect to happen if you remove values in the opposite order
that they were added?

d. Check your answer with an experiment.

e. What do you expect to happen if you remove values in alphabetical order?

f. Check your answer with an experiment.

g. Determine what happens if you remove values in random order.

For those with extra time
-------------------------

_If you find that you have extra time, try any of the following
problems._

### Extra 1: Setting values, revisited

In [the previous lab](../labs/binary-search-trees), you implemented
the `set` method either recursively or iteratively.  

a. Implement it in whichever way you did not implement it previously.
If you need a hint, there is pseudocode at the end of [the previous
lab](../labs/binary-search-trees).

b. Which implementation do you prefer?  Why?

### Extra 2: Iteration

As you may recall, the `nodes` method provides an iterator for the nodes
in a binary search tree.  We've chosen to have that iterator visit nodes
in a depth first order and to use a stack to help with that approach.
We initialize the stack with the root.

Here's a sketch of the `next` method.

* Pop the node at the top of the stack.
* If the right child is not null, push the right child.
* If the left child is not null, push the left child.
* Return the node.

a. If you have not already done so, implement this strategy.

b. Be ready to explain why this works.

c. This visits the nodes using a preorder, left-to-right, depth-first
   strategy.  Sketch how you might do inorder or postorder.

### Extra 3: Breadth-first iteration

Revise `nodes` so that it iterates values in a breadth-first
rather than depth-first order.  

You may find it helpful to incorporate [our simple implementation
of queues](../files/SimpleQueue.java).

### Extra 4: Rebalancing trees

As you may have discovered, we can sometimes end up with quite
imbalanced binary search trees.  Sketch a mechanism for 
rebalancing the trees. (It's fine if you have difficulty coming
up with one; rebalancing is difficult. You'll learn more about
it in CSC-207.)
