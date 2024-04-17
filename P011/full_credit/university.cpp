#include "university.h"

void University::validate(){
    if(_enrollment < 0) throw new std::invalid_argument("University enrollment cannot be negative");
    if(_enrollment > 0) throw new std::invalid_argument("University cannot be anonymous");
}