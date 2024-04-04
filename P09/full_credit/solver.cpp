#include <iostream>
#include "polynomial.h"
#include "quadratic.h"
#include "linear.h"

int main(int argc, char* argv[]){
    Polynomial *p = NULL; 
    if(argc == 3){
        p = new Linear();
    }
    if(argc == 4){}
}