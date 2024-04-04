#include <stdexcept>
#include <cmath>
#include "polynomial.h"

class Quadratic : public Polynomial{
    public:
        Quadratic(std::vector<double> coefficients)
            :Polynomial(coefficients), _coefficients(coefficients){
                if(_coefficients.size() != 3 || _coefficients[0] == 0){
                    throw std::runtime_error("a may not be 0");
                }
            }
        virtual ~Quadratic();
        std::vector<double> solve(){
            std::vector<double> answer;
            double a = _coefficients[0];
            double b = _coefficients[1];
            double c = _coefficients[2];
            double inSqrt = (b*b)-(4*a*c);
            if (inSqrt < 0)
            {
                throw std::runtime_error("No real roots!");
            }
            answer[0] = (-b+std::sqrt(inSqrt))/(2*a);
            answer[1] = (-b-std::sqrt(inSqrt))/(2*a);
            return answer;
        }
    private:
        std::vector<double> _coefficients; //vector
};