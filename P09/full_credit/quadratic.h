#include <iostream>
#include <vector>
#include <stdexcept>
#include "linear.h"
#include "polynomial.h"

class Quadratic : public Polynomial{
    public:
        Quadratic(std::vector<double> coefficients);
        virtual ~Quadratic();
        std::vector<double> solve();
    private:
        std::vector<double> _coefficients; //vector
};