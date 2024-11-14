---
title: Trees and tree traversal
summary: |
  In this reading, you will explore the basics of trees and how we might
  visit or process all of the elements in a tree.
---
Introduction
------------

As you may have noted, there are a variety of ways we think about lists.

* A list is an ordered linear collection of values in which the client
  controls the ordering of the elements.
* A list is a collection we build and iterate with a `ListIterator` objects.
* A list is a collection in which each element (except the first) has exactly 
  one predecessor and each element (except the last) has exactly one successor.

The _tree_ ADT expands lists by changing the policy on successors.
In a tree, there is a designated value, called the _root_, that
serves the same role as the first element in a list.  That is, the
_root_ has no predecessors.  Every other element in a tree has
exactly one predecessor.  (For a variety of reasons, we typically
call the predecessor of an element its "_parent_".)

In contast to lists, in which each value (other than the last element) has exactly one successor, in trees, each value can have an arbitrary number of successors: one, two, three, even one hundred.  Some elements have no successors.  We call those "_leaves_".  In a tree with one value, the root is also the only leaf.  Since we call a value's predecessor its "parent", we refer to a value's immediate successors as "_children_".  (The root/leaf terminology coexists strangely with the family terminology.) The family metaphor continues with other terms. We refer to the children of one parent as "_siblings_", to the children of children (and the children of children of ...) as "_descdendants_", to the parents of parents (and the parents of parents of ...) as "_ancestors_", and so on and so forth.

For much of this course, we will focus primarily on "_binary trees_", trees in which each value has zero, one, or two children.  We name the children the "_left child_" and the "_right child".

### A sample tree

For example, consider the following ASCII illustration of a tree.

```
     a
   /   \
  b     c
 / \   / 
d   e f  
   / \ \
  g   h i
```

`a` is the root of the tree.  It has two children.  Its left child is `b`
and its right child is `c`.

`b` also has two children, `d` and `e`. 

In contrast, `c` has only one child, `f`, which is a left child.  `f` also has only one child, `i`, which is a right child.

The tree has four leaves: `d`, `g`, `h`, and `i`.

### Other terminology

We use the term _size_ to mean "the number of values in a tree".

We use the terms _descendant_ and _ancestor_ as generalizations of _child_ and _parent_.  In our example above, `a` is an ancestor of `h` and `i` is a descendent of `i`.

We often use the term _depth_ when associated with a value to indicate how far it is from a value to the root.  For example, `a` is has a depth of 0; `b` and `c` have a depth of 1; `d`, `e`, and `f` have a depth of 2; and `g`, `h`, and `i` have a depth of 3.  We might also use the term _level_ for all the values at a particular depth.

We use the term _height_ to mean "the number of levels" in a tree.

Traversing trees
----------------

Just as we iterate the elements of a list, so may we want to traverse all of the elements in a tree. Sometimes, we traverse a tree just to print it out. Sometimes we traverse a tree to look for a particular value. Sometimes we traverse a tree to compute a value based on the tree.

What values might we compute from a tree? We might simply compute the size of the tree, or the depth of the tree, or the number of times a value appears in the tree.

Options in traversing trees
---------------------------

At first glance, traversing trees seems straightforward: You simply visit each node in the tree, processing the node as you go. But behind the obvious “process each node” strategy, there are a wide variety of options.

Most nodes have more than one child. Do you process the children in order from left to right, right to left, or do you leave the order unspecified? The client of your traversal algorithm will want to know (and may even want to choose).

When we think recursively, we think about processing all of one subtree before processing the next subtree. That means we traverse down to a leaf in one subtree before we look at even the topmost node in the other subtree. However, there are times that it makes sense to process all of the nodes at one level before going on to the next level. An algorithm that goes across each level, one at a time, is called a breadth-first algorithm. A traversal algorithm that goes deep into one subtree before processing the next subtree is called a depth-first algorithm. Once again, a client may want to know which approach you will use or choose which approach you will use.

We usually have to visit a node before we visit its children - after all, in many implementations we get the information on the children from the node. However, we can choose different orders in which to process nodes. Two general approaches are preorder, in which we process a node before processing its children and postorder, in which we process a node after processing its children. Preorder processing is also called top-down and postorder processing is also called bottom-up. For binary trees with a depth-first approach, it is also possible to support inorder processing - process the left subtree, process the node, then process the right subtree.

So, when we write algorithms that process trees, we have three decisions to make:

* left-to-right or right-to-left;
* breadth-first or depth-first; and
* preorder, postorder, or (if appropriate), inorder.

That gives about ten different orders. Why ten and not twelve? Because inorder breadth-first traversal doesn't make a lot of sense, given that children are on different levels.

An example
----------

Do these different approaches visit nodes in different orders? Certainly. Let's look at a simple _binary search tree_ or BST.  In a BST, everything to the left of a value is less than the value and everything to the right of the value is greater than the value.

```
     e
   /   \
  c     h
 / \   / \
a   d f   j
```

Before you read on, make a note to yourself how you'd visit the tree in each of the orders given above.

Ready? Fill in the following table.


| Policy | Order Elements are Processed |
| ------ | ---------------------------- |
| Depth first, Preorder, Left to right | |
| Depth first, Preorder, Right to left | |
| Depth first, Postorder, Left to right | |
| Depth first, Postorder, Right to left | |
| Depth first, Inorder, Left to right | |
| Depth first, Inorder, Right to left | |
| Breadth first, Preorder, Left to right | |
| Breadth first, Preorder, Right to left | |
| Breadth first, Postorder, Left to right | |
| Breadth first, Postorder, Right to left | |

Are you done? Here's what we get.

| Policy | Order Elements are Processed |
| ------ | ---------------------------- |
| Depth first, Preorder, Left to right	| e c a d h f j |
| Depth first, Preorder, Right to left	| e h j f c d a |
| Depth first, Postorder, Left to right	| a d c f j h e |
| Depth first, Postorder, Right to left	| j f h d a c e |
| Depth first, Inorder, Left to right	| a c d e f h j |
| Depth first, Inorder, Right to left	| j h f e d c a |
| Breadth first, Preorder, Left to right	| e c h a d f j |
| Breadth first, Preorder, Right to left	| e h c j f d a |
| Breadth first, Postorder, Left to right	| a d f j c h e |
| Breadth first, Postorder, Right to left	| j f d a h c e |

Wasn't that fun? Surprisingly, there are use cases for each of the traversal orders (or at least most of them).

Evaluating trees, revisited: Arithmetic expressions
---------------------------------------------------

We indicated that there are some times that it's useful to use trees to compute a value. Here's one of the most common: Computer scientists often use trees to represent arithmetic expressions. For example, consider the following might represent the expression $(3+4)*(-(5+6))$.

```
      *
     / \
    /   \
   +    -
  / \   |
 /   \  |
3     4 +
       / \
      /   \
     5     6
```

To evaluate this tree, we need to evaluate both subtrees and then combine them using the operation. So we evaluate the $3+4$ subtree and the $-(5+6)$ and multiply them together.

