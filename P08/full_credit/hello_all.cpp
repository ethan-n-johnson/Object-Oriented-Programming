#include <iostream>
#include <string>
int main(int argc, char* argv[]){
    std::cout << "What is your name? ";
    std::string name;
    std::cin >> name;
    std::cout << "\nHello " << name << std::endl;
}