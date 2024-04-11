#ifndef INCH_H
#define INCH_H
#include <iostream>

class Inch{
    public:
        Inch(int whole, int numerator, int denominator);
        Inch();
    private:
        int _whole;
        int _numerator;
        int _denominator;
        int compare(const Inch& rhs);
        void validate();
};

#endif