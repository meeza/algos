# GunProblem
-------------------
Suppose there are n prisoners standing in a circle. There is a gun given to the first person. The person with the gun passes it on to k'th guy (in clockwise order, excluding him) who kills the person before him. After killing, the process continues until only one person survives.

Assuming a linked list of prisoners (in clockwise order) and parameter k, return the Node pointer of survivor.


Input: 1 2 3 4 5
<br>
k = 4
<br>
1 2 3 5
<br>
1 2 5
<br>
1 2
<br>
1

k = 3<br>
1 2 4 5<br>
2 4 5<br>
2 4<br>
4<br>

k = 2<br>
1 3 4 5 <br>
1 3 5<br>
3 5<br>
3<br>

k = 1<br>
2 3 4 5<br>
3 4 5<br>
4 5<br>
5<br>

k = 0<br>
1 2 3 4<br>
1 2 3<br>
1 2<br>
1<br>
