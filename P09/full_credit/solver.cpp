#include <iostream>
#include "polynomial.h"
#include "quadratic.h"
#include "linear.h"

int main(int argc, std::vector<double> argv){
    Polynomial *p = NULL; 
    if(argc == 3) p = new Linear(argv);
    if(argc == 4) p = new Quadratic(argv);
    else{
        std::cerr << "Inavlid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }
    p->solve();
    int i = 0;
    for(auto c: p){
        p[i].solve();
        i++;
    }
}