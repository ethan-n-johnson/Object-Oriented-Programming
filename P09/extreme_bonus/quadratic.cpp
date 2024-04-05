#include <stdexcept>
#include <cmath>
#include "quadratic.h"

Quadratic::Quadratic(std::vector<double> coefficients)
    :Polynomial(coefficients){
        if(_coefficients.size() != 3 || _coefficients[0] == 0){
            throw std::runtime_error("a may not be 0");
            }
        }
Quadratic::~Quadratic() {}
std::vector<std::complex<double>> Quadratic::solve(){
        std::vector<std::complex<double>> answer(2);
        std::complex<double> a = _coefficients[0];
        std::complex<double> b = _coefficients[1];
        std::complex<double> c = _coefficients[2];
        std::complex<double> inSqrt = (b*b)-(4.0*a*c);
        answer[0] = (-b+std::sqrt(inSqrt))/(2.0*a);
        answer[1] = (-b-std::sqrt(inSqrt))/(2.0*a);
        return answer;
    }