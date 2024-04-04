#ifndef QUADRATIC_H
#define QUADRATIC_H

#include "polynomial.h"

class Quadratic : public Polynomial{
    public:
        Quadratic(std::vector<double> coefficients);
        virtual ~Quadratic();
        std::vector<double> solve() override;
    private:
        std::vector<double> _coefficients; //vector
};

#endif