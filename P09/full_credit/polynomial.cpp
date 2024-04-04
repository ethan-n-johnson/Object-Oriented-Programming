#include <iostream>
#include "polynomial.h"

class Polynomial{
    public:
        Polynomial(double coefficients)
            :_coefficients(coefficients) {}
    private:
        double _coefficients; //vector
};