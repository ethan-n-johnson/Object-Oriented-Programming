#include <map>
#include <vector>
#include <fstream>
#include <iterator>
#include <iomanip>
#include "university.h"

typedef std::string State;
typedef std::vector<University> Universities;

template <typename T>
void print_container(const T& t){
    auto it = t;
    std::cout << std::endl;
    for (const auto& uni : it->second) std::cout << uni << std::endl;
}
int main(int argc, char const *argv[]){
    if (argc != 3)
    {
        std::cout << "USAGE: ./univerities enrollment.txt state_abbrev.txt" << std::endl;
        return -1;
    }
    std::ifstream ifs;
    std::ifstream ifs_state;
    ifs.open(std::string(argv[1]));
    ifs_state.open(std::string(argv[2]));
    if (!ifs)
    {
        std::cout << argv[1] << ": file not found" << std::endl;
        return -2;
    }
    if (!ifs_state)
    {
        std::cout << argv[2] << ": file not found" << std::endl;
        return -2;
    }
    
    std::map<State, Universities> university_map;
    std::map<State, std::string> states_map;
    State state; University university;
    while (ifs >> state)
    {
        ifs.ignore();
        ifs >> university;
        if (university_map.find(state) == university_map.end()) university_map[state] = Universities();
        university_map[state].push_back(university);
    }
    std::string state_name;
    while (std::getline(ifs_state, state_name))
    {
        ifs_state >> state;
        ifs_state.ignore();
        states_map[state] = state_name;
    }
    int count = 0;
    for (const auto& states : states_map){
        if (count%4 == 0) std::cout << std::endl;
        std::cout << std::setw(4) << std::left << states.first << std::setw(18) << std::left << states.second;
        count++;
    }
    ifs.close();
    ifs_state.close();
    std::cout << std::endl;
    while(true)
    {
        std::string in_state;
        std::cout << std::endl;
        std::cout << "Which state (2-character abbrevation): ";
        std::cin >> in_state;
        if (university_map.find(in_state) == university_map.end()) std::cout << "No universities found in " << in_state << std::endl;
        else print_container(university_map.find(in_state));
    }
}