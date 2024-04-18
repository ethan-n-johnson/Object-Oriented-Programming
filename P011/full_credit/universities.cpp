#include <map>
#include <vector>
#include <fstream>
#include <iterator>
#include "university.h"

typedef std::string State;
typedef std::vector<University> Universities;

int main(int argc, char const *argv[]){
    if (argc != 2)
    {
        std::cout << "USAGE: ./univerities enrollment.txt" << std::endl;
        return -1;
    }
    std::ifstream ifs;
    ifs.open(std::string(argv[1]));
    if (!ifs)
    {
        std::cout << argv[1] << ": file not found" << std::endl;
        return -2;
    }
    std::map<State, Universities> map;
    State state; University university;
    while (ifs >> state)
    {
        ifs.ignore();
        ifs >> university;
        if (map.find(state) == map.end()) map[state] = Universities();
        map[state].push_back(university);
    }
    while(true)
    {
        std::string in_state;
        std::cout << std::endl;
        std::cout << "Which state (2-character abbrevation): ";
        std::cin >> in_state;
        auto it = map.find(in_state);
        std::cout << std::endl;
        if (it == map.end()) std::cout << "No universities found in " << in_state << std::endl;
        else for (const auto& uni : it->second) std::cout << uni << std::endl;
    }
}