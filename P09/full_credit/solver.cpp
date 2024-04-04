#include <iostream>
#include "polynomial.h"
#include "quadratic.h"
#include "linear.h"

int main(int argc, char* argv[]){
    std::vector<double> coefficients;
    Polynomial *p = NULL; 
    if(argc == 3){
        std::vector<double> coefficients = {std::stod(argv[1]), std::stod(argv[2])}; 
        p = new Linear(coefficients);
    }
    if(argc == 4){
        std::vector<double> coefficients = {std::stod(argv[1]), std::stod(argv[2]), std::stod(argv[3])}; 
        p = new Quadratic(coefficients);
    }
    else{
        std::cerr << "Inavlid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }
    std::vector<double> roots = p->solve();
    for(auto c: roots){
        std::cout << c << std::endl;
    }
}