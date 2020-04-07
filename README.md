# SegmentTree
It is used in range query

Array is used to store tree

Array of size 2*n is ok for all type of input array size so it is independent on size of array

As Tree is start from index 1 

              left child = 2*i
              right child= 2*i+1
              parent     = i/2
              
Complexity of Segment Tree              

              Space Complexity to create a tree = 0(n)
              Time Complexity to create a tree  = 0(n)
              Time Complexity to searh element  = 0(logn)
              Time Complexity to query          = 0(logn)
              Time Complexity to update         = 0(logn)
              
(l&1) = as right child of left tree is always odd & if its true then that means it is part of solution not its parent

(r&1) = as right child of right tree is always odd & if its true then that means it is not an part of solution so its left neighbour.
