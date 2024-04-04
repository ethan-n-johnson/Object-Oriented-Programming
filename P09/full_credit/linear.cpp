#include <iostream>
#include "linear.h"

class Linear{
    public:
        Linear(double coefficients)
            :_coefficients(coefficients) {}
    private:
        double _coefficients; //vector
};