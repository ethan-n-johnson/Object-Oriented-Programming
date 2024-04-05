#ifndef QUADRATIC_H
#define QUADRATIC_H

#include "polynomial.h"

class Quadratic : public Polynomial{
    public:
        Quadratic(std::vector<double> coefficients);
        virtual ~Quadratic();
        std::vector<std::complex<double>> solve() override;
};

#endif