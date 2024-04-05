#include "quadratic.h"
#include "linear.h"

int main(int argc, char* argv[]){
    std::vector<double> coefficients;
    std::string usage = "Usage: ";
    usage += argv[0];
    usage += " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0";
    Polynomial *p = nullptr; 
    if (argc == 2 && std::string(argv[1]) == "-h")
    {
        std::cerr << "Usage: " << argv[0] << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
        return 0;
    }
    
    if(argc == 3){
        try {
            coefficients = {std::stod(argv[1]), std::stod(argv[2])}; 
            p = new Linear(coefficients);
        } catch (const std::invalid_argument& e) {
            std::cerr << "Invalid argument: All coefficients must be double" << std::endl;
            std::cerr << "Usage: " << argv[0] << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
            return -3;
        } catch (const std::exception& e) {
            std::cerr << "Runtime error: " << e.what() << std::endl;
            std::cerr << "Usage: " << argv[0] << " [-h] a b [c] for ax+b=0 or ax^2+bx+c=0" << std::endl;
            return -3;
        }
    }
    else if(argc == 4){
        try {
            coefficients = {std::stod(argv[1]), std::stod(argv[2]), std::stod(argv[3])}; 
            p = new Quadratic(coefficients);
        } catch (const std::invalid_argument& e) {
            std::cerr << "Invalid argument: All coefficients must be double" << std::endl;
            std::cerr << usage << std::endl;
            return -3;
        } catch (const std::exception& e) {
            std::cerr << "Runtime error: " << e.what() << std::endl;
            std::cerr << usage << std::endl;
            return -3;
        }
    }
    else if(argc != 4 && argc != 3 && argc > 0){
        std::cerr << "Runtime error: Invalid polynomial size - must be linear or quadratic" << std::endl;
        std::cerr << usage << std::endl;
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
        std::cerr << usage << std::endl;
        delete p;
        return -1;
    } catch (const std::out_of_range& e) {
        std::cerr << "Out of range: " << e.what() << std::endl;
        std::cerr << usage << std::endl;
        delete p;
        return -2;
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        std::cerr << usage << std::endl;
        delete p;
        return -4;
    }
}