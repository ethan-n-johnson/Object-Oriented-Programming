#include "inch.h"
#include <fstream>

int main(int argc, char const *argv[])
{
    std::ofstream ofs;
    std::ifstream ifs;
    if(argc >= 2) ofs.open(std::string{argv[1]});
    if(argc >= 3) ifs.open(std::string{argv[2]});

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
