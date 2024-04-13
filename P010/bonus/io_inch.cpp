#include "inch.h"
#include <fstream>

int main(int argc, char const *argv[])
{
    std::ofstream ofs;
    std::ifstream ifs;
    // look at file handling
    if(argc >= 2) ifs.open(std::string{argv[1]});
    if(argc >= 3) ofs.open(std::string{argv[2]});

    Inch in;
    Inch last_in;
    Inch sum;

    while (ifs.good()){
        ifs >> in;
        if(ifs.eof()) break;
        std::cout << "Writing inputs to " << argv[2] << std::endl;
        ofs << in << std::endl;
        sum = sum + in;
        std::cout <<"Read " << in << " from " << argv[1] << std::endl;
        if (in == last_in) std::cout << "Same length as last time!" << std::endl; 
        if (in != last_in) std::cout << "NOT the same length as last time." << std::endl; 
        if (in < last_in) std::cout << "Bigger than last time." << std::endl; 
        if (in > last_in) std::cout << "Smaller than last time." << std::endl; 
        if (in <= last_in) std::cout << "Bigger or same length as last time." << std::endl; 
        if (in >= last_in) std::cout << "smaller or same length as last time." << std::endl; 
        std::cout << sum << std::endl;
        last_in = in;
    }
    
    while (std::cin.good())
    {
        std::cout << "Enter one or more measurements (in inches): ";
        std::cin >> in;
        ofs << in << std::endl;
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
