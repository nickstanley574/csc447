#include <stdio.h>

// Solution: CBV in C  CALL-BY-VALUE (CBV)

// 1 CBV in C - Int
// Confirm that C uses call-by-value to pass int variables by
// writing a simple C program then running it.
void swapInt(int x, int y) {
    printf("--> swapInt(x=%d, y=%d)\n", x, y);
    int oldX = x; 
    int oldY = y;
    x = oldY;
    y = oldX;
    printf("--> x=%d, y=%d\n", x, y);

}

// 2 CBV in C - Pointer
// Confirm that C uses call-by-value to pass pointer variables by 
// writing a simple C program then running it.
void swapPointer(int *x, int *y) {
    printf("--> swapPointer(*x=%d, *y=%d)\n", *x, *y);
    int* oldX = x;
    int* oldY = y;
    x = oldY;
    y = oldX;
    printf("--> *x=%d, *y=%d\n", *x, *y);

}

int main() {
    printf("main()\n");

    // 1
    {
        printf("--1--\n");
        int a = 0;
        int b = 1; 
        printf("a=%d, b=%d\n", a, b);
        swapInt(a, b);
        printf("a=%d, b=%d\n", a, b);
    }

    // 2
    { 
        printf("--2--\n");
        int a = 0; int *p = &a;
        int b = 1; int *q = &b;   
        printf ("*p = %d, *q = %d\n", *p, *q);
        swapPointer (p, q);
        printf ("*p = %d, *q = %d\n", *p, *q); 
    }
}