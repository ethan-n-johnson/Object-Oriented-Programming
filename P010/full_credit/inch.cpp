#include <inch.h>

Inch::Inch(int whole, int numerator, int denominator)
        : _whole(whole), _numerator(numerator), _denominator(denominator){}
Inch::Inch(){}
int Inch::compare(const Inch& rhs){}
void Inch::validate(){}