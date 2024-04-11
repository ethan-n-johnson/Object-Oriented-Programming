#ifndef INCH_H
#define INCH_H
#include <iostream>
#include <ostream>
#include <istream>

class Inch{
    public:
        Inch(int whole, int numerator, int denominator);
        virtual ~Inch();
        Inch();
        inline bool operator+(const Inch& rhs);
        inline bool operator==(const Inch& rhs);
        inline bool operator!=(const Inch& rhs);
        inline bool operator<(const Inch& rhs);
        inline bool operator<=(const Inch& rhs);
        inline bool operator>(const Inch& rhs);
        inline bool operator>=(const Inch& rhs);
        std::ostream&  operator<<(std::ostream& ost, Inch& inch);
        std::istream& operator>>(std::istream& ist, const Inch& inch);
    private:
        int _whole;
        int _numerator;
        int _denominator;
        int const compare(const Inch& rhs);
        void validate();
};

#endif