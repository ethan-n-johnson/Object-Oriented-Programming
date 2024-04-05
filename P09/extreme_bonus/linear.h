#ifndef LINEAR_H
#define LINEAR_H

#include "polynomial.h"

class Linear : public Polynomial{
    public:
        Linear(std::vector<double> coefficients);
        virtual ~Linear();
        std::vector<std::complex<double>> solve() override;
};

#endif