#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main(int argc, char* argv[]){
    std::vector<std::string> odds;
    std::vector<std::string> *evens = new std::vector<std::string>();

    for (int i = 1; i < argc; i++)
    {
        std::string arg = argv[i];
        if (arg.size() % 2 != 0) odds.push_back(arg);
        else evens->push_back(arg);
    }
    std::sort(odds.begin(), odds.end());
    std::cout << "Odd lengths (sorted):" << std::endl;
    for(std::string s: odds){
        std::cout << s << std::endl;
    }
    
    std::cout << std::endl;

    std::random_shuffle(evens->begin(), evens->end());
    std::cout << "Even lengths:" << std::endl;
    for(std::string s: *evens){
        std::cout << s << std::endl;
    }
    delete(evens);
}