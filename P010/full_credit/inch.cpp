#include <inch.h>

Inch::Inch(int whole, int numerator, int denominator)
        : _whole(whole), _numerator(numerator), _denominator(denominator){}
Inch::Inch() : Inch(0,0,2){}
int const Inch::compare(const Inch& rhs){}
void Inch::validate(){}
inline bool Inch::operator+(const Inch& rhs){}
bool Inch::operator==(const Inch& rhs){return(compare(rhs) == 0);}
bool Inch::operator!=(const Inch& rhs){return(compare(rhs) != 0);}
bool Inch::operator<(const Inch& rhs){return(compare(rhs) < 0);}
bool Inch::operator<=(const Inch& rhs){return(compare(rhs) <= 0);}
bool Inch::operator>(const Inch& rhs){return(compare(rhs) > 0);}
bool Inch::operator>=(const Inch& rhs){return(compare(rhs) >= 0);}
std::ostream& Inch::operator<<(std::ostream& ost, Inch& inch){}
std::ostream& Inch::operator>>(std::ostream& ost, const Inch& inch){}