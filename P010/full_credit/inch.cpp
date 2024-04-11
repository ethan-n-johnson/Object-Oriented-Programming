#include <inch.h>
Inch::Inch(int whole, int numerator, int denominator)
    : _whole(whole), _numerator(numerator), _denominator(denominator){
        validate();
    }
Inch::Inch() : Inch(0,0,2){}
Inch::~Inch() {}
int const Inch::compare(const Inch& rhs){
    if (*this == rhs) return 0;
    if (*this < rhs) return -1;
    if (*this > rhs) return 1;
    if (*this == rhs) return 0;
    if (*this == rhs) return 0;
}
void Inch::validate(){
    if (_denominator == 2 || 4 || 8 || 16 || 32 || 64)
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
}
inline bool Inch::operator==(const Inch& rhs){return(compare(rhs) == 0);}
inline bool Inch::operator!=(const Inch& rhs){return(compare(rhs) != 0);}
inline bool Inch::operator<(const Inch& rhs){return(compare(rhs) < 0);}
inline bool Inch::operator<=(const Inch& rhs){return(compare(rhs) <= 0);}
inline bool Inch::operator>(const Inch& rhs){return(compare(rhs) > 0);}
inline bool Inch::operator>=(const Inch& rhs){return(compare(rhs) >= 0);}
std::ostream& Inch::operator<<(std::ostream& ost, Inch& inch){}
std::ostream& Inch::operator>>(std::ostream& ost, const Inch& inch){}