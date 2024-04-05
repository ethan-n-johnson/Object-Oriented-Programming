#include "quadratic.h"
#include "linear.h"

int main(int argc, char* argv[]){
    std::vector<double> coefficients;
    Polynomial *p = nullptr; 

    if(argc == 3){
        coefficients = {std::stod(argv[1]), std::stod(argv[2])}; 
        p = new Linear(coefficients);
    }
    else if(argc == 4){
        coefficients = {std::stod(argv[1]), std::stod(argv[2]), std::stod(argv[3])}; 
        p = new Quadratic(coefficients);
    }
    else{
        std::cerr << "Inavlid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }
    try{
        std::vector<double> roots = p->solve();
        delete p;
        std::cout << "Root(s) are ";
        for(auto r: roots) std::cout << r << " ";
        std::cout << std::endl;
    } catch (const std::runtime_error& e) {
        std::cerr << "Runtime error: " << e.what() << std::endl;
        delete p;
        return -1;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range: " << e.what() << std::endl;
        delete p;
        return -2;
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        delete p;
        return -4;
    }
}