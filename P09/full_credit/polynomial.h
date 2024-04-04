#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

#include <iostream>
#include <vector>

class Polynomial{
    public:
        Polynomial(std::vector<double> coefficients);
        virtual ~Polynomial();
        virtual std::vector<double> solve() = 0;
    private:
        std::vector<double> _coefficients;
};

#endif