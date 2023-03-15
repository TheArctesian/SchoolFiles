#include <stdio.h>

int function1(int n) {
    if (n == 0){
        return 0;
    }
    else{
        return 1 + function1(n -1);
    }
}

int function2(int n){
    if (n == 0) {
        return 0;
    }
    else {
        return n + function2(n -1);
    }
}

int whoKnows(int n){
    if (n == 0 || n == 1){
        return 0;
    }
    else {
        printf("%i\n", n);
        return n + whoKnows(n-1) + whoKnows(n-2);
    }
}

int crazy(int a, int b){
    if (a < b){
        return a;
    }
    else{
        return b + crazy(a-1,b+1);
    }
}

int doesWhat(int n){
    if(n <= 1){
        return 1;
    } else if (n % 2 == 0) { 
        return n - doesWhat(n-1);
    } else {
        return n + doesWhat(n-1);
    }
}
int main(){
//    int i = (function1(6));
//    int i = function2(6);
//    int i = whoKnows(6);
//    int i = crazy(4,2);
    int i = doesWhat(7);
    printf("%i\n", i);
    return 0 ;
}
