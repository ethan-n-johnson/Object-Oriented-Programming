#include <iostream>
#include <vector>
#include "polynomial.h"

class Linear : public Polynomial{
    public:
        Linear(std::vector<double> coefficients);
        virtual ~Linear();
        std::vector<double> solve();
    private:
        std::vector<double> _coefficients; //vector
};