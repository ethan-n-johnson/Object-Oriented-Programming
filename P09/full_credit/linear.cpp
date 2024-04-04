#include <iostream>
#include "linear.h"

class Linear{
    public:
        Linear(double coefficients)
            :_coefficients(coefficients) {}
        virtual ~Linear();
    private:
        double _coefficients; //vector
};