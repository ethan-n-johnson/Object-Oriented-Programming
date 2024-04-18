#include "university.h"

University::~University(){}
void University::validate(){
    if(_enrollment < 0) throw new std::invalid_argument("University enrollment cannot be negative");
    if(_enrollment > 0 && _name.length() == 0) throw new std::invalid_argument("University cannot be anonymous");
}