#include <stdexcept>
#include "linear.h"

Linear::Linear(std::vector<double> coefficients)
    :Polynomial(coefficients){
        if(_coefficients.size() != 2 || _coefficients[0] == 0){
                throw std::runtime_error("a may not be 0");
            }
        }
Linear::~Linear() {}
std::vector<std::complex<double>> Linear::solve(){
    std::vector<std::complex<double>> answer(1);
    double a = _coefficients[0];
    double b = _coefficients[1];
    answer[0] = -b/a;
    return answer;
}