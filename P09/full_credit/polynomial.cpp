#include "polynomial.h"
#include <iostream>
#include <vector>

class Polynomial{
    public:
        Polynomial(std::vector<double> coefficients)
            :_coefficients(coefficients) {}
    private:
        std::vector<double> _coefficients;
};