#include "inch.h"

int main(int argc, char const *argv[])
{
    Inch in;
    Inch last_in;
    Inch sum;
    while (std::cin.good())
    {
        std::cout << "Enter one or more measurements (in inches): ";
        std::cin >> in;
        sum = sum + in;
        std::cout << in << std::endl; 
        if (in == last_in) std::cout << "Same length as last time!" << std::endl; 
        if (in != last_in) std::cout << "NOT the same length as last time." << std::endl; 
        if (in < last_in) std::cout << "Bigger than last time." << std::endl; 
        if (in > last_in) std::cout << "Smaller than last time." << std::endl; 
        if (in <= last_in) std::cout << "Bigger or same length as last time." << std::endl; 
        if (in >= last_in) std::cout << "smaller or same length as last time." << std::endl; 
        std::cout << sum << std::endl;
        last_in = in;
    }
    
    return 0;
}
