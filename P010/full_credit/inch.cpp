#include <inch.h>
Inch::Inch(int whole, int numerator, int denominator)
    : _whole(whole), _numerator(numerator), _denominator(denominator){
        validate();
    }
Inch::Inch() : Inch(0,0,2){}
Inch::~Inch() {}
int const Inch::compare(const Inch& rhs){
    double thisValue = static_cast<double>(_whole) + static_cast<double>(_numerator) / _denominator;
    double rhsValue = static_cast<double>(rhs._whole) + static_cast<double>(rhs._numerator) / rhs._denominator;
    if (thisValue < rhsValue) return -1;
    if (thisValue > rhsValue) return 1;
    return 0;
}
void Inch::validate(){
    if (_denominator == 2 || _denominator == 4 || _denominator == 8 || _denominator == 16 || _denominator == 32 || _denominator == 64)
    {
        while (_numerator >= _denominator)
        {
            _numerator -= _denominator;
            _whole++;
        }
        int gcd = std::gcd(_numerator, _denominator);
        _numerator = _numerator / gcd;
        _denominator = _denominator / gcd;
    }
    else{
        throw std::invalid_argument("Denominator must be 2, 4, 8, 16, 32, or 64");
    }
}
Inch Inch::operator+(const Inch& rhs){
    int new_numerator1 = rhs._numerator;
    int new_denominator1 = rhs._denominator;
    int new_whole1 = rhs._whole;
    int new_numerator2 = _numerator;
    int new_denominator2 = _denominator;
    int new_whole2 = _whole;
    while(new_denominator1 != 64){
        new_denominator1 = new_denominator1 * 2;
        new_numerator1 = new_numerator1 * 2;
    }
    new_whole1 = new_whole1*new_denominator1;
    while(new_denominator2 != 64){
        new_denominator2 = new_denominator2 * 2;
        new_numerator2 = new_numerator2 * 2;
    }
    new_whole2 = new_whole2*new_denominator2;
    int new_numerator = new_whole1+new_whole2+new_numerator1+new_numerator2;
    Inch newInch = Inch(0, new_numerator, 64);
    return newInch;
}
inline bool Inch::operator==(const Inch& rhs){return(compare(rhs) == 0);}
inline bool Inch::operator!=(const Inch& rhs){return(compare(rhs) != 0);}
inline bool Inch::operator<(const Inch& rhs){return(compare(rhs) < 0);}
inline bool Inch::operator<=(const Inch& rhs){return(compare(rhs) <= 0);}
inline bool Inch::operator>(const Inch& rhs){return(compare(rhs) > 0);}
inline bool Inch::operator>=(const Inch& rhs){return(compare(rhs) >= 0);}
std::ostream& Inch::operator<<(std::ostream& ost, Inch& inch){}
std::ostream& Inch::operator>>(std::ostream& ost, const Inch& inch){}