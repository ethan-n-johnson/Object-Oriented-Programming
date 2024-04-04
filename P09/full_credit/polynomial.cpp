#include <iostream>
#include <vector>
#include "polynomial.h"

class Polynomial{
    public:
        Polynomial(std::vector<double> coefficients)
            :_coefficients(coefficients) {}
        virtual ~Polynomial() {}
        virtual std::vector<double> solve() = 0;
    private:
        std::vector<double> _coefficients;
};