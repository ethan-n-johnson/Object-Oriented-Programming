#include <iostream>
#include <vector>
#include <stdexcept>
#include "linear.h"
#include "polynomial.h"

class Linear : public Polynomial{
    public:
        Linear(std::vector<double> coefficients)
            :Polynomial(coefficients), _coefficients(coefficients) {
                if(_coefficients.size() != 2 || _coefficients[0] == 0){
                    throw std::runtime_error("a may not be 0");
                }
            }
        virtual ~Linear() {}
        std::vector<double> solve(){
            std::vector<double> answer;
            double a = _coefficients[0];
            double b = _coefficients[1];
            answer[0] = -b/a;
            return answer;
        }
    private:
        std::vector<double> _coefficients; //vector
};