#include <stdio.h>
#include <stdlib.h>

int x = 5;

int main () {
  int y = 10;
  int* p = (int*) malloc (sizeof (int));
}


/* 

There are 4 library functions defined under <stdlib.h> makes dynamic memory 
allocation in C programming. They are malloc(), calloc(), realloc() and free().

The malloc() function reserves a block of memory of the specified number of bytes. 
And, it returns a pointer of type void which can be casted into pointer of any form.

The malloc() function allocates a single block of memory. Whereas, calloc() allocates 
multiple blocks of memory and initializes them to zero.

You must explicitly use free() to release the space.

If the dynamically allocated memory is insufficient or more than required, you can change 
the size of previously allocated memory using realloc() function

An activation record is another name for Stack Frame. It's the data structure that composes a call stack.

Where in memory is x allocated? Global memory 
Where in memory is y allocated? In an activation record for main (also known as stack frame) stored on the call stack.
Where in memory is p allocated? In an activation record for main (also known as stack frame) stored on the call stack.
Where in memory is p pointing to? On the heap.

*/

