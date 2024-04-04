#include <iostream>
#include "quadratic.h"

class Quadratic{
    public:
        Quadratic(double coefficients)
            :_coefficients(coefficients) {}
        virtual ~Quadratic();
    private:
        double _coefficients; //vector
};