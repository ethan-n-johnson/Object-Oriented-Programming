#include <iostream>
#ifndef UNIVERSITY_H
#define UNIVERSITY_H
class University
{
private:
    std::string _name;
    int _enrollment;
    void validate();
public:
    University(std::string name = "", int enrollment = 0)
    : _name(name), _enrollment(enrollment){}
    ~University();
    std::string name() const;
    int enrollment() const;
    friend std::istream& operator>>(std::istream& ist, University& reading){
        ist >> reading._name >> reading._enrollment;
        reading.validate();
        return ist;
    }
    friend std::ostream& operator<<(std::ostream& ost, const University& reading){
        ost << reading._name << " has an enrollemnt of " << reading._enrollment;
        return ost;
    }
};
#endif